package com.zkb.bot.warframe.utils.market;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mikuac.shiro.common.utils.OneBotMedia;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.MarketEnum;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.PrivateAddApi;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.bot.warframe.dao.ErrorWM;
import com.zkb.bot.warframe.dao.Market;
import com.zkb.bot.warframe.dao.MarketKey;
import com.zkb.bot.warframe.dao.MarketStatistic;
import com.zkb.bot.warframe.domain.WarframeAlias;
import com.zkb.bot.warframe.domain.market.WarframeMarketItems;
import com.zkb.bot.warframe.domain.market.WarframeMarketItemsRegular;
import com.zkb.bot.warframe.service.IWarframeAliasService;
import com.zkb.bot.warframe.service.IWarframeMarketItemsService;
import com.zkb.bot.warframe.utils.WarframeStringUtils;
import com.zkb.common.load.ReadAdminConfig;
import com.zkb.common.utils.MessageUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.utils.uuid.UUID;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static com.zkb.bot.enums.WarframeMarketEnum.*;
import static com.zkb.bot.enums.WarframeTypeEnum.*;


@Component
public class MarketItemUtil {

    private static final Logger log = LoggerFactory.getLogger(MarketItemUtil.class);


    /**
     * 查询Warframe Market 上的物品
     *
     * @param bot   bot
     * @param event envent
     */
    public static void marketSelectItem(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        //核查 是否开启Warframe功能
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
            String tra = "";
            boolean seBy = false;
            boolean isMax = false;
            String form = WarframeStringUtils.getMarketForm(event.getRawMessage());
            if (TYPE_WM_PLUGIN.getType().equals(StringUtils.substring(event.getRawMessage(), 0, TYPE_WM_PLUGIN.getType().length()).toUpperCase(Locale.ROOT))) {
                tra = StringUtils.substring(event.getRawMessage(), TYPE_WM_PLUGIN.getType().length(), event.getRawMessage().length());
            }
            if (tra.length() == 0) {
                bot.sendGroupMsg(event.getGroupId(), MessageUtils.message("warframe.marek.keyNot.error"), false);
                return;
            }
            bot.sendGroupMsg(event.getGroupId(), MessageUtils.message("warframe.market.prompt"), false);
            if (event.getRawMessage().contains(WM_MAX.getType())) {
                isMax = true;
                tra = tra.replace(WM_MAX.getType(), "").trim();
            }
            if (event.getRawMessage().contains(WM_BY.getType())) {
                seBy = true;
                tra = tra.replace(WM_BY.getType(), "").trim();
            }
            if ((event.getRawMessage().contains(WM_SET.getType()))) {
                tra = tra.replace(WM_SET.getType(), "").trim();
            }
            tra = tra.replace(form, "").trim();
            MarketKey marketKey = toMarket(tra);
            int msgId = 0;
            if (marketKey == null) {
                Msg.builder().text(MessageUtils.message("warframe.marek.not.error")).sendToGroup(bot, event);
                return;
            }
            String key = marketKey.getKey();
            if (key != null && !"".equals(key)) {
                OneBotMedia oneBotMedia = OneBotMedia.builder()
                        .cache(false)
                        .proxy(false)
                        .timeout(30)
                        .file("http://localhost:" + GetServerPort.getPort() + "/warframe/market/" + UUID.fastUUID() + "/getMarektImage/" + key + "/" + seBy + "/" + isMax + "/" + form+"/"+bot.getSelfId()+"/"+event.getUserId()+"/"+event.getGroupId()+"/"+tra);

                msgId = bot.sendGroupMsg(event.getGroupId(), Msg.builder().img(oneBotMedia).build(), false).getData().getMessageId();

            }
            if (marketKey.getErrorWM() != null && marketKey.getErrorWM().size() != 0) {
                try {
                    msgId = bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/market/" + UUID.fastUUID() + "/getMarektErrImage?er=" + URLEncoder.encode(marketKey.getErrorWM().toString(), "UTF-8")).build(), false).getData().getMessageId();
                } catch (Exception ignored) {
                }
            } else {
                if (msgId == 0) {
                    //未找到任何相匹配的值
                    msgId = bot.sendGroupMsg(event.getGroupId(), MessageUtils.message("warframe.marek.eqNot.error"), false).getData().getMessageId();
                    toErrMsg(bot, event);
                }
            }
            if (msgId == 0) {
                bot.sendGroupMsg(event.getGroupId(), MessageUtils.message("warframe.marek.get.error"), false);
            }

        } else {
            ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
        }
    }

    /**
     * 从数据库中查询物品得Url值
     * 匹配别名与模糊查询
     * 新增正则查询
     *
     * @param key 用户输入得物品名称
     * @return 查询到得结果
     */
    public static MarketKey toMarket(@NotNull String key) {
        //创建实体类 用于存放返回的结果
        MarketKey marketKey = new MarketKey();
        //创建 Market Items Service实体类 用于模糊查询用户输入的值查询
        IWarframeMarketItemsService itemsService = SpringUtils.getBean(IWarframeMarketItemsService.class);
        //创建 Alias Service 实体类 用于匹配用户输入的别名
        IWarframeAliasService aliasService = SpringUtils.getBean(IWarframeAliasService.class);
        //把用户输入的值全部转换成小写
        key = key.toLowerCase(Locale.ROOT).replace("总图","蓝图");
        try {
            WarframeMarketItems items = new WarframeMarketItems();
            //假设用户使用了别名
            //匹配是否使用了别名 查出所有的别名列表并迭代查询
            List<WarframeAlias> aliases = aliasService.selectWarframeAliasList(null);
            //迭代判断 是否使用了别名
            for (WarframeAlias alias : aliases) {
                if (key.contains(alias.getAliasCh())) {
                    key = key.replace(alias.getAliasCh(), alias.getAliasEn());
                    break;
                }
            }
            //使用别名直接模糊查询
            items = itemsService.selectWarframeMarketItemsByItemNameSet(key);
            if(items!=null){
                marketKey.setKey(items.getUrlName());
                marketKey.setItemName(items.getItemName());
                return marketKey;
            }
            //截取用户输入的除最后一个字符所有字符
            String header = key.substring(0, key.length() - 1);
            //取用户输入的最后一个字符
            String end = key.substring(key.length() - 1);

            //使用正则查询
            items = itemsService.selectWarframeMarketItemByItemNameToRegular(new WarframeMarketItemsRegular(header, end));
            if (items != null) {
                marketKey.setKey(items.getUrlName());
                marketKey.setItemName(items.getItemName());
                return marketKey;
            } else {
                header = key.substring(0, key.length() - 2);
                end = key.substring(key.length() - 2);
                //使用正则查询
                items = itemsService.selectWarframeMarketItemByItemNameToRegular(new WarframeMarketItemsRegular(header, end));
                if (items != null) {
                    marketKey.setKey(items.getUrlName());
                    marketKey.setItemName(items.getItemName());
                    return marketKey;
                }
            }
            if (key.toLowerCase(Locale.ROOT).contains("p") && !key.toLowerCase(Locale.ROOT).contains("prime")) {
                key = key.replace("p", "Prime");
            }
            //正则未查询到结果 就是用模糊查询
            items = itemsService.selectWarframeMarketItemsByItemNameSet(key);
            marketKey.setKey(items.getUrlName());
            marketKey.setItemName(items.getItemName());
            //返回结果
            return marketKey;
            //以上两种都为查询到结果 报 Null 异常
        } catch (Exception e) {
            log.error("获取Warframe.Market Item 出错:{}", e.getMessage());
            try {
                //查询用户可能想要查询的物品
                List<WarframeMarketItems> items = itemsService.selectWarframeMarketItemsLikeList(String.valueOf(key.charAt(0)));
                //判断集合是否为空
                if (CollectionUtils.isEmpty(items)) {
                    //根据别名模糊查询用户 可能想要查询的物品名称
                    items = itemsService.selectWarframeMarketItemsLikeList(StringUtils.substringBefore(key, String.valueOf(key.charAt(key.length() - 1))));
                }
                List<ErrorWM> errorWm = new ArrayList<>();
                for (WarframeMarketItems tra : items) {
                    ErrorWM wm = new ErrorWM();
                    wm.setCh(tra.getItemName());
                    errorWm.add(wm);
                }
                marketKey.setErrorWM(errorWm);
                return marketKey;
            } catch (Exception ex) {
                log.error("获取 可能查询的物品名称 报错：{}", ex.getMessage());
            }
        }
        return null;
    }

    /**
     * 给管理员发送可能恶意使用指令的消息
     */
    private static void toErrMsg(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        long admin = ReadAdminConfig.getAdmin();
        if (admin != 0)
            bot.sendPrivateMsg(admin, StringUtils.format("昵称:{}\n{}:在查询" + event.getRawMessage() + "时没有查询到物品\n群号:{}", PrivateAddApi.getPrivateNick(event.getUserId()), event.getUserId(), event.getGroupId()), false);
    }

    /**
     * Warframe Market查询
     *
     * @param form  来自那个平台
     * @param key   url key值
     * @param seBy  false 卖/true 买
     * @param isMax false = max / true = 0
     * @return 实体类
     */
    public Market market(String form, String key, Boolean seBy, Boolean isMax) {
        try {
            Headers.Builder params = new Headers.Builder();
            params.add("platform", form);
            String json = HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/items/" + key + "/orders", "include=item", params);
            if (json.equals("timeout")) {
                return new Market("timeout");
            }
            Market market = JSONObject.parseObject(json).toJavaObject(Market.class);

            market.getPayload().setOrders(orders(market, seBy, isMax));

            for (Market.ItemsInSet items : market.getInclude().getItem().getItems_in_set()) {
                if (items.getUrlName().equals(key)) {
                    List<Market.ItemsInSet> itemsInSets = new ArrayList<>();
                    itemsInSets.add(items);
                    market.getInclude().getItem().setItems_in_set(itemsInSets);
                    break;
                }
            }
            market.setCode("200");

            return market;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 处理Market查询得结果
     *
     * @param market 未处理得源数据
     * @param seBy   是买/卖家
     * @param isMax  是否满级
     * @return 结果
     */
    private List<Market.Orders> orders(Market market, Boolean seBy, Boolean isMax) {
        List<Market.Orders> orders = new ArrayList<>();
        int max = 0;
        boolean flag = market.getPayload().getOrders().get(0).getModRank() != null;
        if (isMax && flag) {
            for (Market.Orders order : market.getPayload().getOrders()) {
                if (order.getModRank() > max) {
                    max = order.getModRank();
                }
            }
        }
        if (seBy) {
            if (isMax && flag) {
                for (Market.Orders order : market.getPayload().getOrders()) {
                    if (!order.getUser().getStatus().equals(MarketEnum.offline.getForm()) && order.getOrderType().equals(MarketEnum.buy.getForm()) && order.getModRank() == max) {
                        orders.add(order);
                    }
                }
            } else {
                //取得所有在线 玩家
                for (Market.Orders order : market.getPayload().getOrders()) {
                    if (!order.getUser().getStatus().equals(MarketEnum.offline.getForm()) && order.getOrderType().equals(MarketEnum.buy.getForm())) {
                        if (order.getModRank() != null) {
                            if (order.getModRank() == 0) {
                                orders.add(order);
                            }

                        } else {
                            orders.add(order);
                        }
                    }
                }
            }
        } else {
            if (isMax && flag) {
                for (Market.Orders order : market.getPayload().getOrders()) {
                    if (!order.getUser().getStatus().equals(MarketEnum.offline.getForm()) && order.getOrderType().equals(MarketEnum.sell.getForm()) && order.getModRank() == max) {
                        orders.add(order);
                    }
                }
            } else {
                //取得所有在线 玩家
                for (Market.Orders order : market.getPayload().getOrders()) {
                    if (!order.getUser().getStatus().equals(MarketEnum.offline.getForm()) && order.getOrderType().equals(MarketEnum.sell.getForm())) {
                        if (order.getModRank() != null) {
                            if (order.getModRank() == 0) {
                                orders.add(order);
                            }

                        } else {
                            orders.add(order);
                        }

                    }
                }
            }
        }
        if (!seBy) {
            //由小到大排序
            orders.sort((Comparator.comparing(Market.Orders::getPlatinum)));
        } else {
            //由大到小排序
            orders.sort(((o1, o2) -> o2.getPlatinum().compareTo(o1.getPlatinum())));
        }

        if (orders.size() > 8) {
            orders = orders.subList(0, 7);
        }
        return orders;
    }

    /**
     * 取Warframe.Market 上某个物品得均价
     *
     * @param key 物品Url
     * @return 结果
     */
    public MarketStatistic marketStatistics(String key) {
        try {
            String json = HttpUtils.sendGetOkHttp("https://api.warframe.market/v1/items/" + key + "/statistics");

            if (json.equals("timeout")) {
                return null;
            }
            JSONObject object = JSONObject.parseObject(json);
            object = JSON.parseObject(object.get("payload").toString());
            JSONObject live = object.getJSONObject("statistics_live");
            List<MarketStatistic._$48hours> live_48hours = live.getJSONArray("48hours").toJavaList(MarketStatistic._$48hours.class);
            List<MarketStatistic._$90days> live_90days = live.getJSONArray("90days").toJavaList(MarketStatistic._$90days.class);
            List<MarketStatistic._$48hours> live_48hour = new ArrayList<>();
            List<MarketStatistic._$90days> live_90day = new ArrayList<>();
            for (int i = live_48hours.size() - 1; i >= 0; i--) {
                if (live_48hour.size() == 0) {
                    live_48hour.add(live_48hours.get(i));
                } else if (!live_48hours.get(i).getOrderType().equals(live_48hour.get(0).getOrderType())) {
                    live_48hour.add(live_48hours.get(i));
                    break;
                }
            }
            for (int i = live_90days.size() - 1; i >= 0; i--) {
                if (live_90day.size() == 0) {
                    live_90day.add(live_90days.get(i));
                } else if (!live_90days.get(i).getOrderType().equals(live_90day.get(0).getOrderType())) {
                    live_90day.add(live_90days.get(i));
                    break;
                }
            }
            MarketStatistic statistic = new MarketStatistic();
            MarketStatistic.Payload payload = new MarketStatistic.Payload();
            MarketStatistic.StatisticsLive statisticsLive = new MarketStatistic.StatisticsLive();
            statisticsLive.set$48hours(live_48hour);
            statisticsLive.set$90days(live_90day);
            payload.setStatisticsLive(statisticsLive);
            statistic.setPayload(payload);
            return statistic;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

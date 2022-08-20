package com.zkb.bot.warframe.utils.market;

import com.alibaba.fastjson.JSONObject;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import com.zkb.bot.enums.FunctionEnums;
import com.zkb.bot.enums.WarframeTypeEnum;
import com.zkb.bot.utils.ErroSendMessage;
import com.zkb.bot.utils.GetProxyOnClons;
import com.zkb.bot.utils.Msg;
import com.zkb.bot.utils.SelectGroupFunctionOnOff;
import com.zkb.bot.warframe.dao.MarketRiven;
import com.zkb.bot.warframe.dao.MarketRivenKey;
import com.zkb.bot.warframe.dao.MarketRivenParameter;
import com.zkb.bot.warframe.domain.WarframeAlias;
import com.zkb.bot.warframe.domain.market.WarframeMarketRiven;
import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTion;
import com.zkb.bot.warframe.domain.market.WarframeMarketRivenTionNick;
import com.zkb.bot.warframe.service.IWarframeAliasService;
import com.zkb.bot.warframe.service.IWarframeMarketRivenService;
import com.zkb.bot.warframe.service.IWarframeMarketRivenTionNickService;
import com.zkb.bot.warframe.service.IWarframeMarketRivenTionService;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.http.HttpUtils;
import com.zkb.common.utils.ip.GetServerPort;
import com.zkb.common.utils.spring.SpringUtils;
import com.zkb.common.utils.uuid.UUID;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MarketRivenUtil {

    private static final Logger log = LoggerFactory.getLogger(MarketRivenUtil.class);

    public static void sendToGroupRiven(@NotNull Bot bot, @NotNull GroupMessageEvent event) {
        if (SelectGroupFunctionOnOff.getGroupFunctionOnOff(event.getGroupId(), FunctionEnums.FUNCTION_WARFRAME)) {
            // 清除指令 TYPE_WR_PLUGIN TYPE_ZKWM_PLUGIN
            String key = event.getRawMessage().toUpperCase(Locale.ROOT).replace(WarframeTypeEnum.TYPE_WR_PLUGIN.getType(), "").replace(WarframeTypeEnum.TYPE_ZKWM_PLUGIN.getType(), "").trim();
            int msgId = 0;
            if ("".equals(key) || key.length() == 0) {
                bot.sendGroupMsg(event.getGroupId(), "请在指令后面携带关键字", false);
                return;
            }
            try {
                msgId = bot.sendGroupMsg(event.getGroupId(), Msg.builder().img("http://localhost:" + GetServerPort.getPort() + "/warframe/market/" + UUID.fastUUID() + "/getMarektRivenImage/" + URLEncoder.encode(key, "UTF-8")).build(), false).getData().getMessageId();
            } catch (UnsupportedEncodingException ignored) {

            }
            if (msgId == 0) {
                bot.sendGroupMsg(event.getGroupId(), "获取失败！请重试！", false);
            }
        } else {
            ErroSendMessage.getFunctionOff(bot, event, FunctionEnums.FUNCTION_WARFRAME);
        }
    }


    public static MarketRiven marketRiven(MarketRivenParameter parameter) {
        try {
            StringBuilder buffer = new StringBuilder();
            buffer.append("https://api.warframe.market/v1/auctions/search?type=riven&weapon_url_name=");
            buffer.append(parameter.getUrlName());
            if (parameter.getUrlName() == null || parameter.getUrlName().trim().length() == 0) {
                return null;
            }
            if (!"".equals(parameter.getPositiveStats()) && parameter.getPositiveStats() != null) {
                //组合Url 紫卡的正面词条
                buffer.append("&positive_stats=").append(parameter.getPositiveStats());
            }
            if (!"".equals(parameter.getNegativeStats()) && parameter.getNegativeStats() != null) {
                //组合Url 紫卡的负面词条
                buffer.append("&negative_stats=").append(parameter.getNegativeStats());
            }
            //任意 极性
            buffer.append("&polarity=any");
            //排序方式
            buffer.append("&sort_by=price_asc");
            //订单的状况 direct 售卖 / auction 拍卖
            buffer.append("&buyout_policy=direct");

            String json;
            if (GetProxyOnClons.getProxyOnClons()) {
                json = HttpUtils.sendGetOkHttpProxy(buffer.toString());
            } else {
                json = HttpUtils.sendGetOkHttp(buffer.toString());
            }
            if (json.equals("timeout")) {
                return null;
            }
            return JSONObject.parseObject(json, MarketRiven.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("api.warframe.market查询紫卡错误：{}",e.getMessage());
            return null;
        }

    }

    //格式化查询结果
    static MarketRiven marketRiven(MarketRiven riven) {

        List<MarketRiven.Auctions> auctions = riven.getPayload().getAuctions();
        List<MarketRiven.Auctions> auctionsList = new ArrayList<>();
        int i = 0;
        for (MarketRiven.Auctions a : auctions) {
            //判断玩家是否在线 或 在游戏中
            if (!"offline".equals(a.getOwner().getStatus())) {
                List<MarketRiven.Attributes> attributesList = a.getItem().getAttributes();
                List<MarketRiven.Attributes> attributes = new ArrayList<>();
                for (MarketRiven.Attributes attribute : attributesList) {
                    MarketRiven.Attributes attributesObj = new MarketRiven.Attributes();
                    attributesObj.setPositive(attribute.getPositive());
                    attributesObj.setValue(attribute.getValue());
                    //获取紫卡词条对应的中文
                    attributesObj.setUrlName(SpringUtils.getBean(IWarframeMarketRivenTionService.class).selectWarframeMarketRivenTionByUrlName(attribute.getUrlName()).getEffect());
                    attributes.add(attributesObj);
                }
                a.getItem().setAttributes(attributes);
                if (i < 4) {
                    auctionsList.add(a);
                    i++;
                } else {
                    break;
                }
            }
        }
        MarketRiven.Payload payload = new MarketRiven.Payload();
        payload.setAuctions(auctionsList);
        riven.setPayload(payload);
        return riven;
    }

    /**
     * 查询MarketRiven的Url值
     */
    static MarketRivenKey toMarketRive(@NotNull String key) {
        MarketRivenKey rivenKey = new MarketRivenKey();
        WarframeMarketRiven riven;
        IWarframeMarketRivenService marketRivenService = SpringUtils.getBean(IWarframeMarketRivenService.class);
        IWarframeAliasService aliasService = SpringUtils.getBean(IWarframeAliasService.class);
        try {
            riven = marketRivenService.selectWarframeMarketRivenByItemName(key).get(0);
            rivenKey.setItemName(riven.getItemName());
            rivenKey.setUrlName(riven.getUrlName());
            return rivenKey;
        } catch (Exception ignored) {
            try {
                key = key.toLowerCase(Locale.ROOT);
                if (!key.contains("prime")) {
                    if (key.contains("p")) {
                        //Key中如果有 p 字符则替换成 Prime
                        key = key.replace("p", " Prime");
                    }
                }
                riven = marketRivenService.selectWarframeMarketRivenByItemName(key).get(0);
                if (riven == null) {
                    //匹配是否使用了别名 查出所有的别名列表并迭代查询
                    List<WarframeAlias> aliases = aliasService.selectWarframeAliasList(null);
                    //迭代判断 是否使用了别名
                    for (WarframeAlias alias : aliases) {
                        if (key.contains(alias.getAliasCh())) {
                            key = key.replace(alias.getAliasCh(), alias.getAliasEn());
                            break;
                        }
                    }
                    riven = marketRivenService.selectWarframeMarketRivenByItemName(key).get(0);
                }
                rivenKey.setItemName(riven.getItemName());
                rivenKey.setUrlName(riven.getUrlName());
                return rivenKey;
            } catch (Exception ignored1) {
                key = key.toLowerCase(Locale.ROOT);
                String nice = null;
                List<WarframeMarketRiven> rivens = marketRivenService.selectWarframeMarketRivenByItemName(String.valueOf(key.charAt(0)));
                if (CollectionUtils.isEmpty(rivens)) {
                    List<WarframeAlias> aliases = aliasService.selectWarframeAliasList(null);
                    //迭代判断 是否使用了别名
                    for (WarframeAlias alias : aliases) {
                        if (key.contains(alias.getAliasCh())) {
                            key = key.replace(alias.getAliasCh(), alias.getAliasEn());
                            nice = alias.getAliasEn();
                            break;
                        }
                    }
                    if (nice != null) {
                        rivens = marketRivenService.selectWarframeMarketRivenByItemName(StringUtils.substringBefore(key, String.valueOf(nice.charAt(nice.length() - 1))));
                    }
                }
                List<MarketRivenKey.ErrMarketRiven> emr = new ArrayList<>();
                for (WarframeMarketRiven r : rivens) {
                    MarketRivenKey.ErrMarketRiven errMarketRiven = new MarketRivenKey.ErrMarketRiven();
                    errMarketRiven.setKey(r.getItemName());
                    emr.add(errMarketRiven);
                }
                rivenKey.setErrMarketRiven(emr);
                return rivenKey;
            }
        }
    }

    /**
     * 查询MarketRiven紫卡的详情
     *
     * @param key 指令字段 例如 zkwm 拉托 -爆率,多重 -有|无
     * @return 紫卡详情
     */
    public static MarketRivenParameter toMarketRiven(@NotNull String key) {

        //判断是否添加额外的条件
        if (!key.contains("-")) {
            //如果没有额外条件直接查询匹配值并返回
            MarketRivenParameter parameter = new MarketRivenParameter();
            MarketRivenKey rivenKey = toMarketRive(key);
            parameter.setItemName(rivenKey.getItemName());
            parameter.setUrlName(rivenKey.getUrlName());
            parameter.setBuyoutPolicy("direct");
            parameter.setSortBy("price_asc");
            return parameter;
        }
        //分割字符串
        List<String> stars = StringUtils.splitToList(key, "-");
        //查询
        MarketRivenKey marketRivenKey = toMarketRive(stars.get(0));
        MarketRivenParameter parameter = new MarketRivenParameter();
        parameter.setItemName(marketRivenKey.getItemName());
        parameter.setUrlName(marketRivenKey.getUrlName());
        parameter.setBuyoutPolicy("direct");
        parameter.setSortBy("price_asc");
        try {
            parameter.setErrMarketRiven(marketRivenKey.getErrMarketRiven());
            if (stars.size() > 1) {
                // 获取Service实例 紫卡词条
                IWarframeMarketRivenTionService tionService = SpringUtils.getBean(IWarframeMarketRivenTionService.class);
                // 获取Service实例 紫卡词条别名
                IWarframeMarketRivenTionNickService tionNickService = SpringUtils.getBean(IWarframeMarketRivenTionNickService.class);
                // 分割字符串获取详细的词条属性
                List<String> stats = StringUtils.splitToList(stars.get(1).replace("，", ","), ",");

                StringBuilder stat = new StringBuilder();
                for (int i = 0; i < stats.size(); i++) {
                    // 查询词条属性相对应的Url
                    WarframeMarketRivenTion ton = tionService.selectWarframeMarketRivenTionByEffectToTion(stats.get(i));
                    if (ton != null) {
                        stat.append(ton.getUrlName());
                        if (i < stats.size() - 1) {
                            stat.append(",");
                        }
                    } else {
                        // 查询词条属性相对应的Url 词条采用别名
                        WarframeMarketRivenTionNick nick = tionNickService.selectWarframeMarketRivenTionNickByNickCh(stats.get(i));
                        if (nick != null) {
                            stat.append(nick.getNickEn());
                            if (i < stats.size() - 1) {
                                stat.append(",");
                            }
                        }
                    }
                }
                parameter.setPositiveStats(stat.toString());
            }

            if (stars.size() > 2) {
                //紫卡有无负词条
                parameter.setNegativeStats(stars.get(2).replace("有", "has").replace("无", "none"));
            }
            return parameter;
        } catch (Exception e) {
            e.printStackTrace();
            return parameter;
        }

    }
}

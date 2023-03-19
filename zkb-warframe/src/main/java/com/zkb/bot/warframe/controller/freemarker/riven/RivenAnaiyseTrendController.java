package com.zkb.bot.warframe.controller.freemarker.riven;

import com.alibaba.fastjson.JSON;
import com.zkb.bot.enums.WarframeRivenTrendTypeEnum;
import com.zkb.bot.warframe.dao.RivenAnaiyseTrend;
import com.zkb.bot.warframe.dao.RivenAnaiyseTrendModel;
import com.zkb.bot.warframe.domain.WarframeRivenAnalyseTrend;
import com.zkb.bot.warframe.domain.WarframeRivenTrend;
import com.zkb.bot.warframe.service.IWarframeRivenAnalyseTrendService;
import com.zkb.bot.warframe.service.IWarframeRivenTrendService;
import com.zkb.bot.warframe.service.IWarframeTranslationService;
import com.zkb.common.utils.MessageUtils;
import com.zkb.common.utils.StringUtils;
import com.zkb.common.utils.spring.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/warframe/riven/anaiyse")
public class RivenAnaiyseTrendController {


    @GetMapping(value = "/{uuid}/getRivenAnaiyseHtml")
    public String getHtml(Model model, @RequestParam("trend") String trend) throws UnsupportedEncodingException {
        RivenAnaiyseTrend anaiyseTrend = JSON.parseObject(trend, RivenAnaiyseTrend.class);

        String s = SpringUtils.getBean(IWarframeTranslationService.class).zhToEnTrim(anaiyseTrend.getWeaponsName());
        if (s == null || s.isEmpty() || s.equals(anaiyseTrend.getWeaponsName())) {
            model.addAttribute("msg", MessageUtils.message("warframe.riven.anaiyse").replaceAll("\n", "<br/>"));
            return "html/rivenError";
        }

        WarframeRivenTrend analyseTrend = new WarframeRivenTrend();
        analyseTrend.setRivenTrendName(s);
        //查询武器紫卡具体的倾向
        List<WarframeRivenTrend> trendList = SpringUtils.getBean(IWarframeRivenTrendService.class).selectWarframeRivenTrendList(analyseTrend);

        List<RivenAnaiyseTrendModel> tms = new ArrayList<>();

        //遍历所有的武器
        for (WarframeRivenTrend rivenTrend : trendList) {
            RivenAnaiyseTrendModel tm = new RivenAnaiyseTrendModel();
            WarframeRivenTrendTypeEnum typeEnum = rivenTrend.getRivenTrendType();
            if (rivenTrend.getTraCh().replace(" ", "").equals(anaiyseTrend.getWeaponsName().replace(" ", ""))) {
                tm.setWeaponName(rivenTrend.getTraCh());
                tm.setRivenName(anaiyseTrend.getRivenName());

            } else {
                tm.setWeaponName(rivenTrend.getTraCh());

            }
            tm.setNewDot(rivenTrend.getRivenTrendNewDot());
            tm.setNewNum(rivenTrend.getRivenTrendNewNum());
            tm.setOldDot(rivenTrend.getRivenTrendOldDot());
            tm.setOldNum(rivenTrend.getRivenTrendOldNum());
            tm.setWeaponType(typeEnum.getDesc());

            List<RivenAnaiyseTrendModel.Attribute> mas = new ArrayList<>();

            for (RivenAnaiyseTrend.Attribute attribute : anaiyseTrend.getC()) {
                WarframeRivenAnalyseTrend analyse = SpringUtils.getBean(IWarframeRivenAnalyseTrendService.class).selectWarframeRivenAnalyseByName(attribute.getName());
                if (analyse == null || analyse.getName() == null) {
                    analyse = SpringUtils.getBean(IWarframeRivenAnalyseTrendService.class).selectWarframeRivenAnalyseByName(StringUtils.substring(attribute.getName(), 1));
                }
                RivenAnaiyseTrendModel.Attribute ma = new RivenAnaiyseTrendModel.Attribute();
                ma.setAttr(String.valueOf(attribute.getAttribute()));
                ma.setName(analyse.getName());
                boolean isNag = attribute.getAttribute() < 0;

                switch (typeEnum) {
                    case SHOTGUN:
                        ma.setLowAttr(
                                String.valueOf(
                                        attribute.getLowAttribute(
                                                Double.valueOf(analyse.getShotgun()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );
                        ma.setHighAttr(
                                String.valueOf(
                                        attribute.getHighAttribute(
                                                Double.valueOf(analyse.getShotgun()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );

                        if (!isNag) {
                            ma.setHighAttrDiff(
                                    String.valueOf(
                                            attribute.getLowAttributeDiff()
                                    )
                            );
                        } else {
                            ma.setLowAttrDiff(
                                    String.valueOf(
                                            attribute.getHighAttributeDiff()
                                    )
                            );
                        }
                        break;
                    case ARCHGUN:
                        ma.setLowAttr(
                                String.valueOf(
                                        attribute.getLowAttribute(
                                                Double.valueOf(analyse.getArchwing()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );
                        ma.setHighAttr(
                                String.valueOf(
                                        attribute.getHighAttribute(
                                                Double.valueOf(analyse.getArchwing()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );

                        if (!isNag) {
                            ma.setHighAttrDiff(
                                    String.valueOf(
                                            attribute.getLowAttributeDiff()
                                    )
                            );
                        } else {
                            ma.setLowAttrDiff(
                                    String.valueOf(
                                            attribute.getHighAttributeDiff()
                                    )
                            );
                        }
                        break;
                    case PISTOL:
                        ma.setLowAttr(
                                String.valueOf(
                                        attribute.getLowAttribute(
                                                Double.valueOf(analyse.getPistol()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );
                        ma.setHighAttr(
                                String.valueOf(
                                        attribute.getHighAttribute(
                                                Double.valueOf(analyse.getPistol()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );

                        if (!isNag) {
                            ma.setHighAttrDiff(
                                    String.valueOf(
                                            attribute.getLowAttributeDiff()
                                    )
                            );
                        } else {
                            ma.setLowAttrDiff(
                                    String.valueOf(
                                            attribute.getHighAttributeDiff()
                                    )
                            );
                        }
                        break;
                    case RIFLE:
                        ma.setLowAttr(
                                String.valueOf(
                                        attribute.getLowAttribute(
                                                Double.valueOf(analyse.getRifle()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );
                        ma.setHighAttr(
                                String.valueOf(
                                        attribute.getHighAttribute(
                                                Double.valueOf(analyse.getRifle()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );

                        if (!isNag) {
                            ma.setHighAttrDiff(
                                    String.valueOf(
                                            attribute.getLowAttributeDiff()
                                    )
                            );
                        } else {
                            ma.setLowAttrDiff(
                                    String.valueOf(
                                            attribute.getHighAttributeDiff()
                                    )
                            );
                        }
                        break;
                    case MELEE:
                        ma.setLowAttr(
                                String.valueOf(
                                        attribute.getLowAttribute(
                                                Double.valueOf(analyse.getMelle()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );
                        ma.setHighAttr(
                                String.valueOf(
                                        attribute.getHighAttribute(
                                                Double.valueOf(analyse.getMelle()),
                                                Double.valueOf(rivenTrend.getRivenTrendNewNum()),
                                                anaiyseTrend.getC().size(),
                                                attribute.getNag(),
                                                isNag
                                        )
                                )
                        );

                        if (!isNag) {
                            ma.setHighAttrDiff(
                                    String.valueOf(
                                            attribute.getLowAttributeDiff()
                                    )
                            );
                        } else {
                            ma.setLowAttrDiff(
                                    String.valueOf(
                                            attribute.getHighAttributeDiff()
                                    )
                            );
                        }
                        break;
                }
                mas.add(ma);
            }
            tm.setAttributes(mas);
            tms.add(tm);
        }
        model.addAttribute("tms", tms);
        return "html/anaiyseTrend";
    }

    @GetMapping(value = "/rivenErrorHtml")
    public String errorHtml(Model model) {
        model.addAttribute("src", "https://i.niupic.com/images/2023/02/27/alan.png");
        model.addAttribute("msg", MessageUtils.message("warframe.riven.anaiyse").replaceAll("\n", "<br/>"));
        return "html/rivenError";
    }

}

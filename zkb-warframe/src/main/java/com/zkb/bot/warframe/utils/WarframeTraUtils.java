package com.zkb.bot.warframe.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zkb.bot.warframe.dao.UserDict;
import com.zkb.bot.warframe.domain.WarframeTranslation;
import com.zkb.bot.warframe.service.impl.WarframeTranslationServiceImpl;
import com.zkb.common.utils.http.HttpUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

@Component
public class WarframeTraUtils {

    @Resource
    WarframeTranslationServiceImpl translate;


    public int getUserDict() {
        UserDict ud = JSON.parseObject(HttpUtils.sendGetOkHttp("https://warframe.huijiwiki.com/api.php?action=query&format=json&prop=revisions&titles=Data%3AUserDict.json&formatversion=2&rvprop=content&rvlimit=1"), UserDict.class);
        JSONObject object = JSON.parseObject(ud.getQuery().getPages().get(0).getRevisions().get(0).getContent().replace("/", "").trim());
        Set<String> Text = object.getJSONObject("Text").keySet();
        Set<String> Category = object.getJSONObject("Category").keySet();
        JSONObject TextO = object.getJSONObject("Text");
        JSONObject CategoryO = object.getJSONObject("Category");
        int i = 0;
        for (String key : Text) {
            String Sk = translate.enToZh(key);
            if (Sk.equals(key)) {
                WarframeTranslation Wt = new WarframeTranslation();
                Wt.setTraEn(key);
                Wt.setTraCh(TextO.getString(key));
                i += translate.insertWarframeTranslation(Wt);
            }
        }
        for (String key : Category) {
            String Sk = translate.enToZh(key);
            if (Sk.equals(key)) {
                WarframeTranslation Wt = new WarframeTranslation();
                Wt.setTraEn(key);
                Wt.setTraCh(CategoryO.getString(key));
                i += translate.insertWarframeTranslation(Wt);
            }
        }

        return i;
    }


}

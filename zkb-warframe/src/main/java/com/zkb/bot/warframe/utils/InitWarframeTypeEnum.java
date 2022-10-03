package com.zkb.bot.warframe.utils;

import com.zkb.bot.warframe.service.impl.WarframeTypeEnumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitWarframeTypeEnum implements CommandLineRunner {

    /**
     * CommandLineRunner的时机为Spring beans初始化之后，因此CommandLineRunner的执行一定是晚于@PostConstruct的。
     * 若有多组初始化操作，则每一组操作都要定义一个CommandLineRunner派生类并实现run()方法。
     * 这些操作的执行顺序使用@Order(n)来设置，n为int型数据。
     */
    @Autowired
    WarframeTypeEnumServiceImpl warframeTypeEnum;

    @Override
    public void run(String... args) throws Exception {
        warframeTypeEnum.init();
    }
}

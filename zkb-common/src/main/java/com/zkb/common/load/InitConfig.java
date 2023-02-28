package com.zkb.common.load;

import com.zkb.common.zero.ZeroConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitConfig implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        if (!ZeroConfig.getTest()) {
            LoadConfig.index();
        }
    }
}

package com.ljw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author lanjuwen
 * @create 2022-04-04  11:39
 */
@Configuration
public class AlphaConfig {

    // bean的名字是方法的名字
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}

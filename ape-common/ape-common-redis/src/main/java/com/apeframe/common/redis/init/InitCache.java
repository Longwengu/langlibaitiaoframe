package com.apeframe.common.redis.init;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitCache implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("123");
        // 那些缓存需要一个预热
    }
}

package com.apeframe.common.mybatisplus.config;

import com.apeframe.common.mybatisplus.intercepter.MybatisPlusAllSqlLog;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfiguration {

    @Bean
    @ConditionalOnProperty(name={"sql.beauty.show"}, havingValue = "true", matchIfMissing = true)
    public MybatisPlusAllSqlLog mybatisPlusAllSqlLog(){
        return new MybatisPlusAllSqlLog();
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}

package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource("classpath:jdbc.properties")//加载外部配置文件
@ComponentScan("com")//扫描com包下的所有组件 可以指定多个包 用逗号隔开在大括号内{"com","org"}
public class JavaConfiguration {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driver}")
    private String driverClassName;
/*
将方法的返回值交给spring容器管理 name属性指定bean的id 作用域默认是单例 也可以通过@Scope注解指定作用域

 */
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
@Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //将数据源注入到jdbcTemplate  jdbctemplate会自动从spring容器中找到数据源
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}

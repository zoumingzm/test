package com.zm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <p>
 *     exclude= DataSourceAutoConfiguration.class
 *     若集成spring-boot-starter-security，将会传递依赖spring-jdbc,
 *     这时除了（HSQL/H2/DERBY）这三类数据库，其他的将需要排除自动配置的数据源，
 *     否则会抛出异常，因为springboot不支持其他数据库自动配置
 * </p>
 * Created by Administrator on 2017/3/6.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}

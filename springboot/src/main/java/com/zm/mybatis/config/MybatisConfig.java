package com.zm.mybatis.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zm.mybatis.moredatasource.DbContextHolder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by zouming on 17-3-10.
 */
@Configuration
@MapperScan(basePackages = "com.zm.mybatis.mapper")
public class MybatisConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() throws Exception{
        Properties properties = new Properties();
        properties.put("driverClassName",environment.getProperty("jdbc.driverClassName"));
        properties.put("url",environment.getProperty("jdbc.url"));
        properties.put("username",environment.getProperty("jdbc.username"));
        properties.put("password",environment.getProperty("jdbc.password"));

        Properties propertiesRead = new Properties();
        propertiesRead.put("driverClassName",environment.getProperty("jdbc.driverClassName.read"));
        propertiesRead.put("url",environment.getProperty("jdbc.url.read"));
        propertiesRead.put("username",environment.getProperty("jdbc.username.read"));
        propertiesRead.put("password",environment.getProperty("jdbc.password.read"));

        return DruidDataSourceFactory.createDataSource(DbContextHolder.getDbType() == DbContextHolder.DbType.MASTER ? properties : propertiesRead);
    }

//    @Bean
//    public DataSource dataSource4Read() throws Exception{
//        Properties properties = new Properties();
//        properties.put("driverClassName",environment.getProperty("jdbc.driverClassName.read"));
//        properties.put("url",environment.getProperty("jdbc.url.read"));
//        properties.put("username",environment.getProperty("jdbc.username.read"));
//        properties.put("password",environment.getProperty("jdbc.password.read"));
//        return DruidDataSourceFactory.createDataSource(properties);
//    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapperLocations")));
        return sqlSessionFactoryBean.getObject();
    }
}

package com.gp6.cloud.configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * MyBatis配置
 *
 * @author gp6
 * @date 2019-09-24
 */
@Configuration
@MapperScan(basePackages = {"com.gp6.cloud.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        // 自动制定Mybatis数据源需要手工设置mapper文件读取的位置
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        factoryBean.setMapperLocations(resources);

        // 添加驼峰匹配
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setConfiguration(configuration);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        // 使用上面配置的Factory
        return new SqlSessionTemplate(sqlSessionFactory());
    }
}



package com.gp6.cloud.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
* 数据库配置
*
* @author gp6
* @date 2019-01-25
*/
@Configuration
public class MysqlConfig {

    private HikariDataSource createDataSource() {
        HikariDataSource datasource = (HikariDataSource) DataSourceBuilder.create().build();
        datasource.setMaximumPoolSize(15);
        datasource.setMinimumIdle(5);
        String connectionTestQuery = "SELECT 1 FROM DUAL";
        datasource.setConnectionTestQuery(connectionTestQuery);
        return datasource;
    }

    /**
     * @return 数据源
     */
    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @ConditionalOnProperty(name = "spring.datasource.used", havingValue = "true")
    public DataSource dataSource() {
        HikariDataSource datasource = createDataSource();
        datasource.setPoolName("datasourcePool");
        return datasource;
    }

    /**
     * 配置数据库事务
     *
     * @param datasource 数据源
     * @return PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager bfTransactionManager(@Qualifier("dataSource") DataSource datasource) {
        return new DataSourceTransactionManager(datasource);
    }

}

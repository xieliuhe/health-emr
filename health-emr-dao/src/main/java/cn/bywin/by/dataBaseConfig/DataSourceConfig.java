package cn.bywin.by.dataBaseConfig;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Hurricane
 * @Date 2018/3/19 0019
 */
@Configuration
public class DataSourceConfig {

    @Bean(initMethod = "init", name = "defaultDataSource")
    @ConfigurationProperties("spring.datasource.druid.default")
    public DataSource defaultDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(initMethod = "init", name = "firstDataSource")
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(initMethod = "init", name = "secondDataSource")
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

   /* @Bean(initMethod = "init", name = "thirdDataSource")
    @ConfigurationProperties("spring.datasource.druid.third")
    public DataSource thirdDataSource(){
        return DruidDataSourceBuilder.create().build();
    }*/

    @Primary
    @Bean(name = "multiDataSource")
    public MultiRouteDataSource routeDataSource() {
        MultiRouteDataSource multiDataSource = new MultiRouteDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.FirstDBName.getDbName(), firstDataSource());
        targetDataSources.put(DataSourceEnum.SecondDBName.getDbName(), secondDataSource());
//        targetDataSources.put(DataSourceEnum.ThirdDBName.getDbName(), thirdDataSource());
        multiDataSource.setTargetDataSources(targetDataSources);
        multiDataSource.setDefaultTargetDataSource(defaultDataSource());
        return multiDataSource;
    }

}


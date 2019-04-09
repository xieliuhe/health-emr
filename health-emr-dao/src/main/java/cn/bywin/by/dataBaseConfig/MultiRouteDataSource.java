package cn.bywin.by.dataBaseConfig;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * @Author Hurricane
 * @Date 2019/4/3 0003
 */
public class MultiRouteDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContext.getDataSource();
    }
}

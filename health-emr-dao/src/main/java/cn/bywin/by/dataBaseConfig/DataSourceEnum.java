package cn.bywin.by.dataBaseConfig;

public enum DataSourceEnum {
    //数据源枚举值
    FirstDBName("firstDataSource"),
    SecondDBName("secondDataSource"),
    ThirdDBName("thirdDataSource"),
    DefaultDBName("defaultDataSource");
    private String dbName;
    private DataSourceEnum(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}

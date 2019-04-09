package cn.bywin.by.dataBaseConfig;

/**
 * @Author Hurricane
 * @Date 2019/4/3 0003
 */
public class DataSourceContext {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String value) {
        contextHolder.set(value);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}

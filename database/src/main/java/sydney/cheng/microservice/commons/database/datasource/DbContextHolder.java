package sydney.cheng.microservice.commons.database.datasource;

import sydney.cheng.microservice.commons.database.constant.DbType;

public class DbContextHolder {

    private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();

    private DbContextHolder() {
        super();
    }

    public static DbType getDbType() {
        return contextHolder.get();
    }

    public static void setDbType(DbType dbType) {
        if (dbType == null) {
            throw new NullPointerException();
        }
        contextHolder.set(dbType);
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}

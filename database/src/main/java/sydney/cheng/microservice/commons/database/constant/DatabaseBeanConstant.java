package sydney.cheng.microservice.commons.database.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class DatabaseBeanConstant {
    public static final String DS_BEAN_NAME = "databaseDataSource";
    public static final String PRIMARY_DS_BEAN_NAME = "databaseDataSourcePrimary";
    public static final String REPLICA_DS_BEAN_NAME = "databaseDataSourceReplica";
}

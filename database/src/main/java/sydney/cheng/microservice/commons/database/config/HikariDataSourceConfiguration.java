package sydney.cheng.microservice.commons.database.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import sydney.cheng.microservice.commons.configuration.properties.database.PrimaryHikariDataSourceProperties;
import sydney.cheng.microservice.commons.configuration.properties.database.ReplicaHikariDataSourceProperties;
import sydney.cheng.microservice.commons.database.constant.DbType;
import sydney.cheng.microservice.commons.database.datasource.RoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

import static sydney.cheng.microservice.commons.database.constant.DatabaseBeanConstant.*;

@Profile(value = {"database"})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Configuration
public class HikariDataSourceConfiguration {
    private final PrimaryHikariDataSourceProperties primaryHikariDataSourceProperties;
    private final ReplicaHikariDataSourceProperties replicaHikariDataSourceProperties;

    @Bean(name = PRIMARY_DS_BEAN_NAME)
    public DataSource primaryDataSource() {
        if (this.primaryHikariDataSourceProperties == null) throw new AssertionError();
        this.primaryHikariDataSourceProperties.setPoolName(PRIMARY_DS_BEAN_NAME);
        return new HikariDataSource(this.primaryHikariDataSourceProperties);
    }

    @Bean(name = REPLICA_DS_BEAN_NAME)
    public DataSource replicaDataSource() {
        if (this.replicaHikariDataSourceProperties == null) throw new AssertionError();
        this.replicaHikariDataSourceProperties.setPoolName(REPLICA_DS_BEAN_NAME);
        return new HikariDataSource(this.replicaHikariDataSourceProperties);
    }

    @Bean(name = {"dataSource", DS_BEAN_NAME})
    public DataSource databaseDataSource() {
        RoutingDataSource rds = new RoutingDataSource();
        rds.setTargetDataSources(Map
                .of(DbType.PRIMARY, this.primaryDataSource(), DbType.REPLICA, this.replicaDataSource()));
        rds.setDefaultTargetDataSource(this.primaryDataSource());
        return rds;
    }
}
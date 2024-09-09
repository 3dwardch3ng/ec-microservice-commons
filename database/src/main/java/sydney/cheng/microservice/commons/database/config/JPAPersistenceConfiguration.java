package sydney.cheng.microservice.commons.database.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import sydney.cheng.microservice.commons.configuration.properties.database.DatabaseProperties;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static sydney.cheng.microservice.commons.database.constant.DatabaseBeanConstant.*;

@Profile(value = {"database & hikari"})
@Configuration
@EnableJpaRepositories(
        basePackages = "sydney.cheng.**.repository",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
public class JPAPersistenceConfiguration {
    private final ConfigurableListableBeanFactory beanFactory;

    private final DatabaseProperties databaseProperties;

    public JPAPersistenceConfiguration(
            ConfigurableListableBeanFactory beanFactory,
            DatabaseProperties databaseProperties
    ) {
        this.beanFactory = beanFactory;
        this.databaseProperties = databaseProperties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(DS_BEAN_NAME) DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setPersistenceUnitName("persistence-unit");
        em.setPackagesToScan(this.databaseProperties.getEntityManager().getPackages());
        em.setDataSource(dataSource);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>(this.databaseProperties.getJpa().getProperties());
        properties.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
        properties.put(AvailableSettings.IMPLICIT_NAMING_STRATEGY, "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
        properties.put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(this.beanFactory));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}

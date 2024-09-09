package sydney.cheng.microservice.commons.database.annotation;

import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Profile("database")
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional("ecTransactionManager")
public @interface DatabaseTransactional {
    boolean readOnly() default false;

    Propagation propagation() default Propagation.REQUIRED;

    Class<? extends Throwable>[] noRollbackFor() default {};
}

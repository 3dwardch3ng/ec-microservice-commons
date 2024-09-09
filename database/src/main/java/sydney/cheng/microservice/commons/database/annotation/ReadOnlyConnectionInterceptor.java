package sydney.cheng.microservice.commons.database.annotation;

import lombok.NoArgsConstructor;
import lombok.ToString;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import sydney.cheng.microservice.commons.database.constant.DbType;
import sydney.cheng.microservice.commons.database.datasource.DbContextHolder;

@Aspect
@ToString
@NoArgsConstructor
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {
    private int order;

    @Override
    public int getOrder() {
        return order;
    }

    @Value("20")
    public void setOrder(int order) {
        this.order = order;
    }

    /*
     * handle interceptor for any public method execution
     */
    @Pointcut(value = "execution(public * *(..))")
    public void anyPublicMethod() {
        throw new UnsupportedOperationException();
    }

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint pjp, ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
            DbContextHolder.setDbType(DbType.REPLICA);
            Object result = pjp.proceed();
            DbContextHolder.clearDbType();
            return result;
        } finally {
            // restore state
            DbContextHolder.clearDbType();
        }
    }
}

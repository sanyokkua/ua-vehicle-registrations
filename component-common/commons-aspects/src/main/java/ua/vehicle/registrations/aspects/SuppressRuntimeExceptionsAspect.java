package ua.vehicle.registrations.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * The type Suppress runtime exceptions' aspect.
 */
@Slf4j
@Aspect
@Component
public class SuppressRuntimeExceptionsAspect extends CommonAspect {

    /**
     * Suppress.
     */
    @Pointcut("@annotation(ua.vehicle.registrations.aspects.annotations.LogExceptions)")
    public void suppress() {
        // Empty because it is just creation of Pointcut
    }

    /**
     * Measure execution time object.
     *
     * @param joinPoint the join point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("suppress()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (RuntimeException ex) {
            log.warn("JointPoint: {} thrown an exception, null is returned",
                    getJointPointInfo(joinPoint), ex
            );
            return null;
        }
    }
}

package ua.vehicle.registrations.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * The type Log exceptions aspect.
 */
@Slf4j
@Aspect
@Component
public class LogExceptionsAspect extends CommonAspect {

    /**
     * Log exceptions.
     */
    @Pointcut("@annotation(ua.vehicle.registrations.aspects.annotations.LogExceptions)")
    public void logExceptions() {
        // Empty because it is just creation of Pointcut
    }

    /**
     * After exception.
     *
     * @param joinPoint the join point
     * @param ex        the ex
     */
    @AfterThrowing(pointcut = "logExceptions()", throwing = "ex")
    public void afterException(JoinPoint joinPoint, Exception ex) {
        var info = getJointPointInfo(joinPoint);
        var arguments = getArguments(joinPoint);
        var exception = ex.toString();
        var exceptionMessage = ex.getMessage();

        log.error("{} with arguments {} has thrown exception: {}, with message: {}",
                info, arguments, exception, exceptionMessage
        );
        log.error("Error", ex);
    }

}

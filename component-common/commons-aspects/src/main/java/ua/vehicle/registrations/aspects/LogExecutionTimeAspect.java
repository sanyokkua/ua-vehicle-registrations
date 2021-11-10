package ua.vehicle.registrations.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalTime;

/**
 * The type Log execution time aspect.
 */
@Slf4j
@Aspect
@Component
public class LogExecutionTimeAspect extends CommonAspect {

    /**
     * Log execution time.
     */
    @Pointcut("@annotation(ua.vehicle.registrations.aspects.annotations.LogTimeMeasures)")
    public void logExecutionTime() {
        // Empty because it is just creation of Pointcut
    }

    /**
     * Measure execution time object.
     *
     * @param joinPoint the join point
     * @return the object
     * @throws Throwable the throwable
     */
    @Around("logExecutionTime()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var start = LocalTime.now();
        var proceed = joinPoint.proceed();
        var finish = LocalTime.now();
        var info = getJointPointInfo(joinPoint);
        var duration = Duration.between(start, finish);
        log.info("JoinPoint: {}, start: {}, finish: {}, time: in min - {}, in sec - {}, in millis - {}, in nano - {}",
                info,
                start,
                finish,
                duration.toMinutes(),
                duration.toSeconds(),
                duration.toMillis(),
                duration.toNanos()
        );
        return proceed;
    }
}

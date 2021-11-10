package ua.vehicle.registrations.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The type Log input and output aspect.
 */
@Slf4j
@Aspect
@Component
public class LogInputAndOutputAspect extends CommonAspect {

    /**
     * Log method params and output.
     */
    @Pointcut("@annotation(ua.vehicle.registrations.aspects.annotations.LogInputOutput)")
    public void logMethodParamsAndOutput() {
        // Empty because it is just creation of Pointcut
    }

    /**
     * Before.
     *
     * @param joinPoint the join point
     */
    @Before("logMethodParamsAndOutput()")
    public void before(JoinPoint joinPoint) {
        var info = getJointPointInfo(joinPoint);
        var arguments = getArguments(joinPoint);
        log.debug("{} invoked with args: {}", info, arguments);
    }

    /**
     * After.
     *
     * @param joinPoint the join point
     */
    @After("logMethodParamsAndOutput()")
    public void after(JoinPoint joinPoint) {
        log.debug("Method {} finished", joinPoint.toShortString());
    }

    /**
     * After return.
     *
     * @param joinPoint the join point
     * @param retVal    the ret val
     */
    @AfterReturning(pointcut = "logMethodParamsAndOutput()", returning = "retVal")
    public void afterReturn(JoinPoint joinPoint, Object retVal) {
        var info = getJointPointInfo(joinPoint);
        var value = Optional.ofNullable(retVal).orElse("null").toString();
        log.debug("{} finished, returned value is {}", info, value);
    }
}

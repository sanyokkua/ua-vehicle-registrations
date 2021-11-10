package ua.vehicle.registrations.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Common aspect.
 */
@Slf4j
public abstract class CommonAspect {

    /**
     * Gets arguments.
     *
     * @param joinPoint the join point
     * @return the arguments
     */
    protected String getArguments(JoinPoint joinPoint) {
        return Arrays.stream(joinPoint.getArgs())
                .map(Optional::ofNullable)
                .map(opt -> opt.orElse("null"))
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    /**
     * Gets joint point info.
     *
     * @param joinPoint the join point
     * @return the joint point info
     */
    protected String getJointPointInfo(JoinPoint joinPoint) {
        var className = joinPoint.getTarget().getClass().getName();
        var method = joinPoint.getSignature().getName();
        return String.format("Class: %s, method: %s", className, method);
    }
}

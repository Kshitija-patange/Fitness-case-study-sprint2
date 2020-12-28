package com.capgemini.fitness.aspect;
import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

/*
 * This is User Logger Aspect class
 */

@Aspect
@Configuration
@Slf4j
public class UserLoggerAspect {

	@Pointcut("execution(* com.capgemini.fitness.controller.UserNewController.*(..))")
	public void applicationPackagePointcut() {

	}

	@Around("applicationPackagePointcut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		try {
			if (log.isDebugEnabled()) {
				log.debug("Entering method : {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
						joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
			}
			try {
				//explictly invoke joinpoint method
				Object result = joinPoint.proceed();
				if (log.isDebugEnabled()) {
					if(joinPoint.getSignature().getName().equals("getUserById")) {
						log.info("Returning details of 1 user");
					}else if(joinPoint.getSignature().getName().equals("updateUser")) {
						log.info("User details updated ");
					}
					else if(joinPoint.getSignature().getName().equals("addUser")) {
						log.info("User Added.");
					}
					else if(joinPoint.getSignature().getName().equals("deleteUser")) {
						log.info("User deleted.");
					}
					log.debug("Exiting method: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
							joinPoint.getSignature().getName(), result);
				}
				return result;
			} catch (Exception e) {
				log.error("Error in {}.{}()", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
				log.error(e.getMessage());
				throw e;
			}
		}catch(Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
}



/**
 * 
 */
package com.jan.enterprise.pos.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jinendra Bakliwal
 *
 */
@Aspect
@Configuration
public class LoggerAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// What kind of method calls I would intercept
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver
	@Before("execution(* com.jan.enterprise.pos.*.*.*(..))")// || execution(* com.jan.enterprise.pos.*.*.*.*(..))")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" Started execution for {}", joinPoint);
	}
	
	@After("execution(* com.jan.enterprise.pos.*.*.*(..))")// || execution(* com.jan.enterprise.pos.*.*.*.*(..))")
	public void after(JoinPoint joinPoint) {
		// Advice
		logger.info(" Completed execution for {}", joinPoint);
	}
}

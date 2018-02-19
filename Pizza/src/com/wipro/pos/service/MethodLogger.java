/**
 * 
 */
package com.wipro.pos.service;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author training
 *
 */
@Component
@Aspect
public class MethodLogger {
	
	public static final Logger log=Logger.getLogger(MethodLogger.class);
	 @Around("execution(* com.wipro.pos..*.*(..))")
	  public Object timeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		  System.out.println("Method  '"+joinPoint.toShortString()+"' is executing");
		log.debug("Method-----"+joinPoint.toShortString());
		    StopWatch stopWatch = new StopWatch();
	    stopWatch.start();

	    Object retVal = joinPoint.proceed();
	  
	    
	    
	   
	    stopWatch.stop();
	    System.out.println("Return val from  '"+joinPoint.getSignature().getName()+"'  method is::"+retVal+"  in "+stopWatch.getTotalTimeMillis()+" ms");
	    StringBuffer logMessageStringBuffer = new StringBuffer();
	    logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
	    logMessageStringBuffer.append(".");
	    logMessageStringBuffer.append(joinPoint.getSignature().getName());
	    logMessageStringBuffer.append("(");
	    logMessageStringBuffer.append(joinPoint.getArgs());
	    logMessageStringBuffer.append(")");
	    logMessageStringBuffer.append(" execution time: ");
	    logMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
	    logMessageStringBuffer.append(" ms");

	    log.error(logMessageStringBuffer.toString());
	    //System.out.println("Log file msg::"+logMessageStringBuffer.toString());
	    
	    return retVal;
	  }
}

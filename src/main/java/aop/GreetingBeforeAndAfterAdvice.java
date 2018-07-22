package aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class GreetingBeforeAndAfterAdvice {
	@Autowired
	HttpServletRequest request;
	
	long startTime,endTime;

//	@Override
	public void afterReturning(){//Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("after");
		endTime = System.currentTimeMillis();
		
		System.out.println("运行时间："+(endTime-startTime)/1000.0);
	}

//	@Override
	public void before(){//Method arg0, Object[] arg1, Object arg2) throws Throwable {
		startTime = System.currentTimeMillis();
		System.out.println(request.getRequestURI());
		System.out.println("before");
	}
	
	@Around("execution(public * controller.*Controller.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		before();
		Object result = pjp.proceed();
		afterReturning();
		return result;
	}

}

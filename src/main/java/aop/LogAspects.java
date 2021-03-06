package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int aop.MathCalculator.*(..))")
    public void poinCut(){}

    @Before("poinCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+" 运行。。。@Before "+ Arrays.asList(args));
    }

    @After("poinCut()")
    public void  logEnd(){
        System.out.println("除法结束..@After");
    }

    @AfterReturning(value = "poinCut()",returning = "result")//获取方法返回值
    public void logReturning(Object result){
        System.out.println("除法正常返回..@AfterReturning "+result);
    }

    @AfterThrowing(value = "poinCut()",throwing = "e")
    public void logException(Exception e){
        System.out.println("除法异常..@AfterThrowing "+e);
    }
}

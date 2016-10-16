package com.spring.mvc.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

//@Component // 让spring知道
//@Aspect // 声明当前类为切面类
//自定义切面，可以作为缓存使用
public class AnnotationAspect implements Ordered{
    private static final String[] DEFAULT_METHOD_PREFIX = new String[] { "select", "query", "find", "get" };
    /**方法前缀*/
    private String[] methodPrefix;
    
    public String[] getMethodPrefix() {
        if(null == methodPrefix){
            return DEFAULT_METHOD_PREFIX; //使用默认
        }
        return methodPrefix;
    }
    
    /**
     * 设置方法前缀
     * @param methodPrefix
     */
    public void setMethodPrefix(String[] methodPrefix) {
        this.methodPrefix = methodPrefix;
    }

    @Pointcut("execution(* com.spring.mvc.service.StudentService.*(..))")
    public void pointCut() {

    }

    // @Before("pointCut()")
    public void before(JoinPoint point) {
        // Returns the signature at the join point.
        // getStaticPart().getSignature() returns the same object
        String methodName = point.getSignature().getName();
        Object[] objs = point.getArgs();
        for (Object obj : objs) {
            System.out.println("<><><><><><><>>" + obj);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++" + methodName);
    }

    // after return advice在返回值之后通知
    // @AfterReturning("pointCut()")
    public void beforeReturn(ProceedingJoinPoint point) {

    }

    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取访问参数
        Object[] args = joinPoint.getArgs();
        for(Object obj : args){
            System.out.println("args: " + obj.getClass().getName() );
        }
        
        //String methodName = joinPoint.getSignature().getName();
        
        //获取参数名称
        final MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        
        String methodName = signature.getName();
        
        String[] paramNames = signature.getParameterNames();
        
        for(String param : paramNames){
            System.out.println(">>>>>>>>>>>>" + param);
        }
        
        String key = "REDIS_KEY_" + methodName.toUpperCase();
        
        System.out.println(key);
        Object result = joinPoint.proceed(args);
        System.out.println("》》》》》》》》》》》》》》》》》》" + result);
        // 返回之前
        return result;
    }

    /**
     * 设置优先级
     */
    @Override
    public int getOrder() {
        return 2;
    }

}

package study.fw.online.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import study.fw.core.context.ContextHolder;

@Aspect
public class StudyControllerClassNameAdvice {

    @Pointcut("execution(* study..controller.*Controller.*(..))")
    private void controllerMethod() {}

    @Before("controllerMethod()")
    public void putClassNameInfoIntoContextHolder(JoinPoint jp) {
        ContextHolder.setContext("CLASS_NAME", jp.getSignature().getDeclaringTypeName());
    }
}

package study.fw.online.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StudyControllerClassNameAdvice {

    @Pointcut("execution(* study..controller.*Controller.*(..))")
    private void controllerMethod() {}

    @Before("controllerMethod()")
    public void putClassNameInfoIntoContextHolder(JoinPoint jp) {
        //ContextHolder.setContext(Constants.CONTROLLER_NAME, jp.getSignature().getDeclaringTypeName());
    }
}

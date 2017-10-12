# fw
spring framework를 공부하며 예외, 전문 처리 등 기본 기능 구현해보기

## 기능
### 1. MVC 모델
[mvc 모델을 위한 스프링 설정](https://github.com/chajs226/study-online/blob/master/README.md)

### 2. 메시지 컨버터(전문 처리)

### 3. Exception 처리
#### *study.fw.online.aspect.StudyControllerExceptionAdvice*
@ControllerAdvice 어노테이션을 클래스 앞에 붙이게 되면 Controller 에서 발생하는 Exception 해당 클래스에서 예외 처리를 하게 될 것이라고 선언하는 것이다.
```java
@ControllerAdvice
public class StudyControllerExceptionAdvice {
     * 업무 프로그램에서 StudyBizException 예외를 던지면  StudyBizException 예외의 ExcetpionHandler로 선언된 
     * handleStudyBizException 함수가 잡아서 처리하게 된다.
     */
    @ExceptionHandler(StudyBizException.class)
    public String handleStudyBizException(StudyBizException e) {
        //Exception 처리
   }
}
```

### 4. ContextHolder 구현
#### *study.fw.online.aspect.StudyControllerClassNameAdvice*
~~~Controller 앞 단에 Pointcut을 걸어서 ContextHolder에 필요한 값을 셋팅함.~~~

### 5. BeanNameGenerator
spring 에서 annotation-drviven component scan을 하게되면, 기본적으로 Bean의 id 클래스명이 된다. 다른 패키지에 동일한 클래스명이 있으면 에러가 발생하는데, 이를 회피하기 위해서 BeanNameGenerator를 만들어서 name-generator로 지정한다.
```xml
<context:component-scan base-package="study.fw.online.aspect" use-default-filters="false" name-generator="study.fw.core.spring.bean.FullyQualifiedBeanNameGenerator">
```
↑ mvc-context-servlet.xml 파일

```java
public class FullyQualifiedBeanNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition){
        return definition.getBeanClassName();
    }
}
```

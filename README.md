# fw
spring framework를 공부하며 예외, 전문 처리 등 기본 기능 구현해보기

## 기능
### 1. MVC 모델
[mvc 모델을 위한 스프링 설정](https://github.com/chajs226/study-online/blob/master/README.md)

### 2. 메시지 컨버터(전문 처리)
#### *annotation-driven*
스프링에서 mvc:annotation-driven은 @requestBody, @responseBody 어노테이션을 만났을 때의 처리를 관장한다. 특정한 message-converter를 구현하지 않는다면 기본적으로 JSON에서 key, value를 꺼내서 VO 객체에 넣는 작업을 해준다. 자체 전문형식을 사용하기 위해 메시지 컨버터 관련 작업을 위한 클래스(studyJsonMessageConverter)를 구현해서 설정하였다.
studyJsonMessageConverter 메시지 컨버터는 MappingJackson2HttpMessageConverter를 상속받는데,  MappingJackson2HttpMessageConverter 는 http 바디부에 있는 Json형태의 메시지를 @RequestBody 다음에 정의된 오브젝트 형식으로 변환하는 작업을 한다. read 부분만 구현함.
```xml	
<mvc:annotation-driven validator="validator">	
	<mvc:message-converters>
		<ref bean="studyJsonMessageConverter" />
	</mvc:message-converters>
</mvc:annotation-driven>
```

### 3. Exception 처리
#### *study.fw.online.aspect.StudyControllerExceptionAdvice*
@ControllerAdvice 어노테이션을 클래스 앞에 붙이게 되면 Controller 에서 발생하는 Exception 해당 클래스에서 예외 처리를 하게 될 것이라고 선언하는 것이다.
```java
@ControllerAdvice
public class StudyControllerExceptionAdvice {
     /*
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
Controller 앞 단에 Pointcut을 걸어서 요청된 controller 이름을 ContextHolder에 셋팅함.
#### *study.fw.online.context.ContextSettingInterceptor*
인터셉터를 통해서 Controller 가 호출되기 전, 앞 단에서 HTTP 로 요청된 Header의 일부 정보를 ContextHolder에 담음.

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

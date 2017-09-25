package study.fw.core.spring.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @author amc
 * 기본 빈이름 전력에 의존하고 싶지 않다면 커스텀 빈이름 전략을 제공할 수 있다. 일단 BeanNameGenerator 인터페이스를 구현하고 아규먼트가 없는 기본 생성자를 만든다.
 * 그 다음 스캐너를 설정할 때 정규화된 클래스명을 제공해라.
 */
public class FullyQualifiedBeanNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition){
        return definition.getBeanClassName();
    }
}

package study.fw.online.aspect;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import study.fw.core.exception.StudyBizException;

/**
 * @author amc
 * @ControllerAdvice 어노테이션은 컨트롤러에서 발생하는 Exception은
 * StudyControllerExceptionAdvice 클래스에서 예외처리를 하게 될 것이라고 선언하는 것이다.
 * ControllerAdvice를 사용하면 개별 컨트롤러가 아니라 전체 어플리케이션에 적용할 수 있게 만들어 준다.
 */
@ControllerAdvice
public class StudyControllerExceptionAdvice {

    /**
     * @param e
     * @return
     * 업무 프로그램에서 StudyBizException 예외를 던지면  StudyBizException 예외의 ExcetpionHandler로 선언된 
     * handleStudyBizException 함수가 잡아서 처리하게 된다.
     */
    @ExceptionHandler(StudyBizException.class)
    public String handleStudyBizException(StudyBizException e) {

        System.out.println("StudyBizException-----");
        return "StudyBizException";
    }


}

package study.fw.core.exception;

/**
 * @author amc
 * AMIS에서 구현된 BusinessException 은 DevOnFrame의 BusinessException을 상속받아서 사용하는데,, DevOnFrame은 RuntimeException을 상속받아 구현한 것이다.
 * 해서, 바로 RuntimeException을 상속받아 구현하였다.
 */
public class StudyBizException extends RuntimeException {

    private static final long serialVersionUID = -170920024329793355L;

    //
    protected Object[] messageParameters;

    public StudyBizException() {
    	
        super();
        
        System.out.println("Bizprint");
    }
}

package study.fw.core.exception;

/**
 * @author amc

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

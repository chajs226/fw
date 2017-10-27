package study.fw.core.binding.message;

/*전문 생성 시, 전문 용도에 따라 StudyDataMessageType 을 셋팅해서, 전문 객체를 생성한다.*/
public class STUDYDataFactory {
    @Deprecated
    public static STUDYData createFromRequest() {
    	STUDYData studyData = new STUDYData();
    	studyData.setMessageType(StudyDataMessageType.FROM_CLIENT);
        return studyData;
    }

    public static STUDYData createForResponse() {
    	STUDYData studyData = new STUDYData();
    	studyData.setMessageType(StudyDataMessageType.TO_CLIENT);
        return studyData;
    }

    public static STUDYData createForRequest() {
    	STUDYData studyData = new STUDYData();
    	studyData.setMessageType(StudyDataMessageType.TO_SERVER);
        return studyData;
    }

    public static STUDYData createFromException() {
    	STUDYData studyData = new STUDYData();
    	studyData.setMessageType(StudyDataMessageType.EXCEPTION);
        return studyData;
    }
}

package study.fw.core.binding.message;

/* Cloneable 객체의 클로닝을 허용하기 위해서는 Cloneable 인터페이스를 구현해야 한다.(clone() 메소드 오버라이드)
 * 객체 클로닝이란.. new연산자를 통한 객체 생성이 아닌, 객체 복사를 통해서 객체를 생성한다. 
 * 이때는 객체의 생성 시, 생성자 메소드를 실행하지 않으며, 객체가 유지하고 있는 상태값들을 그대로 복사하게 된다.
 * 데이터 오브젝트는 서버-클라이언트 메시지를 주고받을 때,, 헤더부 clone등을 위해서 많이 쓰이므로.. cloneable을 구현해서 사용한다.
*/

public class STUDYData implements Cloneable {

	// 메시지 타입(FROM_CLIENT, TO_CLIENT.. 등)
	private StudyDataMessageType messageType;

	// 전문 헤더
	private Header header;
	
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public StudyDataMessageType getMessageType() {
		return messageType;
	}
	
	//TODO: @AccessDeny 기능 추가
	public void setMessageType(StudyDataMessageType messageType) {
		this.messageType = messageType;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}	

}

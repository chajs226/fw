package study.fw.core.binding.message;

public enum StudyDataMessageType {

	/**
	 * 요청 전문 메시지 타입
	 */
	FROM_CLIENT,

	/**
	 * 응답 전문 메시지 타입
	 */
	TO_CLIENT,

	/**
	 * 응답 전문 중 에러 발생 메시지 타입
	 */
	EXCEPTION,

	/**
	 * REST 호출 메시지 타입
	 */
	TO_SERVER;
}

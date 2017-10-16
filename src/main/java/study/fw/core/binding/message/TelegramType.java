package study.fw.core.binding.message;

import org.springframework.format.annotation.DateTimeFormat;

// 열거형 자체가 클래스이기 때문에 열거형 내부에 생성자, 필드, 메소드를 가질 수 있어서 단순히 상수가 아니라 더 많은 역할을 할 수 있다.
public enum TelegramType {

	//enum의 필드 정의. BINARY라는 enum의 필드가 정의되면서 TelegramType의 생성자가 호출된다.
	//즉, BINARY 열거형,, class의 멤버변수의 telegramClasses, telegramCode, dateTimeFormat 의 값이 셋팅된다.
	//telegramClass 로 사용할 type 클래스, telegramCode로 사용할 문자를 설정함
	BINARY(new Class<?>[] { byte[].class }, "B"),
	
	STRING(new Class<?>[] { String.class }, "S");
	
	// <?> : 어떠한 type의 오브젝트도 사용할 수 있다는 의미(wild card)
	// 변수를 지정하고 그 변수를 final로 처리하면,, 한번 설정된 변수의 값은 더이상 바뀌지 않는다. 또한 바뀌지 않는 값이라면,,
	// 인스턴스 변수가 아니라 클래스 변수(static)로 지정하는 것이 더 좋을 것이다. (왜냐.. 고정된 값이라면.. 인스턴스 생성시 마다,,
	// 변수를 생성한다면 비효율적이다. 그냥 static으로 해서, 각 인스턴스에서 값을 공유해서 쓰면 될 것이기 때문이다.)
	private final Class<?>[] telegramClasses;
	private final String telegramCode;
	private DateTimeFormat dateTimeFormat;
	

	//enum 필드의 갯수만큼 생성자가 호출된다.
	private TelegramType(Class<?>[] telegramClasses, String telegramCode) {
		this(telegramClasses, telegramCode, null);
	}
	
	private TelegramType(Class<?>[] telegramClasses, String telegramCode, DateTimeFormat dateTimeFormat) {
		this.telegramClasses = telegramClasses;
		this.telegramCode = telegramCode;
		this.dateTimeFormat = dateTimeFormat;
	}
	
}

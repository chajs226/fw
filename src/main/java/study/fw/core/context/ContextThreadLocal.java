package study.fw.core.context;

import java.util.HashMap;
import java.util.Map;


/**
 * Map<String, Object>를 기반으로 하는 ThreadLocal의 하위클래스
 * 부모 스레드로부터 값을 제공받아 자식 스레드에서 그 값을 사용하기 위해 제공되는 클래스이다. 해서, 자식 스레드에서 값을 변경하기 되면, 다른 스레드에도
 * 영향을 미치게 된다. 이는 자식 스레드가 생성될 때, 부모 스레드의 InheritableThreadLocal에 저장되어 있는 Map객체의 주소값을 자식 스레드로
 * 복사하기 때문이다.
 */
public class ContextThreadLocal extends InheritableThreadLocal<Map<String, Object>> {
	@Override
    protected Map<String, Object> initialValue() {
		return new HashMap<String, Object>();
	}
}

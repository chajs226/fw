package study.fw.core.context;


import java.util.Map;

/**
 * Context를 위한 Thread Local을 관리하는 ContextHolder
 *
 */
public abstract class ContextHolder {
	private static final ContextThreadLocal CONTEXT_HOLDER = new ContextThreadLocal();
//	private static final Logger LOGGER = LoggerFactory.getLogger(ContextHolder.class);
	
	/**
	 * Context를 관리하는 Thread Local에서 현재 thread에 대한 저장 데이타를 모두 remove한다.
	 */
	public static void resetContextHolder() {
		CONTEXT_HOLDER.remove();
	}
	
	/**
	 * Context 전체를 새로 설정한다.
	 * @param context
	 */
	public static void setContext(Map<String, Object> context) {
		if(context == null){
			//throw new Excetion("Context cannot be null.");
		}
		CONTEXT_HOLDER.set(context);
	}
	
	/**
	 * Context에 특정 값을 set한다.
	 * @param key Context key
	 * @param value Context Value
	 */
	public static void setContext(String key, Object value) {
		CONTEXT_HOLDER.get().put(key, value);
	}
	
	/**
	 * Context 전체를 return한다.
	 * @return Context 전체
	 */
	public static Map<String, Object> getContext() {
		return CONTEXT_HOLDER.get();
	}
	
	/**
	 * key에 해당하는 Context를 String 형태로 return 한다.
	 * @param key Context key
	 * @return key에 해당하는 Context value
	 */
	public static String getContext(String key) {
		return (String) CONTEXT_HOLDER.get().get(key);
	}
	
	/**
	 * key에 해당하는 Context를 Object 형태로 return 한다.
	 * @param key Context key
	 * @return key에 해당하는 Context value
	 */
	public static Object getContextObject(String key) {
		return CONTEXT_HOLDER.get().get(key);
	}
	
	/**
	 * key에 해당하는 Context value를 remove한다.
	 * @param key Context key
	 * @return key에 해당하는 기존 Context value. key에 해당하는 기존 Context value가 없는 경우 null을 리턴한다.
	 */
	public static Object remove(String key) {
		return CONTEXT_HOLDER.get().remove(key);
	}
}

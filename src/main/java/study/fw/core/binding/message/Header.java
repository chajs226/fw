package study.fw.core.binding.message;



public class Header implements Cloneable {
	
	public static final int DEBUG = 1;
	
    /**
     * 시스템ID
     */
    private String systemid;
    /**
     * 사용자
     */
    private String user;
    /**
     * IP
     */
    private String ip;
    /**
     * 결과 메시지 ID
     */
    private String messageId;
    /**
     * 결과 메시지
     */
    private String message;
    /**
     * 결과 코드
     */
    private String resultCode;
    /**
     * GUID
     */
    private String guid;
    /**
     * 전문 요청 시간
     */
    private String reqdt;


	/**
     * 전문 응답 시간
     */
    private String resdt;
    /**
     * 해당 서비스 ID
     */
    private String service;
    /**
     * 해당 서비스를 처리한 WAS 구분자
     */
    private String server;
    
    
	public String getSystemid() {
		return systemid;
	}
	 /**
     * systemid setter 메소드. @AccessDeny 어노테이션에 의해 허용된 패키지(프레임워크 패키지) 외에서 접근시에는
     * Exception을 발생시킨다.
     * @param systemid
     *            the systemid to set
     */
    //TODO : @AccessDeny
	public void setSystemid(String systemid) {
		this.systemid = systemid;
	}
	public String getUser() {
		return user;
	}
    /**
     * user setter 메소드. @AccessDeny 어노테이션에 의해 허용된 패키지(프레임워크 패키지) 외에서 접근시에는
     * Exception을 발생시킨다.
     *
     * @param user
     *            the user to set
     */
    // TODO : @AccessDeny
	public void setUser(String user) {
		this.user = user;
	}
	public String getIp() {
		return ip;
	}
	// TODO : @AccessDeny
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMessage() {
		return message;
	}
	// TODO : @AccessDeny
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResultCode() {
		return resultCode;
	}
	// TODO : @AccessDeny
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getGuid() {
		return guid;
	}
	// TODO : @AccessDeny
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getReqdt() {
		return reqdt;
	}
	// TODO : @AccessDeny
	public void setReqdt(String reqdt) {
		this.reqdt = reqdt;
	}
	public String getResdt() {
		return resdt;
	}
	// TODO : @AccessDeny
	public void setResdt(String resdt) {
		this.resdt = resdt;
	}
	public String getService() {
		return service;
	}
	// TODO : @AccessDeny
	public void setService(String service) {
		this.service = service;
	}
    public String getServer() {
        return server;
    }
    /**
     * server setter 메소드
     *
     * @param server
     *            - 해당 서비스를 처리한 WAS 구분자
     */
    //TODO : @AccessDeny
    public void setServer(String server) {
        this.server = server;
    }
	
    /**
     * Header 부 값을 clone해서 새로운 Header 객체를 생성하는 메소드
     */
    @Override
    //TODO : @AccessDeny
    public Header clone() throws CloneNotSupportedException {
        Header newHeader = (Header) super.clone();
        if (newHeader.getServer() == null) {
            //TODO : newHeader.setServer(System.getProperty(Constants.SERVER_NAME, "Undefined"));
        }
        return newHeader;
    }
    
    
    @Override
	public String toString() {
		return "Header [systemid=" + systemid + ", user=" + user + ", ip=" + ip + ", message=" + message
				+ ", resultCode=" + resultCode + ", guid=" + guid + ", reqdt=" + reqdt + ", resdt=" + resdt
				+ ", service=" + service + ", server=" + server + "]";
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}

package study.fw.core.binding;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.UUID;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.JavaType;

import study.fw.core.binding.message.Header;
import study.fw.core.binding.message.STUDYData;
import study.fw.core.binding.message.StudyDataMessageType;

public class StudyJsonMessageConverter extends MappingJackson2HttpMessageConverter {
	
   @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        Object retObj = null;
        
        //TODO : 왜??
        JavaType javaType = getJavaType (type, contextClass);
        // 요청받은 body부를 받아서 byte [] 로 변경하기 위한 변수
        byte[] contentBody = null;
        Header header = null;
        
        try {
        	//요청받은 http 메시지의 헤더부를 분리
        	HttpHeaders httpHeaders = inputMessage.getHeaders();
        	/*헤더부에 있는 key의 값을 검증하는 처리를 할 수 있음*/

        	//body 부 데이터를 byteArray로 변환하여 contentBody에 assign
        	contentBody = IOUtils.toByteArray(inputMessage.getBody());
        	//java object로 변환
        	retObj = getObjectMapper().readValue(contentBody, javaType);
        	
        	//retObj 참조 변수가 참조하고 있는 인스턴스의 실제 타입이 STUDYData라면 true. true 라면.. STUDYData 형변환이 가능하다는 것을 뜻함.
        	if (retObj instanceof STUDYData) {
        		//클라이언트에서 요청된 메시지이므로, 메시지 타입을 FROM_CLIENT로 설정
        		((STUDYData) retObj).setMessageType(StudyDataMessageType.FROM_CLIENT);
        		header = ((STUDYData)retObj).getHeader();        		
        		
        		//TODO: 컨텍스트 홀더에 각종 정보를 저장
        		
        		// GUID 발급(클라이언트에서 받은 header에 GUID가 없으면 GUID를 발번해서 헤더에 셋팅힌다.
        		String guid = (String) (!StringUtils.isEmpty(header.getGuid()) ? header.getGuid() : UUID.randomUUID());
        		header.setGuid(guid);
        		//TODO: logback 처리..
                
        	}
        } catch (IOException ex) {
        	System.out.println(ex.toString());
        	throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
        } finally {
        	
        }
        
        // TODO: Message Validation 처리
/*        if (messageValidators != null) {
            for (MessageValidator<Object> validator : messageValidators) {
                validator.validate(retObj);
            }
        }*/
        
        System.out.println(inputMessage.toString());
        
        return retObj;
   }
	   
}

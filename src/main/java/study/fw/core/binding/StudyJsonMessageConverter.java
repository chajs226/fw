package study.fw.core.binding;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class StudyJsonMessageConverter extends MappingJackson2HttpMessageConverter {
	
   @Override
    public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        Object retObj = null;
        
       // retObj = inputMessage
        
        System.out.println(inputMessage.toString());
        
        return retObj;
   }
	   
}

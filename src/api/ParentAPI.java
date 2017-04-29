package api;

import javax.annotation.PostConstruct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;

public class ParentAPI {
	
	private ObjectMapper mapper;	
	
	@PostConstruct
	private void initializeMapper() {
		mapper = new ObjectMapper();
		Hibernate5Module module = new Hibernate5Module();
		module.disable(Feature.USE_TRANSIENT_ANNOTATION);
		mapper.registerModule(module);		
	}
	
	public String write(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

}

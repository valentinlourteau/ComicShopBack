package api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class JaxRSActivator extends Application {
	
	public JaxRSActivator() {
		// TODO Auto-generated constructor stub
		System.out.println("Je passe dans le constructeur de l'application");
	}
	
	@Override
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> classes = new HashSet<Class<?>>();
	    classes.add(ApiUserAPI.class);
	    return classes;
	}

}

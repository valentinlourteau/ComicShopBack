package api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class JaxRSActivator extends Application {
	
	public JaxRSActivator() {
		// TODO Auto-generated constructor stub
		System.out.println("Je passe dans le constructeur de l'application");
	}

}

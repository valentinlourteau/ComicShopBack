package api;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Singleton
@ApplicationPath("/")
public class JaxRSActivator extends Application {
	
	
	public JaxRSActivator() {
	}
	
	@Override
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> classes = new HashSet<Class<?>>();
	    classes.add(UserAPI.class);
	    classes.add(GuideAPI.class);
	    classes.add(ThemeAPI.class);
	    classes.add(ProduitAPI.class);
	    classes.add(ProduitsCommentairesAPI.class);
	    classes.add(SerieAPI.class);
	    return classes;
	}

}

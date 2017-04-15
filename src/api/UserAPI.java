package api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.User;
import services.UserService;
import utils.Crypter;

@Path("User")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserAPI {

	@Inject
	UserService userService;

	@Path("create")
	@POST
	public Response createUser(User user) {
		if (!userService.checkMandatoryFieldsAreFilled(user))
			return Response.notModified().entity("Veuillez renseigner tout les champs obligatoires").build();
		User newUser = userService.findBy(user.getEmail());
		if (newUser == null) {
			user.setPwd(userService.hashPassword(user.getPwd()));
			userService.persist(user);
			return Response.ok(user).build();
		} else
			return Response.status(Response.Status.CONFLICT).entity(newUser).build();
	}

	@Path("findById")
	@GET
	public Response findUser(@QueryParam("id") Long id) {
		User user = userService.findBy(id);
		if (user == null)
			return Response.noContent().build();
		else
			return Response.ok(user).build();
	}
	
	@Path("authenticate")
	@POST
	public Response authenticateUser(User toTest) {
		User user = null;
		if (toTest.getEmail() == null)
			return Response.status(Status.NOT_ACCEPTABLE).entity(new String("Erreur, email introuvable")).build();
		else if (toTest.getPwd() == null)
			return Response.status(Status.NOT_ACCEPTABLE).entity(new String("Erreur, pwd introuvable")).build();
		else
			user = userService.findBy(toTest.getEmail(), toTest.getPwd());
		if (user != null)
			return Response.status(Status.OK).entity(user).build();
		else
			return Response.status(Status.NOT_FOUND).build();		
				
			}
	
	@GET
	@Path("findAll")
	public Response findAll() {
		return Response.ok(userService.findAll()).build();
	}
	
	@GET
	@Path("changePassword")
	public Response changePassword(@QueryParam("email") String email, @QueryParam("oldPassword") String oldPassword, @QueryParam("newPassword") String newPassword) {
		User user = userService.findBy(email);
		if (user == null)
			return Response.notModified().entity("L'email ne correspond à aucun utilisateur").build();
		if (!userService.verifyPwd(oldPassword, user.getPwd()))
			return Response.notModified().entity("Mot de passe incorrect").build();
		user.setPwd(userService.hashPassword(newPassword));
		userService.merge(user);
		return Response.ok().build();
			
	}

}

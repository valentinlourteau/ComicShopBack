package api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.User;
import services.UserService;

@Path("User")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserAPI extends ParentAPI {

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
			return Response.ok(write(user)).build();
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
			return Response.ok(write(user)).build();
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
			return Response.status(Status.OK).entity(write(user)).build();
		else
			return Response.status(Status.NOT_FOUND).build();		
				
			}
	
	@GET
	@Path("findAll")
	public Response findAll() {
		return Response.ok(write(userService.findAll())).build();
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
	
	@PUT
	@Path("update")
	public Response updateUser(User user) {
		if (user == null)
			return Response.noContent().build();
		User fetched = userService.findBy(user.getId());
//		fetched.setAge(user.getAge());
//		fetched.setEmail(user.getEmail());
//		fetched.setNom(user.getNom());
//		fetched.setPrenom(user.getPrenom());
		fetched.setStatutUtilisateur(user.getStatutUtilisateur());
		userService.merge(fetched);
		return Response.ok().build();
	}
	
	@Path("findAllUsersToRank")
	@GET
	public Response findAllUsersToRank() {
		List<User> users = userService.findAllUsersToRank();
		if (users.isEmpty())
			return Response.noContent().build();
		return Response.ok(write(users)).build();
	}

}

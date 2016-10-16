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

import dao.UserDao;
import entities.User;
import services.UserService;

@Path("User")
public class UserAPI {

	@Inject
	UserDao userDao;

	@Inject
	UserService userService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		System.out.println("Je passe dans le post de apiuser");
		User newUser = userDao.findBy(user.getUsername(), userService.hashPassword(user.getPwd()));
		if (newUser == null) {
			user.setPwd(userService.hashPassword(user.getPwd()));
			userDao.persist(user);
			return Response.ok(user).build();
		} else
			return Response.status(Response.Status.CONFLICT).entity(newUser).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUser(@QueryParam("id") Long id) {
		System.out.println("je passe dans le get");
		User user = userService.findBy(id);
		if (user == null)
			return Response.noContent().build();
		else
			return Response.ok(user).build();
	}

}
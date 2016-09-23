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

import dao.ApiUserDao;
import entities.ApiUser;
import services.ApiUserService;

@Path("ApiUser")
public class ApiUserAPI {

	@Inject
	ApiUserDao apiUserDao;

	@Inject
	ApiUserService apiUserService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(ApiUser user) {
		ApiUser newUser = apiUserDao.findBy(user.getUsername(), apiUserService.hashPassword(user.getPwd()));
		if (newUser == null) {
			user.setPwd(apiUserService.hashPassword(user.getPwd()));
			apiUserDao.persist(user);
			return Response.ok(user).build();
		} else
			return Response.status(Response.Status.CONFLICT).entity(newUser).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUser(@QueryParam("id") Long id) {
		ApiUser user = apiUserService.findBy(id);
		if (user == null)
			return Response.noContent().build();
		else
			return Response.ok(user).build();
	}

}

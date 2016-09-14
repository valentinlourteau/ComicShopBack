package api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.ApiUserDao;
import entities.ApiUser;

@Path("ApiUser")
public class ApiUserAPI {

	@Inject
	ApiUserDao apiUserDao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(ApiUser user) {
		System.out.println("JE PASSE DANS LE POST");
		if (user.getUsername() == null && user.getPwd() == null)
			return Response.status(404).build();
		apiUserDao.persist(user);
		return Response.status(200).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findUser() {
		System.out.println("JE PASSE DANS LE GET");
		return Response.status(200).build();
	}

}

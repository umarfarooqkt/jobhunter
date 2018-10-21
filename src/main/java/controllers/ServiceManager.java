/**
 * 
 */
package controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.JobPostingModel;

/**
 * @author umarf
 * This class manages all requests made to the
 * job-hunt application
 */
@Path("/joblist") 
public class ServiceManager {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Response getAllJobPostings() {
		List<JobPostingModel> list = DatabaseManager.retriveAllJobPostings();
		return Response.ok(list).build();
	}
}

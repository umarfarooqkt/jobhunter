/**
 * 
 */
package controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containstitle")
	public Response getJobPostingsWithTitle(@QueryParam("title") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("containsTitle",type);
		return Response.ok(list).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containscompany")
	public Response getJobPostingsWithCompany(@QueryParam("company") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("containsCompany",type);
		return Response.ok(list).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containslocation")
	public Response getJobPostingsWithLocation(@QueryParam("location") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("containsLocation",type);
		return Response.ok(list).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containstype")
	public Response getJobPostingsWithDate(@QueryParam("type") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("created_at",type);
		return Response.ok(list).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/matchdescription")
	public Response getJobPostingsWithDescription(@QueryParam("description") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsMatching("descriptionMatches",type);
		return Response.ok(list).build();
	}

}

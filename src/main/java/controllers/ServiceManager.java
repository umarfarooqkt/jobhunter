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

	/**
	 * This method returns all the jobpostings
	 * @return response with json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Response getAllJobPostings() {
		List<JobPostingModel> list = DatabaseManager.retriveAllJobPostings();
		return Response.ok(list).build();
	}

	/**
	 * This method returns exact job postings with title for the paramValue
	 * @param title
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containstitle")
	public Response getJobPostingsWithTitle(@QueryParam("title") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("containsTitle",type);
		return Response.ok(list).build();
	}

	/**
	 * This method returns exact job postings with company for the paramValue
	 * @param company
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containscompany")
	public Response getJobPostingsWithCompany(@QueryParam("company") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("containsCompany",type);
		return Response.ok(list).build();
	}

	/**
	 * This method returns exact job postings with location for the paramValue
	 * @param location
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containslocation")
	public Response getJobPostingsWithLocation(@QueryParam("location") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("containsLocation",type);
		return Response.ok(list).build();
	}

	/**
	 * This method returns exact job postings with type for the paramValue
	 * @param type
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/containstype")
	public Response getJobPostingsWithDate(@QueryParam("type") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsWith("containsType",type);
		return Response.ok(list).build();
	}

	/**
	 * This method returns a pattern matched job postings with description for the paramValue
	 * @param description
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/matchdescription")
	public Response getJobPostingsMatchDescription(@QueryParam("description") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsMatching("descriptionMatches",type);
		return Response.ok(list).build();
	}

	/**
	 * This method returns a pattern matched job postings with title for the paramValue
	 * @param description
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/matchtitle")
	public Response getJobPostingsMatchTitle(@QueryParam("title") String type) {
		List<JobPostingModel> list = DatabaseManager.retriveJobspostingsMatching("titleMatches",type);
		return Response.ok(list).build();
	}
}

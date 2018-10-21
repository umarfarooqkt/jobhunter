package datacollection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import models.JobPostingModel;

public class DataCollectorService {
	
	//Attributes 
	private static String URI = "https://jobs.github.com/positions.json?";
	
	/**
	 * Default method; This returns 50 jobs at a time from the API
	 * page indicates the index of 50 jobs the API responds with
	 * @param [page] {1 and above only}
	 * @return {List <JobPostingModel>}
	 */
	public static List<JobPostingModel> getJobData(int page) {
		if(page > 0) {
			URI = URI + "page=" + page;
		}
		Client client = ClientBuilder.newClient();
		GenericType<List<JobPostingModel>> genericList = new GenericType<List<JobPostingModel>>() {};
		List<JobPostingModel> jobPostingList = client
				.target(URI)
				.request(MediaType.APPLICATION_JSON)
				.get(genericList);
		client.close(); // to stop from getting timed out or pooling
		return jobPostingList;
	}
	
	/**
	 * This method returns a 50*numPages jobs posting by making 
	 * numPages of calls to getJobData
	 * @param numPages
	 * @return {List <JobPostingModel>}
	 */
	public static List<JobPostingModel> getNumJobListingPages(int numPages) {
		List<JobPostingModel> jobPostingList = new ArrayList<JobPostingModel>();
		for(int i = 0; i < numPages; i++) {
			jobPostingList.addAll(getJobData(i+1));
		}
		return jobPostingList;
	}
}

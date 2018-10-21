package controllers;

import java.util.List;
import models.JobPostingModel;

public class JobPostingsController {
	
	public static List<JobPostingModel> getAllJobs(){
		return DatabaseManager.retriveAllJobPostings();
	}
}

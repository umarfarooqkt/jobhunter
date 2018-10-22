/**
 * 
 */
package datacollection;

import java.util.List;

import controllers.DatabaseManager;
import models.JobPostingModel;

/**
 * @author umarf
 * This class is for running the data collecting API
 */
public class Main {

	public static void main(String[] args) {
		try {
			List<JobPostingModel> list = DataCollectorService.getNumJobListingPages(10);
			for(JobPostingModel jobPosting: list) {
				DatabaseManager.addJobPosting(jobPosting);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

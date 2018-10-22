package controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.JobPostingModel;
import models.QueryMap;

public class DatabaseManager {

    private static final String PERSISTENCE_UNIT_NAME = "appdb";  
    private static final EntityManagerFactory EMF = 
    		Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private static EntityManager em;
    private static EntityTransaction transaction;
    
    //initializing entity manager 
    static {
    	em = EMF.createEntityManager();
    }
    	
    /**
     * This method adds a job posting to database from the model
     * @param jobPosting [JobPostingModel]
     */
    public static void addJobPosting(JobPostingModel jobPosting) throws Exception {
    	transaction = em.getTransaction();
    	transaction.begin();
    	em.persist(jobPosting);
        transaction.commit();
    }
    
    /**
     * This Method uses SQL to implement a unique addition of the entity
     * @param jobPosting 
     * @throws Exception 
     */
    public static void addUniqueJobPosting(JobPostingModel jobPosting) throws Exception{
    	transaction = em.getTransaction();
    	transaction.begin();
    	String queryString = "INSERT IGNORE INTO jobposting " + 
    			"VALUES ('?','?','?','?','?','?','?','?','?','?','?')";
    	Query query = em.createNativeQuery(queryString);
    	query.setParameter(1, jobPosting.getId());
    	query.setParameter(2, jobPosting.getCompany());
    	query.setParameter(3, jobPosting.getCompany_logo());
    	query.setParameter(4, jobPosting.getCompany_url());
    	query.setParameter(5, jobPosting.getCreated_at());
    	query.setParameter(6, jobPosting.getDescription());
    	query.setParameter(7, jobPosting.getHow_to_apply());
    	query.setParameter(8, jobPosting.getLocation());
    	query.setParameter(9, jobPosting.getTitle());
    	query.setParameter(10, jobPosting.getType());
    	query.setParameter(11, jobPosting.getUrl());
        query.executeUpdate();
        transaction.commit();
    }
    
    /**
     * This method updates the job listing matching the id in the database
     * with the new updated job posting 
     * @param id
     * @param updatedJobPosting
     */
    public static void updateJobPosting(JobPostingModel updatedJobPosting) throws Exception {
    	transaction = em.getTransaction();
    	transaction.begin();
    	JobPostingModel oldJobPosting = em.find(JobPostingModel.class, updatedJobPosting.getId());
    	if(!oldJobPosting.equals(updatedJobPosting)) {
    		em.remove(oldJobPosting);
    		em.persist(updatedJobPosting);
    		transaction.commit();
    	}
    }
    
    /**
     * This method is for deleting the posting from the data base; that matches the id provided 
     * @param id
     * @throws Exception
     */
    public static void deleteJobPosting(String id) throws Exception {
    	transaction = em.getTransaction();
    	transaction.begin();
    	JobPostingModel oldJobPosting = em.find(JobPostingModel.class, id);
    	em.remove(oldJobPosting);
    	transaction.commit();
    }
    
    /**
     * This method gets all the job postings
     * @return {List<JobPostingModel>}
     */
    public static List<JobPostingModel> retriveAllJobPostings() {
    	Query query = em.createNativeQuery(""
    			+ "SELECT * FROM jobposting "
    			+ "ORDER BY created_at ASC", JobPostingModel.class);
    	List<JobPostingModel> Joblist = query.getResultList();
    	return Joblist;
    }
    
    /**
     * This method gets all the job postings with the specific Query, this is only used for contains
     * meaning that only jobs attributes with exact matching
     * @param String [queryType] this is the key for QueryMap; Refer to map for keys {Only keys that use contains}
     * @param String [type] => this is the string that will be searched for
     * @return {List<JobPostingModel>} The return type for
     */
    public static List<JobPostingModel> retriveJobspostingsWith(String queryType, String type) {
    	Query query = em.createNativeQuery(QueryMap.getQuery(queryType), JobPostingModel.class);
    	query.setParameter(1, type);
    	List<JobPostingModel> Joblist = query.getResultList();
    	return Joblist;
    }
    
    /**
     * This method gets all the jobs postings with matching; jobpostings with
     *  the attribute/ database column pattern matching the type will be returned
     * @param [queryType] this is the key for QueryMap; Refer to map
     * for keys {Only keys that use matches} the Keys correspond to jobposting table columns
     * @param [type]
     * @return
     */
    public static List<JobPostingModel> retriveJobspostingsMatching(String queryType, String type) {
    	String appendedType = "%"+type+"%";
    	Query query = em.createNativeQuery(QueryMap.getQuery(queryType), JobPostingModel.class);
    	query.setParameter(1, appendedType);
    	List<JobPostingModel> Joblist = query.getResultList();
    	return Joblist;
    }
}

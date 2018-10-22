package tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import models.JobPostingModel;

public class TestJobPostingModel {

	private String id = "d9b487ea-c8b0-11e8-96be-be4ae03544e5";	
	private String created_at = "Fri Oct 05 15:11:16 UTC 2018";
	private String title = "Web Developer";
	private String location = "4115 Ayrshire Dr. SW, MI US 49418";
	private String type = "Full Time";
	private String description = "The Web Developer is responsible for maintaining ";
	private String how_to_apply = "email";
	private String company = " R3 Continuum LLC";
	private String company_url = "http://www.r3c.com";
	private String url = "http://jobs.github.com/positions/e76d3b62-d0c0-11e8-96b7-cecedb66d3cb";
	private JobPostingModel job;
	
	@Before
	public void setUp() throws Exception {
		job = new JobPostingModel();
		job.setCompany(company);
		job.setTitle(title);
		job.setCompany_url(company_url);
		job.setCreated_at(created_at);
		job.setDescription(description);
		job.setHow_to_apply(how_to_apply);
		job.setUrl(url);
		job.setId(id);
		job.setType(type);
		job.setLocation(location);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetId() throws Exception {
		setUp();
		assertEquals(job.getId(), id);
	}

	@Test
	public final void testSetId() {
		job.setId(id);
		assertEquals(job.getId(), id);
	}

	@Test
	public final void testGetCreated_at () throws Exception {
		setUp();
		assertEquals(job.getCreated_at(), created_at);
	}

	@Test
	public final void testSetCreated_at() {
		job.setCreated_at(created_at);
		assertEquals(job.getCreated_at(), created_at);
	}

	@Test
	public final void testGetTitle() throws Exception {
		setUp();
		assertEquals(job.getTitle(), title);
	}

	@Test
	public final void testSetTitle() {
		job.setTitle(title);
		assertEquals(job.getTitle(), title);
	}

	@Test
	public final void testGetLocation() throws Exception {
		setUp();
		assertEquals(job.getLocation(), location);
	}

	@Test
	public final void testSetLocation() {
		job.setLocation(location);
		assertEquals(job.getLocation(), location);
	}

	@Test
	public final void testGetType() throws Exception {
		setUp();
		assertEquals(job.getType(), type);
	}

	@Test
	public final void testSetType() {
		job.setType(type);
		assertEquals(job.getType(), type);
	}

	@Test
	public final void testGetDescription() throws Exception {
		setUp();
		assertEquals(job.getDescription(), description);
	}

	@Test
	public final void testSetDescription() {
		job.setDescription(description);
		assertEquals(job.getDescription(), description);
	}

	@Test
	public final void testGetHow_to_apply() throws Exception {
		setUp();
		assertEquals(job.getHow_to_apply(), how_to_apply);
	}

	@Test
	public final void testSetHow_to_apply() {
		job.setHow_to_apply(how_to_apply);
		assertEquals(job.getHow_to_apply(), how_to_apply);
	}

	@Test
	public final void testGetCompany() throws Exception {
		setUp();
		assertEquals(job.getCompany(), company);
	}

	@Test
	public final void testSetCompany() {
		job.setCompany(company);
		assertEquals(job.getCompany(), company);
	}

	@Test
	public final void testGetCompany_url() throws Exception {
		setUp();
		assertEquals(job.getCompany_url(), company_url);
	}

	@Test
	public final void testSetCompany_url() {
		job.setCompany_url(company_url);
		assertEquals(job.getCompany_url(), company_url);
	}

	@Test
	public final void testGetUrl() throws Exception {
		setUp();
		assertEquals(job.getUrl(), url);
	}

	@Test
	public final void testSetUrl() {
		job.setUrl(url);
		assertEquals(job.getUrl(), url);
	}

	@Test
	public final void testToString() throws Exception {
		setUp();
		String s = id + ", " + company + ", " +  "null"
				+ ", " + company_url + ", " + created_at + ", " 
				+ description + ", " + how_to_apply + ", " + location
				+ title + ", " + type + ", " + url +" ";
		assertEquals(job.toString(), s);
	}

}

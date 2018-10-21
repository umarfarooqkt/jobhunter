package models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// This is for assigning the table name
@Table(name ="jobposting")
public class JobPostingModel implements Serializable {
	
	//Attributes, these are used to generate columns in the db
	
	/**
	 * This a generated serialVersionUID to be use for deSerializing check
	 */
	private static final long serialVersionUID = 7085681433255907369L;

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="created_at")
	private String created_at;
	
	@Column(name="title")
	private String title;

	@Column(name="location")
	private String location;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="how_to_apply")
	private String how_to_apply;
	
	@Column(name="company")
	private String company;
	
	@Column(name="company_url")
	private String company_url;
	
	@Column(name="url")
	private String url;
	
	private String company_logo;
    
	public String getCompany_logo() {
		return company_logo;
	}

	public void setCompany_logo(String company_logo) {
		this.company_logo = company_logo;
	}

	//Default constructor, is required for entity type
	public JobPostingModel() {}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCreated_at() {
		return created_at;
	}
	
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHow_to_apply() {
		return how_to_apply;
	}
	
	public void setHow_to_apply(String how_to_apply) {
		this.how_to_apply = how_to_apply;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getCompany_url() {
		return company_url;
	}
	
	public void setCompany_url(String company_url) {
		this.company_url = company_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		String values = id + ", " + company + ", " +  company_logo
				+ ", " + company_url + ", " + created_at + ", " 
				+ description + ", " + how_to_apply + ", " + location
				+ title + ", " + type + ", " + url +" ";
		return values;
	}
}
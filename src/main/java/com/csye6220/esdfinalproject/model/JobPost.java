package com.csye6220.esdfinalproject.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table
public class JobPost {



@Override
	public String toString() {
		return "JobPost [JobId=" + jobId + ", CompanyName=" + companyName + ", Title=" + title + ", Salary=" + salary
				+ ", JobDescription=" + jobDescription + ", Location=" + location + "]";
	}

	public JobPost() {
		
	}
	
	public JobPost(String location, String companyName, String title) {
		this.location=location;
		this.companyName=companyName;
		this.title=title;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@jakarta.persistence.Column(name = "id")
	private long jobId;
	
	@Column
	private String companyName;
	
	@Column
	private String title;
	
	@Column
	private String salary;
	
	@Column
	private String jobDescription;
	
	@Column
	private String location;
	
	@OneToMany(mappedBy="jobPost",fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<ApplyJob> applyJobs= new HashSet<>();
	
//	@ManyToMany(mappedBy="jobPost",fetch = FetchType.EAGER)
//	private Set<User> user=new HashSet<>();
	
	
	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	
		public String getLocation() {
				return location;
			}
		
			public void setLocation(String location) {
				this.location = location;
			}

			public Set<ApplyJob> getApplyJobs() {
				return applyJobs;
			}

			public void setApplyJobs(Set<ApplyJob> applyJobs) {
				this.applyJobs = applyJobs;
			}	
	

}

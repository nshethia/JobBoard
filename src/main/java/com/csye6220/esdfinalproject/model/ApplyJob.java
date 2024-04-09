package com.csye6220.esdfinalproject.model;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.*;


@Entity
@Table(name="ApplyJobs")
public class ApplyJob {
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@jakarta.persistence.Column(name = "id")
	private long id;
	@Column
	private String first;
	@Column
	private String last;
	@Column
	private String email;
	@Column
	private String cellphone;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zip;
	
	@Column(name="resume_path")
	private String resumePath;
	@Transient
	private MultipartFile resume;
	
	
	@Column(name="documents_path")
	private String documentsPath;
	@Transient
	private MultipartFile documents;
	
	
	public String getResumePath() {
		return resumePath;
	}

	public void setResumePath(String resumePath) {
		this.resumePath = resumePath;
	}

	public String getDocumentsPath() {
		return documentsPath;
	}

	public void setDocumentsPath(String documentsPath) {
		this.documentsPath = documentsPath;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="posting_id")
	private JobPost jobPost;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="user_jobs",
			joinColumns=@JoinColumn(name="applyJob_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	private Set<User> users= new HashSet<>();
	
	
	public ApplyJob() {
		
	}
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public MultipartFile getDocuments() {
		return documents;
	}
	public void setDocuments(MultipartFile documents) {
		this.documents = documents;
	}

	public JobPost getJobPost() {
		return jobPost;
	}

	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	

}

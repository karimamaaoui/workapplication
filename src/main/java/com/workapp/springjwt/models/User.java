package com.workapp.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Gender genre;
	
	@Column(nullable=true)
	@Size(max = 50)
	private String firstName;

	@Column(nullable=true)
	@Size(max = 50)
	private String lastName;
	
	@Column(nullable=true)
	private Long phone;

	@Column(nullable=true)
	private String hightDegres;

	@Column(nullable=true)
	private Long issuedBy;

	@Column(nullable=true)
	private Long yearOfPassing;

	@Column(nullable=true)
	@Size(max = 100)
	private String jobType;
	
	@Column(nullable=true)
	@Size(max = 255)
	private String skill;
	

	@Column(nullable=true)
	@Size(max = 255)
	private String jobApplyFor;

	@Column(nullable=true)
	@Size(max = 255)
	private String workExperience;

	@Column(nullable=true)
	private Long expectedSalary;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}


	public User(  String username,  String email,
			 String password, Gender genre,  String firstName,
			 String lastName, Long phone, String hightDegres, Long issuedBy,
			Long yearOfPassing, String jobType,  String skill,
			String jobApplyFor, String workExperience, Long expectedSalary,
			Set<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.genre = genre;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.hightDegres = hightDegres;
		this.issuedBy = issuedBy;
		this.yearOfPassing = yearOfPassing;
		this.jobType = jobType;
		this.skill = skill;
		this.jobApplyFor = jobApplyFor;
		this.workExperience = workExperience;
		this.expectedSalary = expectedSalary;
		this.roles = roles;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Gender getGenre() {
		return genre;
	}

	public void setGenre(Gender genre) {
		this.genre = genre;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getHightDegres() {
		return hightDegres;
	}

	public void setHightDegres(String hightDegres) {
		this.hightDegres = hightDegres;
	}

	public Long getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(Long issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Long getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(Long yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getJobApplyFor() {
		return jobApplyFor;
	}

	public void setJobApplyFor(String jobApplyFor) {
		this.jobApplyFor = jobApplyFor;
	}

	public String getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	public Long getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(Long expectedSalary) {
		this.expectedSalary = expectedSalary;
	}
	
}

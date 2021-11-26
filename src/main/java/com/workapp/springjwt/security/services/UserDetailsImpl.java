package com.workapp.springjwt.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.workapp.springjwt.models.User;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;
	private String email;
	@JsonIgnore
	private String password;
	
	private String firstName;
	private Long phone;
	private String lastName;
	private String hightDegres;

	private Long issuedBy;
	private Long yearOfPassing;
	private String skill;
	private String jobType;
	
	private String jobApplyFor;
	private String workExperience;
	private Long expectedSalary;

	
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String email, String password,
			 String firstName,
	 Long phone,
	 String lastName,
	 String hightDegres,
	 Long issuedBy,
	 Long yearOfPassing,
	 String skill,
	 String jobType,
	 String jobApplyFor,
	 String workExperience,
	 Long expectedSalary,

			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
		this.hightDegres=hightDegres;
		this.issuedBy=issuedBy;
		this.yearOfPassing=yearOfPassing;
		this.skill=skill;
		this.jobType=jobType;
		this.jobApplyFor=jobApplyFor;
		this.workExperience=workExperience;
		this.expectedSalary=expectedSalary;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(), 
				user.getFirstName(),
				 user.getPhone(),
				 user.getLastName(),
				 user.getHightDegres(),
				 user.getIssuedBy(),
				 user.getYearOfPassing(),
				 user.getSkill(),
				 user.getJobType(),
				 user.getJobApplyFor(),
				 user.getWorkExperience(),
				 user.getExpectedSalary(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastname() {
		return lastName;
	}
	public Long getPhone() {
		return phone;
	}
	@Override
	public String getUsername() {
		return username;
	}
	
	
	 public String hightDegres() {
		 return hightDegres;
	 }
	 public Long issuedBy() {
		 return issuedBy;
	 }
	 
	 public Long yearOfPassing() {
		 return yearOfPassing;
	 }
	 
	 public String skill ()
	 {
		 return skill;
	 }
	 
	 public String jobType()
	 {
		 return jobType;
	 }
	 
	 public String jobApplyFor()
	 {
		 return jobApplyFor;
	 }
	 
	 public String workExperience() {
		 return workExperience;
	 }
	 
	 public Long expectedSalary() {
		 return expectedSalary;
	 }

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}

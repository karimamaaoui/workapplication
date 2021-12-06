package com.workapp.springjwt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Entity
@Table(name = "offre")
public class Offre {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column()
		private Long posteNumber;

		@Column()
		private Date published;

	
		@Column()
		private String jobRequirements;
		
		@Column(length = 50)
		private String email;
		

		@Column()
		private String description;
		
		@Column(length = 30)
		private String country;
		
		@Column(length = 20)
		private String title;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Offre( Long posteNumber, String title, String jobRequirements, String email, String country,
				Date published, String description) {
			super();
			this.posteNumber = posteNumber;
			this.published = published;
			this.jobRequirements = jobRequirements;
			this.email = email;
			this.country = country;
			this.title = title;
			this.description=description;
		}

				
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Offre()
		{
			
		}

		public Long getPosteNumber() {
			return posteNumber;
		}

		public void setPosteNumber(Long posteNumber) {
			this.posteNumber = posteNumber;
		}



		public String getJobRequirements() {
			return jobRequirements;
		}

		public void setJobRequirements(String jobRequirements) {
			this.jobRequirements = jobRequirements;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		
		public Date getPublished() {
			return published;
		}

		public void setPublished(Date published) {
			this.published = published;
		}

		
		
}

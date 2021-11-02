package com.workapp.springjwt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Entity
@Table(name = "offre")
public class Offre {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		@Column(length = 20)
		private String name;
		
		@Column(length = 20)
		private String title;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Offre(Integer id, String name,String title) {
			super();
			this.id = id;
			this.name = name;
			this.title = title;

		}
		
		public Offre()
		{
			
		}

}

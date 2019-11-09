package com.chika.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;



@Entity
@Table(name = "workerhub", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email") 
	})
public class Worker {
  
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="id")
	    private Long work_id;
	    
		@Column(name = "email")
		@Email
		@Valid
		private String email;
		
		@Column(name = "firstname")
		private String firstname;
		
		@Column(name = "lastname")
		private String lastname;

		@Column(name = "password")
		@Transient
		@Size(min=6, max = 100)
		private String password;
		 
		@NotBlank
	    @Size(min=3, max = 70)
		@Column(name = "username")
	    private String username;

		 @OneToOne(cascade =CascadeType.ALL)
		 @JoinColumn(name = "user_id")
	    private User user;
		
		@ManyToOne
		@JoinColumn(name="serviceCenter_id", nullable=false)
		private ServiceCenter serviceCenter;
		
		 public Worker () {}

		public Long getWork_id() {
			return work_id;
		}

		public void setWork_id(Long work_id) {
			this.work_id = work_id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public ServiceCenter getServiceCenter() {
			return serviceCenter;
		}

		public void setServiceCenter(ServiceCenter serviceCenter) {
			this.serviceCenter = serviceCenter;
		}
		 
}

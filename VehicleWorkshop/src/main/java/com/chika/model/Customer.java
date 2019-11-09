package com.chika.model;


import java.util.*;

import javax.persistence.*;
import javax.validation.Valid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.Transient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "customer", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email") 
		})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;
    
    @Size(min=3, max = 50)
    @Column(name = "firstname")
	private String firstname;
	
    @Size(min=3, max = 50)
	@Column(name = "lastname")
	private String lastname;
	
    @Size(min=3, max = 50)
	@Column(name = "phoneno")
    private String phoneno;
	
	 @NaturalId
	 @NotBlank
	 @Size(max = 50)
     @Valid
     @Column(name = "email")
     private String email;
	
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

	public Customer() {}


	public Customer( String firstname, String lastname,
			 String phoneno, String email,
			String password,String username) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
		this.username = username;
	}


	public Long getCust_id() {
		return cust_id;
	}


	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
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


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private List<MaintenanceRequest> maintenanceRequest = new ArrayList<>();
	
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
   @JsonIgnoreProperties("customer")
   private List<Vehicle> vehicle = new ArrayList<>();
    
   @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
   private ServiceCenter serviceCenter;


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

	public List<MaintenanceRequest> getMaintenanceRequest() {
		return maintenanceRequest;
	}


	public void setMaintenanceRequest(List<MaintenanceRequest> maintenanceRequest) {
		this.maintenanceRequest = maintenanceRequest;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}
	


package com.chika.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;



@Entity
@Table(name="MaintenanceRequesthub")
public class MaintenanceRequest{
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long maintenanceRequest_id;

@Column(name = "firstname")
private String firstname;

@Column(name = "lastname")
private String lastname;

@Column(name = "phoneno")
private String phoneno;

@Email
@Valid
@Column(name = "email")
private String email;

@ElementCollection
@Enumerated(EnumType.STRING)
private Set<Request> requests = new HashSet<>();


@ManyToOne
@JoinColumn(name="serviceCenter_id", nullable=false)
private ServiceCenter serviceCenter;

@ManyToOne
@JoinColumn(name="vehicle_id", nullable=false)
private Vehicle vehicle;

@ManyToOne
@JoinColumn(name="cust_id", nullable=false)
private Customer customer;


public MaintenanceRequest () {}


public MaintenanceRequest(Long maintenanceRequest_id, String firstname, String lastname, String phoneno,
		String email) {
	super();
	this.maintenanceRequest_id = maintenanceRequest_id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.phoneno = phoneno;
	this.email = email;
}


public Long getMaintenanceRequest_id() {
	return maintenanceRequest_id;
}


public void setMaintenanceRequest_id(Long maintenanceRequest_id) {
	this.maintenanceRequest_id = maintenanceRequest_id;
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


public Set<Request> getRequests() {
	return requests;
}


public void setRequests(Set<Request> requests) {
	this.requests = requests;
}


public Vehicle getVehicle() {
	return vehicle;
}


public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}


public Customer getCustomer() {
	return customer;
}


public void setCustomer(Customer customer) {
	this.customer = customer;
}


public ServiceCenter getServiceCenter() {
	return serviceCenter;
}


public void setServiceCenter(ServiceCenter serviceCenter) {
	this.serviceCenter = serviceCenter;
}


}
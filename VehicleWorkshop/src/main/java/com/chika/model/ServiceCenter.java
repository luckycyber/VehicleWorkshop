package com.chika.model;



import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;


@Entity
@Table(name = "servicehub")
public class ServiceCenter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceCenter_id;

    @Column(name = "branch_name")
    private String branchName;
    
    @Email
    @Valid
    @Column(name = "email")
    private String email;
    
    @Column(name = "phoneno")
    private String phoneno;
    
    @Column(name = "address")
    private String address;

    
   @OneToMany(mappedBy="serviceCenter", cascade = CascadeType.ALL)
   private List<Vehicle> vehicles = new ArrayList<>();
   
   @OneToMany(mappedBy="serviceCenter", cascade = CascadeType.ALL)
   private List<MaintenanceRequest> maintenanceRequests = new ArrayList<>();

   @OneToMany(mappedBy="serviceCenter", cascade = CascadeType.ALL)
   private List<Worker> workers = new ArrayList<>();
   
    @ManyToOne
    @JoinColumn(name="cust_id", nullable=false)
    private Customer customer;

    public ServiceCenter () {}

	public Long getServiceCenter_id() {
		return serviceCenter_id;
	}

	public void setServiceCenter_id(Long serviceCenter_id) {
		this.serviceCenter_id = serviceCenter_id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<MaintenanceRequest> getMaintenanceRequests() {
		return maintenanceRequests;
	}

	public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests) {
		this.maintenanceRequests = maintenanceRequests;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	
}

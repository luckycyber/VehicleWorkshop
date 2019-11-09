package com.chika.model;


import java.util.*;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vehiclehub")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;

    @Column(name="vehicle_number")
    private String vehicleNumber;
    
    @Column(name="vehicle_model")
    private String vehicleModel;


    @Column(name="vehicle_brand")
    private String vehicleBrand;
    
    @Column(name="warranty_Start_Date")
    @Temporal(TemporalType.DATE)
    private Date warrantyStartDate = new Date();

    @Column(name="warranty_End_Date")
    @Temporal(TemporalType.DATE)
    private Date warrantyEndDate = new Date();

    
    @ManyToOne
    @JoinColumn(name="serviceCenter_id", nullable=false)
    private ServiceCenter serviceCenter;

    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    @JsonIgnoreProperties("vehicle")
    private Customer customer;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="vehicle", orphanRemoval=true)
    private List< MaintenanceRequest> maintenanceRequests = new ArrayList<>();

	public List<MaintenanceRequest> getMaintenanceRequests() {
		return maintenanceRequests;
	}

	public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests) {
		this.maintenanceRequests = maintenanceRequests;
	}

	public Long getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public Date getWarrantyStartDate() {
		return warrantyStartDate;
	}

	public void setWarrantyStartDate(Date warrantyStartDate) {
		this.warrantyStartDate = warrantyStartDate;
	}

	public Date getWarrantyEndDate() {
		return warrantyEndDate;
	}


	public void setWarrantyEndDate(Date warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
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

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", vehicleNumber=" + vehicleNumber + ", vehicleModel="
				+ vehicleModel + ", vehicleBrand=" + vehicleBrand + ", warrantyStartDate=" + warrantyStartDate
				+ ", warrantyEndDate=" + warrantyEndDate + ", customer=" + customer + "]";
	}
    
	
}


package com.chika.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.chika.service.MaintenanceRequestService;
import com.chika.model.MaintenanceRequest;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/maintenancerequest")

public class MaintenanceRequestController {

	   
	    @Autowired
	    private MaintenanceRequestService requestServ;
	               
        @GetMapping("/{maintenanceRequest_id}")
        public ResponseEntity <MaintenanceRequest>getMaintenanceRequestById(@PathVariable("maintenanceRequest_id") Long MaintenanceRequest_id) {
	    MaintenanceRequest sus = requestServ.getMaintenanceRequestById(MaintenanceRequest_id);
	        	            
	    return new ResponseEntity<MaintenanceRequest>(sus,HttpStatus.OK);
	       }
	        	        
	       @GetMapping("/mas")
	      public ResponseEntity <List<MaintenanceRequest>>getAllMaintenanceRequest() {
	      List<MaintenanceRequest> sus = requestServ.getAllMaintenanceRequest();            
	        return new ResponseEntity<>(sus,HttpStatus.OK);
	        	        }
	       @PostMapping("/mu")
	       public ResponseEntity<Void> MaintenanceRequest(@RequestBody MaintenanceRequest sus, UriComponentsBuilder builder){
	       MaintenanceRequest flag = requestServ.addMaintenanceRequest(sus);
	       if(flag==null)
	       return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	       HttpHeaders header = new HttpHeaders();
	       header.setLocation(builder.path("/mu")
	        .buildAndExpand(sus.getMaintenanceRequest_id()).toUri());
	       return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	         }
	        	       
	         @PutMapping("mo/{maintenanceRequest_id}")
	        	        public ResponseEntity<MaintenanceRequest> updateCustomer(@RequestBody MaintenanceRequest sus){
	        	        requestServ.updateMaintenanceRequest(sus);
	        	         return new ResponseEntity<MaintenanceRequest>(sus, HttpStatus.OK);
	        	         
	        	     }
	        	        @DeleteMapping("/mi/{maintenanceRequest_id}")
	        	        public ResponseEntity<MaintenanceRequest> deleteMaintenanceRequest(@PathVariable("maintenanceRequest_id") Long maintenanceRequest_id){
	        	        	MaintenanceRequest sus =requestServ.getMaintenanceRequestById(maintenanceRequest_id);
	        	        	requestServ.deleteMaintenanceRequest(sus);
	        	         return new ResponseEntity<MaintenanceRequest>(sus, HttpStatus.OK);
	        	         
	        	     }
	        	    }

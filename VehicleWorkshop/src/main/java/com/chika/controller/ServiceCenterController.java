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



import com.chika.model.ServiceCenter;
import com.chika.service.ServiceCenterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="servicecenter")
public class ServiceCenterController {
    
    @Autowired
    private ServiceCenterService enterServ;
   
    	    
    	       
    	        @GetMapping("/{serviceCenter_id}")
    	        public ResponseEntity <ServiceCenter>getServiceCenterById(@PathVariable("serviceCenter_id") Long ServiceCenter_id) {
    	        	ServiceCenter sus = enterServ.getServiceCenterById(ServiceCenter_id);
    	            
    	            return new ResponseEntity<ServiceCenter>(sus,HttpStatus.OK);
    	        }
    	        
    	        @GetMapping("/sers")
    	        public ResponseEntity <List<ServiceCenter>>getAllServiceCenter() {
    	            List<ServiceCenter> sus = enterServ.getAllServiceCenter();            
    	            return new ResponseEntity<>(sus,HttpStatus.OK);
    	        }
    	        @PostMapping("/su")
    	           public ResponseEntity<Void> ServiceCenter(@RequestBody ServiceCenter sus, UriComponentsBuilder builder){
    	        	ServiceCenter flag = enterServ.addServiceCenter(sus);
    	            if(flag==null)
    	               return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	            HttpHeaders header = new HttpHeaders();
    	            header.setLocation(builder.path("/su")
    	                    .buildAndExpand(sus.getServiceCenter_id()).toUri());
    	            return new ResponseEntity<Void>(header, HttpStatus.CREATED);
    	        }
    	       
    	        @PutMapping("si/{serviceCenter_id}")
    	        public ResponseEntity<ServiceCenter> updateServiceCenter(@PathVariable("serviceCenter_id") Long serviceCenter_id, @RequestBody ServiceCenter sus){
    	        enterServ.updateServiceCenter(serviceCenter_id, sus);
    	         return new ResponseEntity<ServiceCenter>(sus, HttpStatus.OK);
    	         
    	     }
    	        @DeleteMapping("/sa/{serviceCenter_id}")
    	        public ResponseEntity<ServiceCenter> deleteServiceCenter(@PathVariable("serviceCenter_id") Long serviceCenter_id){
    	        ServiceCenter sus = enterServ.getServiceCenterById(serviceCenter_id);
    	        	enterServ.deleteServiceCenter(sus);
    	         return new ResponseEntity<ServiceCenter>(sus, HttpStatus.OK);
    	         
    	     }
    	    }

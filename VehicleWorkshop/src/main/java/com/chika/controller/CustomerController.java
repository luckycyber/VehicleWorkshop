package com.chika.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.chika.model.Customer;
import com.chika.model.Email;
import com.chika.service.CustomerService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="customer")
public class CustomerController {
	    
	@Autowired
	PasswordEncoder encoder;
	
	        @Autowired
	        private Email email;
	
	        @Autowired
	        private CustomerService custServ;
	        
	        @GetMapping("/{cust_id}")
	        public ResponseEntity <Customer>getCustomerById(@PathVariable("cust_id") Long cust_id) {
	            Customer cus = custServ.getCustomerById(cust_id);
	            
	            return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	        }
	        
	        @GetMapping("/custs")
	        public ResponseEntity <List<Customer>>getAllCustomer() {
	            List<Customer> cust = custServ.getAllCustomer();            
	            return new ResponseEntity<>(cust,HttpStatus.OK);
	        }
	        @PostMapping("/posts")
	           public ResponseEntity<Void> Customer(@RequestBody Customer cus, UriComponentsBuilder builder){
	        	Customer cs = cus;
	        	String password = encoder.encode(cs.getPassword());
	        	cs.setPassword(password);
	        	cs.getUser().setPassword(password);
	            Customer flag = custServ.addCustomer(cs);
	            if(flag==null)
	               return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	            HttpHeaders header = new HttpHeaders();
	            header.setLocation(builder.path("/posts")
	                    .buildAndExpand(cus.getCust_id()).toUri());
	            email.sendEmail();
	            return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	        }
	        //********************************************************
	    /*
	     * @PostMapping("/insertall") public ResponseEntity<Void> Customer(@RequestBody
	     * List<Customers> list, UriComponentsBuilder builder){ List<Customers> flag =
	     * custService.addAllCustomer(list); if(flag==null) return new
	     * ResponseEntity<Void>(HttpStatus.CONFLICT); HttpHeaders header = new
	     * HttpHeaders(); header.setLocation(builder.path("/customer")
	     * .buildAndExpand(((Customers) list).getCuId()).toUri()); return new
	     * ResponseEntity<Void>(header, HttpStatus.CREATED); }
	     */
	        
	        @PutMapping("/puts/{cust_id}")
	        public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cus){
	        custServ.updateCustomer(cus);
	         return new ResponseEntity<Customer>(cus, HttpStatus.OK);
	         
	     }
	        @DeleteMapping("/del/{cust_id}")
	        public ResponseEntity<Customer> deleteCustomer(@PathVariable("cust_id") Long  cust_id){
	        Customer cust = custServ.getCustomerById(cust_id);
	        	custServ.deleteCustomer(cust);
	         return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	         
	     }
	    }

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.chika.model.Email;
import com.chika.model.Worker;


import com.chika.service.WorkerService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/worker")
public class WorkerController {
    
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private Email email;
	
    @Autowired
    private WorkerService woServ;
    

    @GetMapping("/{work_id}")
    public ResponseEntity <Worker>getWorkerById(@PathVariable("work_id") Long Work_id) {
    	Worker sus = woServ.getWorkerById(Work_id);
        
        return new ResponseEntity<Worker>(sus,HttpStatus.OK);
    }
    
    @GetMapping("/workers")
    public ResponseEntity <List<Worker>>getAllWorker() {
        List<Worker> sus = woServ.getAllWorker();            
        return new ResponseEntity<>(sus,HttpStatus.OK);
    }
    @PostMapping("/works")
       public ResponseEntity<Void> Worker(@RequestBody Worker sus, UriComponentsBuilder builder){
    	Worker flag = woServ.addWorker(sus);
        if(flag==null)
           return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(builder.path("/works")
                .buildAndExpand(sus.getWork_id()).toUri());
        email.sendEmail();
        return new ResponseEntity<Void>(header, HttpStatus.CREATED);
    }
   
    @PutMapping("win/{work_id}")
    public ResponseEntity<Worker> updateWorker(@RequestBody Worker sus){
    woServ.updateWorker(sus);
     return new ResponseEntity<Worker>(sus, HttpStatus.OK);
     
 }
    @DeleteMapping("/wor")
    public ResponseEntity<Worker> deleteWorker(@PathVariable("work_id") Long work_id){
    Worker sus = woServ.getWorkerById(work_id);
    	woServ.deleteWorker(sus);
     return new ResponseEntity<Worker>(sus, HttpStatus.OK);
     
 }
}
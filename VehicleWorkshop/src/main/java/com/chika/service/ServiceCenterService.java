package com.chika.service;



import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chika.model.ServiceCenter;
import com.chika.repository.ServiceCenterRepository;

@Service
public class ServiceCenterService {


    @Autowired
    private ServiceCenterRepository serRepo;
    
    
    public ServiceCenter getServiceCenterById(Long ServiceCenter_id)
    {
    	ServiceCenter sus= serRepo.findById(ServiceCenter_id).get();
 
        return sus;    
    }
    
    public List<ServiceCenter> getAllServiceCenter(){
        List<ServiceCenter> list = new ArrayList<>();
         serRepo.findAll().forEach(cust->list.add(cust));
         //custRepo.findAll();
        return list;
        
    }
    public List<ServiceCenter> addAllCustomer(List<ServiceCenter> sus){
        List<ServiceCenter> list = new ArrayList<>();
        serRepo.saveAll(list);
        return list;
        
        
    }
    public ServiceCenter addServiceCenter(ServiceCenter sus){
        serRepo.save(sus);
        return sus;
        
    }
    public void updateServiceCenter(Long id, ServiceCenter sus) {
        ServiceCenter sc = serRepo.findById(id).get();
        sus.setServiceCenter_id(sc.getServiceCenter_id());    	
    	serRepo.save(sus);
    }
    public void deleteServiceCenter(ServiceCenter sus) {
        serRepo.delete(sus);
    }
    
    
}
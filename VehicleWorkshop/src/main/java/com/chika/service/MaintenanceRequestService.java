package com.chika.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.chika.model.MaintenanceRequest;
import com.chika.repository.MaintenanceRequestRepository;
@Service
public class MaintenanceRequestService {


    @Autowired
    private MaintenanceRequestRepository mrRep;
    
    
    public MaintenanceRequest getMaintenanceRequestById(Long MaintenanceRequest_id)
    {
    	MaintenanceRequest sus= mrRep.findById(MaintenanceRequest_id).get();
 
        return sus;    
    }
    
    public List<MaintenanceRequest> getAllMaintenanceRequest(){
        List<MaintenanceRequest> list = new ArrayList<>();
         mrRep.findAll().forEach(ma->list.add(ma));
         
        return list;
        
    }
    public List<MaintenanceRequest> addAllMaintenanceRequest(List<MaintenanceRequest> sus){
        List<MaintenanceRequest> list = new ArrayList<>();
       mrRep.saveAll(list);
        return list;
        
        
    }
    public MaintenanceRequest addMaintenanceRequest(MaintenanceRequest sus){
        mrRep.save(sus);
        return sus;
        
    }
    public void updateMaintenanceRequest(MaintenanceRequest sus) {
        mrRep.save(sus);
    }
    public void deleteMaintenanceRequest(MaintenanceRequest sus) {
        mrRep.delete(sus);
    }
    
    
}
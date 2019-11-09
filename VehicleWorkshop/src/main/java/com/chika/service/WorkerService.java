package com.chika.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chika.model.Worker;
import com.chika.repository.WorkerRepostory;

@Service
public class WorkerService {



    @Autowired
    private WorkerRepostory worRep;
    
    
    public Worker getWorkerById(Long Work_id)
    {
    	Worker sus= worRep.findById(Work_id).get();
 
        return sus;    
    }
    
    public List<Worker> getAllWorker(){
        List<Worker> list = new ArrayList<>();
         worRep.findAll().forEach(wor->list.add(wor));
        return list;
        
    }
    public List<Worker> addAllWorker(List<Worker> sus){
        List<Worker> list = new ArrayList<>();
        worRep.saveAll(list);
        return list;
        
        
    }
    public Worker addWorker(Worker sus){
        worRep.save(sus);
        return sus;
        
    }
    public void updateWorker(Worker sus) {
        worRep.save(sus);
    }
    public void deleteWorker(Worker sus) {
        worRep.delete(sus);
    }
    
    
}
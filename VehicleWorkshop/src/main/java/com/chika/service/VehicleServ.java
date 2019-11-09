package com.chika.service;



import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chika.model.Vehicle;
import com.chika.repository.VehicleRepository;



@Service
public class VehicleServ {

    @Autowired
    private VehicleRepository vehRep;
    
    
    public Vehicle getVehicleById(Long vehicle_id)
    {
    	Vehicle sus= vehRep.findById(vehicle_id).get();
 
        return sus;    
    }
    
    public List<Vehicle> getAllVehicle(){
        List<Vehicle> list = new ArrayList<>();
         vehRep.findAll().forEach(veh->list.add(veh));
         
        return list;
        
    }
    public List<Vehicle> addAllVehicle(List<Vehicle> sus){
        List<Vehicle> list = new ArrayList<>();
       vehRep.saveAll(list);
        return list;
        
        
    }
    public Vehicle addVehicle(Vehicle sus){
        vehRep.save(sus);
        return sus;
        
    }
    public void updateVehicle(Vehicle sus) {
        vehRep.save(sus);
    }
    public void deleteVehicle(Vehicle sus) {
        vehRep.delete(sus);
    }
    
    
}
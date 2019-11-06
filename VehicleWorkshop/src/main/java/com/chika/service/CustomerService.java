package com.chika.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chika.model.Customer;
import com.chika.repository.CustomerRepository;

@Service
public class CustomerService {
	
    @Autowired
    private CustomerRepository custRepo;
    
    
    public Customer getCustomerById(Long cust_id)
    {
        Customer cus= custRepo.findById(cust_id).get();
 
        return cus;    
    }
    
    public List<Customer> getAllCustomer(){
        List<Customer> list = new ArrayList<>();
         custRepo.findAll().forEach(cust->list.add(cust));
         //custRepo.findAll();
        return list;
        
    }
    public List<Customer> addAllCustomer(List<Customer> cust){
        List<Customer> list = new ArrayList<>();
        custRepo.saveAll(list);
        return list;
        
        
    }
    public Customer addCustomer(Customer cus){
        custRepo.save(cus);
        return cus;
        
    }
    public void updateCustomer(Customer cus) {
        custRepo.save(cus);
    }
    public void deleteCustomer(Customer cus) {
        custRepo.delete(cus);
    }
    
    
}
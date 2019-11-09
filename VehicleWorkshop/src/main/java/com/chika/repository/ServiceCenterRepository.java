package com.chika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chika.model.ServiceCenter;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long >{

}

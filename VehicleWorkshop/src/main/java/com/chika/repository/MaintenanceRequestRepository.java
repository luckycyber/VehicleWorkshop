package com.chika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chika.model.MaintenanceRequest;

@Repository
public interface MaintenanceRequestRepository extends JpaRepository<MaintenanceRequest, Long>{

}

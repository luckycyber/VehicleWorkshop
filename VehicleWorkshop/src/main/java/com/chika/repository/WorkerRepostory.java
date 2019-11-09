package com.chika.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chika.model.Worker;

@Repository
public interface WorkerRepostory extends JpaRepository<Worker , Long> {
	 Optional<Worker> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);

}

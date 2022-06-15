package com.api.spring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.spring.models.ResidentModel;

public interface ResidentRepository extends JpaRepository<ResidentModel, UUID>{
	
	ResidentModel findByCpf(String Cpf);
	
}

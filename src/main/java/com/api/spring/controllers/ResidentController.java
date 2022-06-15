package com.api.spring.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.PostUpdate;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring.dto.ResidentModelDTO;
import com.api.spring.models.ResidentModel;
import com.api.spring.services.ResidentService;

@RestController
@CrossOrigin(origins = "*" ,maxAge = 3600)
@RequestMapping("/residents")
public class ResidentController {
	
	final ResidentService residentService;
	
	public ResidentController(ResidentService _residentService) {
		
		this.residentService = _residentService;
		
	}
	
	@PostMapping
	public ResponseEntity<Object> createResident(@RequestBody @Valid ResidentModelDTO residentDTO) {
		ResidentModel resident = new ResidentModel();

		BeanUtils.copyProperties(residentDTO, resident);
		
		ResidentModel createdResident = this.residentService.create(resident);
		
		if(createdResident == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Resident already registered.");
		}
		
		createdResident.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdResident);
	}
	
	@GetMapping
	public ResponseEntity<Object> list(){
		return ResponseEntity.status(HttpStatus.OK).body(residentService.list());
	}
	
	@PutMapping
	public ResponseEntity<Object> update(@RequestBody @Valid ResidentModelDTO residentDTO){
		
		ResidentModel resident = new ResidentModel();
		
		BeanUtils.copyProperties(residentDTO,resident);
		
		ResidentModel updatedResident = this.residentService.update(resident);
		
		if(updatedResident == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User doesn't exists.");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedResident);
	}
	
	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Object> delete(@RequestBody String cpf){
		return ResponseEntity.status(HttpStatus.OK).body(this.residentService.delete(cpf));
	}
	
}

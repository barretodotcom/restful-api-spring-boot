package com.api.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.spring.exceptions.ResidentException;
import com.api.spring.exceptions.ResidentExceptionClass;
import com.api.spring.models.ResidentModel;
import com.api.spring.repositories.ResidentRepository;

@Service
public class ResidentService {

	final ResidentRepository residentRepository;
	
	public ResidentService(ResidentRepository residentRepository){
		this.residentRepository = residentRepository;
	}
	
	@Transactional
	public ResidentModel create(ResidentModel newResident) {
		ResidentModel resident = this.residentRepository.findByCpf(newResident.getCpf());
		
		if(resident != null) {
			throw new ResidentExceptionClass("Usuário já cadastrado.");
		}
		
		return this.residentRepository.save(newResident);
	}
	
	@Transactional
	public List<ResidentModel> list(){
		return this.residentRepository.findAll();
	}
	
	@Transactional
	public ResidentModel update(ResidentModel residentModel) {
		ResidentModel resident = this.residentRepository.findByCpf(residentModel.getCpf());
		
		if(resident == null) {
			return null;
		}
		
		resident = residentModel;
		
		return this.residentRepository.save(resident);
	}
	
	@Transactional
	public String delete(String Cpf) {
		ResidentModel resident = this.residentRepository.findByCpf(Cpf);
		
		if(resident == null){
			throw new ResidentExceptionClass("Morador não existente.");
		}
		
		this.residentRepository.delete(resident);
		
		return "Morador deletado com sucesso.";
	}
	
}

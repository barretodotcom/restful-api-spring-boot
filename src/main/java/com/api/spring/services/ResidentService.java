package com.api.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;

import com.api.spring.models.ResidentModel;
import com.api.spring.repositories.ResidentRepository;

@Service
public class ResidentService {

	final ResidentRepository residentRepository;
	
	public ResidentService(ResidentRepository residentRepository){
		this.residentRepository = residentRepository;
	}
	
	@Transactional
	public ResidentModel create(ResidentModel residentModel) {
		ResidentModel resident = this.residentRepository.findByCpf(residentModel.getCpf());
		
		if(resident == null) {
			return this.residentRepository.save(residentModel);
		}
		
		return null;
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
		
		System.out.println(Cpf);
		
		if(resident == null) {
			return "Morador não existente.";
		}
		
		this.residentRepository.delete(resident);
		
		return "Morador deletado com sucesso.";
	}
	
}

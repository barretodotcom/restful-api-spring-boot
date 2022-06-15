package com.api.spring.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "resident")
@AllArgsConstructor
@NoArgsConstructor
public class ResidentModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column
	private String name;
	
	@Column
	private String cpf;

	@Column
	public String licensePlateCar;

	@Column
	private String modelCar;
	
	@Column
	private String colorCar;

	@Column
	private String apartment;

	@Column
	private String block;
	
	@Column
	private LocalDateTime createdAt;
}

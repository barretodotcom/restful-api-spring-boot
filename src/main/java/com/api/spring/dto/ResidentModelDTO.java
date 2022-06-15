package com.api.spring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResidentModelDTO {
	
	@NotBlank
	public String name;
	
	@NotBlank
	@Size(max = 7)
	public String licensePlateCar;

	@NotBlank
	public String cpf;

	@NotBlank
	public String modelCar;

	@NotBlank
	public String colorCar;

	@NotBlank
	public String apartment;

	@NotBlank
	public String block;
}

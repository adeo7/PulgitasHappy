package com.example.PulgitasHappy.Dto;

import java.time.LocalDateTime;

public interface MascotaDataTableDto {
	
	Long getId();
	
	String getNombre();
	
	LocalDateTime getFechaNacimiento();
	
	String getDueño();
}

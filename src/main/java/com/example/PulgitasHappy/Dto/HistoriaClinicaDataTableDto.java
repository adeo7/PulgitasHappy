package com.example.PulgitasHappy.Dto;

import java.time.LocalDateTime;

public interface HistoriaClinicaDataTableDto {
	Long getId();
	String getMascota();
	LocalDateTime getFechaControl();
	String getRaza();
	String getObservaciones();
}

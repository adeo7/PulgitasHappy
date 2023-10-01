package com.example.PulgitasHappy.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.PulgitasHappy.Dto.HistoriaClinicaDataTableDto;
import com.example.PulgitasHappy.Entetys.HistoriaClinica;

public interface IHistoriaClinicaService {
	
	HistoriaClinica save(HistoriaClinica historiaClinica);
	 
	 void update (Long id, HistoriaClinica historiaClinica);
	 
	 void delete(Long id);
	 
	 List<HistoriaClinica>getAll();
	 
	 HistoriaClinica getById(Long id);

	Page<HistoriaClinicaDataTableDto> getDataTable(Pageable pageable, String textoBusqueda);
}

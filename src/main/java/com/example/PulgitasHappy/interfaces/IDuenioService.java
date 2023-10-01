package com.example.PulgitasHappy.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.PulgitasHappy.Dto.DuenioDataTableDto;
import com.example.PulgitasHappy.Entetys.Duenio;

public interface IDuenioService {
	
	Duenio save(Duenio duenio);
	 
	 void update (Long id, Duenio duenio);
	 
	 void delete(Long id);
	 
	 List<Duenio >getAll();
	 
	 Duenio getById(Long id);

	Page<DuenioDataTableDto> getDataTable(Pageable pageable, String textoBusqueda);
}

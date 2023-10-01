package com.example.PulgitasHappy.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.PulgitasHappy.Dto.MascotaDataTableDto;
import com.example.PulgitasHappy.Entetys.Mascota;

public interface IMascotaService {
	Mascota save(Mascota mascota);
	 
	 void update (Long id, Mascota mascota);
	 
	 void delete(Long id);
	 
	 List<Mascota >getAll();
	 
	 Mascota getById(Long id);

	Page<MascotaDataTableDto> getDataTable(Pageable pageable, String textoBusqueda);
}

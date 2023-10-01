package com.example.PulgitasHappy.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.PulgitasHappy.Dto.DuenioDataTableDto;
import com.example.PulgitasHappy.Entetys.Duenio;
import com.example.PulgitasHappy.Repository.DuenioRepository;
import com.example.PulgitasHappy.interfaces.IDuenioService;

@Service
public class DuenioService implements IDuenioService {
	
	@Autowired
	private DuenioRepository repository;

	@Override
	public Duenio save(Duenio duenio) {
		duenio.setCreateAt(LocalDateTime.now());
		return repository.save(duenio);
	}

	@Override
	public void update(Long id, Duenio duenio) {
		Optional<Duenio>duenioOpt= repository.findById(id);
		
		if (duenioOpt.isEmpty()) {
			return;
		}
		Duenio duenioBD= duenioOpt.get();
		duenioBD.setNombre(duenio.getNombre());
		duenioBD.setApellido(duenio.getApellido());
		duenioBD.setDireccion(duenio.getDireccion());
		duenioBD.setEmail(duenio.getEmail());
		duenioBD.setIdentificacion(duenio.getIdentificacion());
		duenioBD.setCreateAt(duenio.getCreateAt());
		duenioBD.setUpdateAt(LocalDateTime.now());
		
		repository.save(duenioBD);
		
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Duenio> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Duenio getById(Long id) {
	Optional<Duenio>duenioOpt= repository.findById(id);
		
		if (duenioOpt.isEmpty()) {
			return null;
		}
		Duenio duenioBD= duenioOpt.get();
		return duenioBD;
	}

	@Override
	public Page<DuenioDataTableDto> getDataTable(Pageable pageable, String textoBusqueda) {
		return repository.getDataTable(pageable, textoBusqueda);
	}
}

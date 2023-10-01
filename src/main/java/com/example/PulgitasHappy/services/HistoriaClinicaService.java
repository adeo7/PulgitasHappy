package com.example.PulgitasHappy.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.PulgitasHappy.Dto.HistoriaClinicaDataTableDto;
import com.example.PulgitasHappy.Entetys.HistoriaClinica;
import com.example.PulgitasHappy.Repository.HistoriaRepository;
import com.example.PulgitasHappy.interfaces.IHistoriaClinicaService;
@Service
public class HistoriaClinicaService implements IHistoriaClinicaService {
	
	@Autowired
	private HistoriaRepository repository;

	@Override
	public HistoriaClinica save(HistoriaClinica historiaClinica) {
		historiaClinica.setCreateAt(LocalDateTime.now());
		return repository.save(historiaClinica);
	}

	@Override
	public void update(Long id, HistoriaClinica historiaClinica) {
		Optional<HistoriaClinica>historiaOpt=repository.findById(id);
		if (historiaOpt.isEmpty()) {
			return;
		}
		HistoriaClinica historiaBD=historiaOpt.get();
		historiaBD.setMascota(historiaClinica.getMascota());
		historiaBD.setFechaControl(historiaClinica.getFechaControl());
		historiaBD.setObservaciones(historiaClinica.getObservaciones());
		historiaBD.setPeso(historiaClinica.getPeso());
		historiaBD.setUpdateAt(LocalDateTime.now());
		
		repository.save(historiaBD);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<HistoriaClinica> getAll() {
		return repository.findAll();
	}

	@Override
	public HistoriaClinica getById(Long id) {
		
		Optional<HistoriaClinica>historiaOpt=repository.findById(id);
		if (historiaOpt.isEmpty()) {
			return null;
		}
		HistoriaClinica historiaBD=historiaOpt.get();
		return historiaBD;
	}
	
	@Override
	public Page<HistoriaClinicaDataTableDto> getDataTable(Pageable pageable, String textoBusqueda) {
		return repository.getDataTable(pageable, textoBusqueda);
	}

}

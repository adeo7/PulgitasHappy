package com.example.PulgitasHappy.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.PulgitasHappy.Dto.MascotaDataTableDto;
import com.example.PulgitasHappy.Entetys.Mascota;
import com.example.PulgitasHappy.Repository.DuenioRepository;
import com.example.PulgitasHappy.Repository.MascotaRepository;
import com.example.PulgitasHappy.interfaces.IMascotaService;
@Service
public class MascotaService implements IMascotaService {
	
	@Autowired
	private MascotaRepository repository;

	@Override
	public Mascota save(Mascota mascota) {
		mascota.setCreateAt(LocalDateTime.now());
		return repository.save(mascota);
	}

	@Override
	public void update(Long id, Mascota mascota) {
		Optional<Mascota>mascotaOpt=repository.findById(id);
		if (mascotaOpt.isEmpty()) {
			return;
		}
		Mascota mascotaBD=mascotaOpt.get();
		mascota.setDuenio(mascota.getDuenio());
		mascotaBD.setFechaNacimiento(mascota.getFechaNacimiento());
		mascotaBD.setNombre(mascota.getNombre());
		mascotaBD.setUpdateAt(LocalDateTime.now());
		
		repository.save(mascotaBD);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Mascota> getAll() {
	
		return repository.findAll();
	}

	@Override
	public Mascota getById(Long id) {
		Optional<Mascota>mascotaOpt=repository.findById(id);
		if (mascotaOpt.isEmpty()) {
			return null;
		}
		Mascota mascotaBD=mascotaOpt.get();
		return mascotaBD;
	}
	
	@Override
    public Page<MascotaDataTableDto> getDataTable(Pageable pageable, String textoBusqueda) {
	return repository.getDataTable(pageable, textoBusqueda);
}
}

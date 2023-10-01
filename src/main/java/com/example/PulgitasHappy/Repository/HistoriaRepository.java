package com.example.PulgitasHappy.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PulgitasHappy.Dto.HistoriaClinicaDataTableDto;
import com.example.PulgitasHappy.Entetys.HistoriaClinica;

public interface HistoriaRepository extends JpaRepository<HistoriaClinica,Long>{
	
	@Query(value=" SELECT\r\n"
			+ " id,\r\n"
			+ "mas.nombre AS mascota,\r\n"
			+ "fecha_control,\r\n"
			+ "observaciones\r\n"
			+ "FROM historias_clinicas AS his\r\n"
			+ "INNER JOIN mascotas AS mas ON mas.id=his.mascota_id\r\n"
			+ "WHERE CONCAT(mas.nombre,his.observaciones,his.fecha_control) LIKE CONCAT('%', :textobu,'%')", nativeQuery = true)
	Page<HistoriaClinicaDataTableDto> getDataTable(Pageable pageable, @Param("textobu" ) String textoBusqueda);
}

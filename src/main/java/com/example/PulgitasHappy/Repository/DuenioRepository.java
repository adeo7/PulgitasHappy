package com.example.PulgitasHappy.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PulgitasHappy.Dto.DuenioDataTableDto;
import com.example.PulgitasHappy.Entetys.Duenio;


public interface DuenioRepository extends JpaRepository<Duenio,Long> {
	
	@Query(value="SELECT\r\n"
			+ " id,\r\n"
			+ "nombre,\r\n"
			+ "apellido,\r\n"
			+ "identificacion,\r\n"
			+ "telefono,\r\n"
			+ "direccion,\r\n"
			+ "email\r\n"
			+ "FROM duenios AS du\r\n"
			+ "WHERE CONCAT(du.nombre,du.apellido,du.identificacion,du.telefono,du.direccion,du.email) LIKE CONCAT('%', :textobu,'%') ", nativeQuery = true)
	Page<DuenioDataTableDto> getDataTable(Pageable pageable, @Param("textobu" ) String textoBusqueda);

}

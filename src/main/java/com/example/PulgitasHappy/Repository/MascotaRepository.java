package com.example.PulgitasHappy.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PulgitasHappy.Dto.MascotaDataTableDto;
import com.example.PulgitasHappy.Entetys.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota,Long>{
	
	@Query(value=" SELECT\r\n"
			+ " id,\r\n"
			+ "nombre,\r\n"
			+ "fecha_nacimiento,\r\n"
			+ "du.nombre AS duenio\r\n"
			+ "FROM mascotas AS ma\r\n"
			+ "INNER JOIN duenios AS du ON du.id=ma.duenio_id\r\n"
			+ "WHERE CONCAT(ma.nombre,du.nombre) LIKE CONCAT('%', :textobu,'%')", nativeQuery = true)
	Page<MascotaDataTableDto> getDataTable(Pageable pageable, @Param("textobu" ) String textoBusqueda);
}

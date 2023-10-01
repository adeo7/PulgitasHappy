package com.example.PulgitasHappy.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PulgitasHappy.Dto.ApiResponseDto;
import com.example.PulgitasHappy.Entetys.HistoriaClinica;
import com.example.PulgitasHappy.interfaces.IHistoriaClinicaService;
import com.example.PulgitasHappy.services.HistoriaClinicaService;


@RestController
@RequestMapping("api/historiaClinica")
public class HistoriaController {
	
	@Autowired
	private HistoriaClinicaService service;
	
	@GetMapping("datatable")
	public ResponseEntity<Page<?>>dataTable(@RequestParam(name= "page" )Integer page,
			@RequestParam(name ="size")Integer size,
			@RequestParam(name ="column_order")String columnOrder,
			@RequestParam(name ="column_direction")String columnDirection,
			@RequestParam(name ="search", required=false)String search){
		List<Order>orders= new ArrayList<>();
		
		if (columnDirection.equals("ASC")) {
			orders.add(
					new Order (Direction.ASC, columnOrder)
					);
		}else {
			orders.add(
					new Order (Direction.DESC, columnOrder)
					);
		}
		
		if (search==null) {
			search="";
		}
		return ResponseEntity.ok(service.getDataTable(PageRequest.of(page, size,Sort.by(orders)), search));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<HistoriaClinica>>>getAll(){
		
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<List<HistoriaClinica>>("Datos obtenidos", true, service.getAll())
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<List<HistoriaClinica>>(e.getMessage(), false, null)
					);
		}
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<HistoriaClinica>>getById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<HistoriaClinica>("Datos actualizados", true, service.getById(id))
					// este error se coorigue en HistoriaClinica service
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<HistoriaClinica>("Datos actualizados", true, null)
					);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<?>save(@RequestBody HistoriaClinica HistoriaClinica){
		return ResponseEntity.ok(service.save(HistoriaClinica));
	}
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<HistoriaClinica>>update(@PathVariable Long id, @RequestBody HistoriaClinica HistoriaClinica){
		try {
			service.update(id, HistoriaClinica);
			return ResponseEntity.ok(
					new ApiResponseDto<HistoriaClinica>("Datos actualizados", true, null)
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<HistoriaClinica>(e.getMessage(), false, null)
					);
		}
		
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?>delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("Historia Clinica eliminado");
	}

}

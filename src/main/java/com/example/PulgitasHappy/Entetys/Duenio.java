package com.example.PulgitasHappy.Entetys;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="duenios")
public class Duenio {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre",length = 100,nullable = false)
	private String nombre;
	
	@Column(name = "apellido",length = 100,nullable = false)
	private String apellido;	
	
	@Column(name = "identificacion",length = 100,nullable = false)
	private String identificacion;
	
	@Column(name = "telefono",length = 100,nullable = false)
	private String telefono;
	
	@Column(name = "direccion",length = 100,nullable = false)
	private String direccion;
	
	@Column(name = "email",length = 100,nullable = false)
	private String Email;
	
	@Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;
	
	 @Column(name = "update_at") 
	private LocalDateTime updateAt;
	 
	@Column(name = "delete_at")
	private LocalDateTime deleteAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTeleono() {
		return telefono;
	}

	public void setTeleono(String teleono) {
		this.telefono = teleono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public LocalDateTime getDeleteAt() {
		return deleteAt;
	}

	public void setDeleteAt(LocalDateTime deleteAt) {
		this.deleteAt = deleteAt;
	}
	
	
}

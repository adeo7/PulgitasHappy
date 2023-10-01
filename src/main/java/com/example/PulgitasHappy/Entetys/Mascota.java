package com.example.PulgitasHappy.Entetys;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mascotas")
public class Mascota {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre",length = 100,nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="duenio_id", nullable=false )
	private Duenio duenio;
	
	@Column(name = "fecha_nacimiento",length = 100,nullable = false)
	private LocalDateTime fechaNacimiento;

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

	public Duenio getDuenio() {
		return duenio;
	}

	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

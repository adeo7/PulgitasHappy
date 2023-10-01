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
@Table(name="historias_clinicas")
public class HistoriaClinica {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="mascota_id", nullable=false )
	private Mascota mascota;
	
	@Column(name = "fecha_control",length = 100,nullable = false)
	private LocalDateTime fechaControl;
	
	@Column(name = "peso",nullable = false)
	private Long peso;
	
	@Column(name = "Observaciones",length =400,nullable = false)
	private String Observaciones;
	
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

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	public Long getPeso() {
		return peso;
	}

	public void setPeso(Long peso) {
		this.peso = peso;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
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

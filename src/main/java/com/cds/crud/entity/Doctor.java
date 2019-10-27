package com.cds.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="doctores")
public class Doctor {
	//campos de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_doctor;
	private String nombre;
	private String direccion;
	private Integer telefono;
	private String especialidad;
	//constructores
	public Doctor () {
		
	}
	public Doctor(Integer id_doctor, String nombre, String direccion, Integer telefono, String especialidad) {
		super();
		this.id_doctor = id_doctor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}
	//Getters and Setters
	public Integer getId_doctor() {
		return id_doctor;
	}
	public void setId_doctor(Integer id_doctor) {
		this.id_doctor = id_doctor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}

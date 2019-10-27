package com.cds.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cds.crud.entity.Doctor;
import com.cds.crud.repository.IDoctorRepository;

@Controller
@RequestMapping("doctores")
public class ClinicaController {
	//implementacion metodos
	@Autowired
	IDoctorRepository erDoctor;
	
	//listar
	@GetMapping("listar")
	public String lista(Model m) {
		m.addAttribute("items",(List<Doctor>) erDoctor.findAll());
		return "/doctor/listDoctor";
	}
	@GetMapping("guardar")
	public String guardarVis() {
		return "/doctor/addDoctor";
	}
	@PostMapping("guardar")
	public String guardar(
			@RequestParam String nombre,
			@RequestParam String direccion,
			@RequestParam Integer telefono,
			@RequestParam String especialidad) {
		Doctor d = new Doctor(null,nombre,direccion,telefono,especialidad);
		erDoctor.save(d);
		return "redirect:/doctores/listar";
	}
	@GetMapping("modificar/{id_doctor}")
	public String modVis(
			@PathVariable Integer id_doctor, Model model) {
		Doctor r = erDoctor.findById(id_doctor).get();
		model.addAttribute("item", r);
		return "doctor/modDoctor";
	}
	//envio de datos a modificar
	@PostMapping("modificar")
	public String modificar (
			@RequestParam Integer id_doctor,
			@RequestParam String nombre,
			@RequestParam String direccion,
			@RequestParam Integer telefono,
			@RequestParam String especialidad) {
		
		Doctor r= new Doctor();
		r.setId_doctor(id_doctor);
		r.setNombre(nombre);
		r.setDireccion(direccion);
		r.setTelefono(telefono);
		r.setEspecialidad(especialidad);
		
		erDoctor.save(r);
		return  "redirect:/doctores/listar";
	}
	@GetMapping("eliminar/{id_doctor}")
	public String eliminarVis(
			@PathVariable Integer id_doctor) {
		Doctor r = erDoctor.findById(id_doctor).get();
		erDoctor.delete(r);
		return "redirect:/doctores/listar";
	}
}

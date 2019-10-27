package com.cds.crud.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cds.crud.entity.Usuario;
import com.cds.crud.repository.IUsuarioRepository;

@Controller
@RequestMapping("usuarios")
public class UsuarioController {

	//relacion con los datos
	@Autowired
	IUsuarioRepository erUsuario;
	
	@GetMapping("listar")
	public String vista() {
		return "usuario/listUsuario";
	}
	
	//Vista listar para json
	@GetMapping("valores")
	@ResponseBody
	public List<Usuario> getAll(){
		return (List<Usuario>) erUsuario.findAll();//Metodo para rertornar lista en un formato json segun return
	} 
	
	//guardar
	@PostMapping(value="guardarMod", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boolean guardar(
			@RequestParam Integer id,
			@RequestParam String nombre,
			@RequestParam String direccion,
			@RequestParam String telefono) {
		
		Usuario p = new Usuario();
		
		if(id!=null)
			p.setId(id);
		p.setNombre(nombre);
		p.setDireccion(direccion);
		p.setTelefono(telefono);
		
		erUsuario.save(p);
		return true;

	}
	//eliminar
	@GetMapping("eliminar/{id}")
	@ResponseBody
	public Boolean eliminar(@PathVariable Integer id) {
		Usuario p=erUsuario.findById(id).get();
		erUsuario.delete(p);
		return true;
	}
	//Cargar los datos a modificar
		@GetMapping(value ="editar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public Usuario modalModificar(@PathVariable Integer id) {
			return erUsuario.findById(id).get();
		}	
}

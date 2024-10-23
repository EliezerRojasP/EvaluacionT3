package com.Micro.Estudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Micro.Estudiantes.entidades.Estudiante;
import com.Micro.Estudiantes.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping
	public List<Estudiante> listarEstudiante(){
		return estudianteService.listarEstudiante();
	}
	
	@GetMapping("/{id}")
	public Estudiante buscarEstudiantePorId(@PathVariable Long id){
		return estudianteService.buscarEstudiantePorId(id);
	}
}

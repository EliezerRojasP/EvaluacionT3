package com.Micro.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Micro.cursos.entidades.Curso;
import com.Micro.cursos.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/habilitados")
	public List<Curso> listarCursosHabilitados(){
		return cursoService.listarCursosHabilitado();
	}
	
	@GetMapping("/{id}")
	public Curso buscarCursoPorId(@PathVariable Long id) {
		return cursoService.buscarCursoPorId(id);
	}
}

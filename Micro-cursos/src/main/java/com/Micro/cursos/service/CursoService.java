package com.Micro.cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Micro.cursos.entidades.Curso;
import com.Micro.cursos.repositorio.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> listarCursosHabilitado(){
		return cursoRepository.findByHabilitado(true);	
	}
	
	public Curso buscarCursoPorId(Long id) {
		return cursoRepository.findById(id).orElse(null);
	}
}

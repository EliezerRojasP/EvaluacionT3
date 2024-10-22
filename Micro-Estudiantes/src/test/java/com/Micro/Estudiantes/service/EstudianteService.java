package com.Micro.Estudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Micro.Estudiantes.entidades.Estudiante;
import com.Micro.Estudiantes.repositorio.EstudianteRepository;

@Service
public class EstudianteService {
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public List<Estudiante> listarEstudiante(){
		return estudianteRepository.findAll();
	}
	
	public Estudiante buscarEstudiantePorId(long id){
		return estudianteRepository.findById(id).orElse(null);
	}
	
}

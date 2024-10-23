package com.Micro.Estudiantes.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Micro.Estudiantes.entidades.Estudiante;
import com.Micro.Estudiantes.repositorio.EstudianteRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public List<Estudiante> listarEstudiante(){
		return estudianteRepository.findAll();
	}
	
	public Estudiante buscarEstudiantePorId(Long id){
		return estudianteRepository.findById(id).orElse(null);
	}

	public Estudiante registerOAuthEstudiante(String correo, String nombre){
		Estudiante estudiante = estudianteRepository.findByEmail(correo);
		
		if (estudiante == null){
			estudiante = new Estudiante();
			estudiante.setCorreo(correo);
			estudiante.setNombre(nombre);
			estudianteRepository.save(estudiante);
		}
		
		return estudiante;
	}
	
	public String generateToken(String correo){
		String SECRET_KEY = "JWT_SECRET_KEY";
		byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
		SecretKey secretKey = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
		
		return Jwts.builder()
				.setSubject(correo)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(secretKey, SignatureAlgorithm.HS256)
				.compact();
	}

}

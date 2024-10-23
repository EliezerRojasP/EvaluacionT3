package com.Micro.Estudiantes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Micro.Estudiantes.entidades.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	Estudiante findByEmail(String email);
}

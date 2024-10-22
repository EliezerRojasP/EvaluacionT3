package com.Micro.cursos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Micro.cursos.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	List<Curso> findByHabilitado(boolean habilitado);
}

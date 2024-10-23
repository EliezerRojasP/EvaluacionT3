package com.Micro.Estudiantes.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Micro.Estudiantes.entidades.Estudiante;
import com.Micro.Estudiantes.repositorio.EstudianteRepository;
import com.Micro.Estudiantes.service.EstudianteService;


@RestController
public class OAuth2Controller {

   @Autowired
   private EstudianteService estudianteService;
   
   @Autowired
   private EstudianteRepository estudianteRepository;
   
   @GetMapping("/loginSuccess")
   public String loginSuccess(OAuth2AuthenticationToken token){
	   String email = token.getPrincipal().getAttribute("email");
	   String name = token.getPrincipal().getAttribute("name");
	   
	   Estudiante estudianteExistente = estudianteRepository.findByEmail(email);
	   
	   if(estudianteExistente == null) {
		   estudianteService.registerOAuthEstudiante(email, name);
	   }
	   
	   
	   String jwtToken = estudianteService.generateToken(email);
	   
	   return "Inicie sesión exitosamente. Ficha JWT: " + jwtToken;
   }
   
   @GetMapping("/logout")
   public String logout(){
	   return "Cerrar sesión correctamente. ";
   }
   
   @GetMapping("getAll")
   public ResponseEntity<Object> getAllEstudiantes(){
	   return ResponseEntity.ok(this.estudianteRepository.findAll());
   }
   
}
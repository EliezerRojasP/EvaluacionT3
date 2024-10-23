package com.Micro.Estudiantes.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Micro.Estudiantes.repositorio.EstudianteRepository;
import com.Micro.Estudiantes.service.EstudianteService;


@RestController
public class OAuth2Controller {

   @Autowired
   private EstudianteService estudianteService;
   
   @Autowired
   private EstudianteRepository estudianteRepository;
   
   @GetMapping("loginSuccess")
   public String loginSuccess(OAuth2AuthenticationToken token){
	   String correo = token.getPrincipal().getAttribute("correo");
	   String nombre = token.getPrincipal().getAttribute("nombre");
	   
	   estudianteService.registerOAuthEstudiante(correo, nombre);
	   
	   String jwtToken = estudianteService.generateToken(correo);
	   
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
package com.hotelGeneration.demo.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelGeneration.demo.Entity.User;
import com.hotelGeneration.demo.Service.UserService;

/*
 * El controller es quien lleva todo el peso referente a las solicitudes HTTP (es el mesero de nuestro restaurante). Aqui sucede la manipulacion de los metodos HTTP (GET, POST, PUT, DELETE).
 * 
 * Para poder decirle a JAVA que esta clase es un controller, necesitamos usar la anotacion @RestController. Esto nos ayudara a poder manejar solicitudes HTTP, y ademas con esta anotacion podremos manejar el fetch que tengamos en nuestro front.
 */


@RequestMapping(path="/hotelGeneration/users")//construi la ruta de nuestra API

@RestController //Usamos esta anotacion para decirle que es una API del tipo REST(que trabaja con metodos HTTP)

public class UserController {
	
	
	//Creo una instancia de la clase UserService para que el controlador sepa la informacion del servicio
	public final UserService userService;
	
	
	@Autowired

	
	//Creo un constructor para mi UserController, tomara como argumento la instancia del userService
	public UserController(UserService userService) {
		this.userService = userService;
	}//constructor que utiliza la instancia del Service como parametro
	
	
	/*
	 * Ya que mi Controller depende de mi Service (con la instancia de UserService dentro de UserController), podre establecer los metodos HTTP que disparan las operaciones del CRUD (Controller - Service)
	 */
	
	
	//Metodos HTTP
	
	/*
	 * Metodo GET que toma la lista de usuarios creada en el userService, y que se muestra cuando se activa el metodo GET
	 */
	
	
	@GetMapping
	public List <User> getUsuarios(){
		return userService.readUsuarios();
	}
	
	
	

}


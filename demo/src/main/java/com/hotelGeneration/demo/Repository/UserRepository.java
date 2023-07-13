package com.hotelGeneration.demo.Repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelGeneration.demo.Entity.User;



@Repository //Anotacion para convertir mi interface en un repositorio

public interface UserRepository extends JpaRepository<User, Long>{
	
	//Query personalizada
	//@Query("SELECT usuario FROM User WHERE usuario.nombre=?1")
	
	//Optional<User> encontrarPorEmail (String email);
}



//T tipo de Entidad - ID tipo de dato del ID

	//Clase Abstracta tiene metodos abstractos y metodos concretos
	//Interface solo tiene metodos abstractos
	
	//Contratos que metodos si o si se tienen que implementar (abstractos)
	

	/*JPQL (Java Persistence Query Language)
	 * 
	 * Es practicamente lo mismo que trabajar con SQL, solo que en lugar de trabajar con tablas y columnas, trabajamos con entidades y atributos (POJOS y los repositorios).
	 * 
	 * 
	 * Un Optional es una clase que se utiliza paara representar un valor que puede o no existir. Es decir, cuando se usa el Optional puede o no contener un objeto, asi tenemos la seguridad de que el obejto no sera nulo o undefined (objeto vacio). Esto evita errores en tiempo de ejecucion.
	 * 
	 * 
	 */
	
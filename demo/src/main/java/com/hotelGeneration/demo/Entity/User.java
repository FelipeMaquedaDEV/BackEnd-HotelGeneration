package com.hotelGeneration.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Anotacion para decirle a JAVA que esta es una clase mapeada a una tabla de una BD
@Entity
@Table(name = "usuario") //me dice a que tabla de la BD voy a conectar esta clase POJO

public class User { //POJO (Plain Old Java Object)
	
	/*
	 * Utilizamos el atributo static para el id, ya que sera convertido en una variable de instancia. Esto significa que la variable le pertenece a la clase, y no al objeto que la instancia. Esto nos ayuda a tener un mejor control del contador, y que independientemente de la instancia, este valor siempre lo otorga la clase, asi evitamos id repetidos o saltados.
	 */
	
	
	//Propiedades o atributos
	//private static Long id = 0L; //ID antes de la conexicon a BD
	
	
	@Id //Decimos que la PK de nuestra tabla es el atributo ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Para generar valores automaticamente de forma autoincremental, en el campo id que es nuestra PK de la BD
	
	@Column(name="id", unique=true, nullable=false)
	
	private Long id; //ID despues de la conexion a BD
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	
	


	/*
	 * Utilizamos un contador id++ dentro del constructor para poder emular el atributo autoincrementable de nuestra columna id de la BD. Cuando conectemos la BD, ya no necesitaremos este dato en el constructor.
	 */
	
	
	//Modificamos el constructor, para agregar el id como parametro de construccion, ya que ahora el id si le pertenece al objeto y se tiene que construir con el
	
	//Constructor
	public User(Long id, String nombre, String apellido, String email, String telefono) {
		//id++; //contador para emular el autoincrementable de los usuarios
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	
	
	//Constructor vacio
	public User() {
		
	}//constructor vacio
	
	
	

	//Getters y Setters
	public Long getId() {
		return id;
	}

	/*
	 * Quitamos el setter para el id, ya que este atributo no se debera modificar
	 */

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}

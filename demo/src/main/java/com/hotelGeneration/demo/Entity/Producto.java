package com.hotelGeneration.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //Se convierte en entidad de una BD
@Table (name="producto") //Tabla con la que se relaciona en la BD
public class Producto {
	
	
	@Id //Llave primaria
	@GeneratedValue (strategy = GenerationType.IDENTITY) //Comportamiento de la PK Autoincremental
	
	//Atributos
	@Column (name = "id", unique = true, nullable=false) //se relaciona con la columna id, unique, notnull
	private Long id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private double precio;
		
	
	
	//Constructor con todos los campos
	public Producto(Long id, String nombre, String descripcion, String imagen, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
	}//constructor con todos los campos
	
	
	//Constructor vacio
	public Producto() {
		
	}

	
	//Getters y Setters
	public Long getId() {
		return id;
	}//getId

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre


	public String getDescripcion() {
		return descripcion;
	}//getDescripcion


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion


	public String getImagen() {
		return imagen;
	}//getImagen


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen


	public double getPrecio() {
		return precio;
	}//getPrecio


	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio


	
	//toString
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", precio=" + precio + "]";
	}//toString
	

}

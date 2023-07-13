package com.hotelGeneration.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelGeneration.demo.Entity.Producto;
import com.hotelGeneration.demo.Repository.ProductoRepository;


@Service //Le decimos que esta clase es un servicio
public class ProductoService {
	
	
	//Para manejar la inyeccion de dependencias
	

	//Constante para el autowired
	public final ProductoRepository productoRepository;
	
	//Anotacion
	@Autowired
	
	//Constructor que utiliza la instancia
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}//constructor
	
	
	
	// Metodos del CRUD para el manejo de Productos Create-Read-Update-Delete
	
	
	//Metodo para leer todos los productos
	public List<Producto> leerTodosLosProductos(){
		return productoRepository.findAll(); //busca todos los productos que encuentra en el repository
	}//leerTodosLosProductos
	

	
	//Metodo para leer un producto por su Id
	public Optional<Producto> leerProductoPorID(Long id) {
		return productoRepository.findById(id);
	}
	
	
	
	
	
	//Metodo para crear un nuevo producto
	// Gatito Nenito = new Gatito(parametros)
	public Producto crearProducto(Producto producto) { //le pasamos la instancia de un producto como parametro
	
		Producto prodTemporal= null; //creamos un objeto temporal para no modificar aun la BD
		
		
		//si el producto no existe
		
		//busco dentro del repositorio un producto por nombre, este dato lo obtengo con el getter correspondientes, y tambien hago una segunda validacion para verificar que el opcional esta vacio y puedo agregar el dato 
		if (productoRepository.findByNombre(producto.getNombre()).isEmpty()) {
			prodTemporal = productoRepository.save(producto);
			
		}else {
			
		//si el producto ya existe, imprimo mensaje de "producto ya existente"
		System.out.println("Ya existe un producto con el nombre ingresado");
		}
		
		return prodTemporal; //puede que el producto se quede null o no
		
	}//crearProducto
		
		
	
	

	//Metodo para modificar un producto
	public Producto actualizarProducto(Long id, String nombre, String descripcion, String imagen, Double precio) {
		
		Producto prodTemporal = null; //declaro producto temporl con valor nulo, para que sirva como mi calca
		//Si el producto existe, lo modifico
		
		if (productoRepository.existsById(id)) { //si el producto existe (true)
			//hago la modicacion de sus parametros
				prodTemporal= productoRepository.findById(id).get();
				if (nombre!=null) prodTemporal.setNombre(nombre);
				if (descripcion!=null)prodTemporal.setDescripcion(descripcion);
				if (imagen!=null)prodTemporal.setImagen(imagen);
				if (precio!=null)prodTemporal.setPrecio(precio);
				productoRepository.save(prodTemporal);
				
		}else {
			//Si el produco no existe, no lo puedo modificar y mando un mensaje que diga "el producto no existe"
			System.out.println("El producto que quieres actualizar, no existe");
		}//else
		return prodTemporal; //nulo o el producto modificado
	}//actualizarProducto
	
	
	
	
	//Metodo para borrar un producto
	public Producto borrarProducto(Long id) {
		
		Producto prodTemporal = null;
		
		//Si el producto existe, lo borro
		
		if (productoRepository.existsById(id)) {
			prodTemporal = productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if
	
		return prodTemporal;
	
	}//borrarProducto
	
	
	
	
	
	
	
}//clase ProductoService

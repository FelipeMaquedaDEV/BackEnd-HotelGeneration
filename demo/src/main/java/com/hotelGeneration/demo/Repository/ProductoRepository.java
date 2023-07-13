package com.hotelGeneration.demo.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotelGeneration.demo.Entity.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{

	
	//Metodo para buscar productos por nombre
	Optional<Producto> findByNombre(String nombre);
	
	
}

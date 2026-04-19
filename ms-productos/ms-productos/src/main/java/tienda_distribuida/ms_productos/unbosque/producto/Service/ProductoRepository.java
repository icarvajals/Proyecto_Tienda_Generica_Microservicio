package com.example.tienda_generica_distribuidos.unbosque.producto.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tienda_generica_distribuidos.unbosque.producto.Entidad.ProductoEntidad;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntidad, Integer> {
}

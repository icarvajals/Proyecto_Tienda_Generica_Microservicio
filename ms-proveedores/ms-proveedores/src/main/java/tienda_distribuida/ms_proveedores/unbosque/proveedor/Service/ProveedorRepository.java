package com.example.tienda_generica_distribuidos.unbosque.proveedor.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tienda_generica_distribuidos.unbosque.proveedor.Entidad.ProveedorEntidad;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntidad, Long> {
}
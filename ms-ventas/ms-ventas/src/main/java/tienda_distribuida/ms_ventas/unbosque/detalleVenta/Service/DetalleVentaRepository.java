package com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Entidad.DetalleVentaEntidad;

public interface DetalleVentaRepository  extends JpaRepository<DetalleVentaEntidad, Integer> {
}

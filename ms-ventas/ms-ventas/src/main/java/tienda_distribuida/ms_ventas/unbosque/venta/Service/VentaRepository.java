package com.example.tienda_generica_distribuidos.unbosque.venta.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.tienda_generica_distribuidos.unbosque.venta.Entidad.VentaEntidad;
import java.util.List;

public interface VentaRepository extends JpaRepository<VentaEntidad, Integer> {

    @Query("SELECT v.cedula_cliente, SUM(v.total_venta) FROM VentaEntidad v GROUP BY v.cedula_cliente")
    List<Object[]> obtenerVentasPorCliente();

    @Query("SELECT p.nombre_producto, d.cantidad_producto, d.valor_venta, d.valor_total " +
            "FROM DetalleVentaEntidad d " +
            "JOIN ProductoEntidad p ON d.codigo_producto = p.codigo_producto " +
            "WHERE d.codigo_venta = :codigoVenta")
    List<Object[]> obtenerDetallePorVenta(@Param("codigoVenta") int codigoVenta);
}
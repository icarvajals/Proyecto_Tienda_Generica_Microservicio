package com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_venta")
public class DetalleVentaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_venta_gen")
    @SequenceGenerator(
            name = "seq_detalle_venta_gen",
            sequenceName = "seq_detalle_venta",
            allocationSize = 1
    )
    @Column(name = "codigo_detalle_venta")
    private int codigo_detalle_venta;

    @Column(name = "codigo_producto")
    private int codigo_producto;

    @Column(name = "codigo_venta")
    private int codigo_venta;

    @Column(name = "cantidad_producto")
    private int cantidad_producto;

    @Column(name = "valor_total")
    private int valor_total;

    @Column(name = "valor_venta")
    private int valor_venta;

    @Column(name = "valoriva")
    private int valoriva;
}

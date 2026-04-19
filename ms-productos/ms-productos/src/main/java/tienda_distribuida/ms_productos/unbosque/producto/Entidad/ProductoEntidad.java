package com.example.tienda_generica_distribuidos.unbosque.producto.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntidad {

    @Id
    @Column(name = "codigo_producto")
    private int codigo_producto;

    @Column(name = "nitproveedor")
    private int nitproveedor;

    @Column(name = "nombre_producto")
    private String nombre_producto;

    @Column(name = "precio_compra")
    private int precio_compra;

    @Column(name = "precio_venta")
    private int precio_venta;

    @Column(name = "ivacompra")
    private int ivacompra;
}

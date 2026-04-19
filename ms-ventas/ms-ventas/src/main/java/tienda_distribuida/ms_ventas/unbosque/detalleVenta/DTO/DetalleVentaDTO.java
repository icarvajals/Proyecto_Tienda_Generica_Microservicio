package com.example.tienda_generica_distribuidos.unbosque.detalleVenta.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVentaDTO {

    private int codigo_detalle_venta;
    private int codigo_producto;
    private int codigo_venta;
    private int cantidad_producto;
    private int valor_total;
    private int valor_venta;
    private int valoriva;
}

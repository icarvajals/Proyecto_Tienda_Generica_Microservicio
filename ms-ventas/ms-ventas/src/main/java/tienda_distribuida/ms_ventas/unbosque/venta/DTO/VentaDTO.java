package com.example.tienda_generica_distribuidos.unbosque.venta.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {

    private int codigo_venta;
    private int cedula_cliente;
    private int cedula_usuario;
    private int ivaventa;
    private int valor_venta;
    private int total_venta;
}

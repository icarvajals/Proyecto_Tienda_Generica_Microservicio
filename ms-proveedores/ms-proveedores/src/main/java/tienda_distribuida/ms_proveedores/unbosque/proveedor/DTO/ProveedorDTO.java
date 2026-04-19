package com.example.tienda_generica_distribuidos.unbosque.proveedor.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {

    private Long   nitProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private String telefonoProveedor;
    private String ciudadProveedor;

}
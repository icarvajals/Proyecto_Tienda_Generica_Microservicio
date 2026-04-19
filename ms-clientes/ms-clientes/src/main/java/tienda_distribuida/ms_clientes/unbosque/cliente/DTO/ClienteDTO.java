package com.example.tienda_generica_distribuidos.unbosque.cliente.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long   cedulaCliente;
    private String nombreCliente;
    private String direccionCliente;
    private String emailCliente;
    private String telefonoCliente;
}
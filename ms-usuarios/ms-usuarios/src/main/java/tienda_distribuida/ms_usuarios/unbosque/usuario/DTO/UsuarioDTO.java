package com.example.tienda_generica_distribuidos.unbosque.usuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long   cedulaUsuario;
    private String nombreUsuario;
    private String direccionUsuario;
    private String emailUsuario;
    private String telefono;
    private String password;
}
package com.example.tienda_generica_distribuidos.unbosque.usuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    private int id;
    private String contraseña;
}

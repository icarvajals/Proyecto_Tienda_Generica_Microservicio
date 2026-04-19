package com.example.tienda_generica_distribuidos.unbosque.usuario.Entidad;

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
@Table(name = "usuario")
public class UsuarioEntidad {

    @Id
    @Column(name = "cedula_usuario", nullable = false)
    private Long cedulaUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 255)
    private String nombreUsuario;

    @Column(name = "direccion_usuario", nullable = false, length = 255)
    private String direccionUsuario;

    @Column(name = "email_usuario", nullable = false, length = 255)
    private String emailUsuario;

    @Column(name = "telefono_usuario", nullable = false, length = 255)
    private String telefono;

    @Column(name = "password", nullable = false, length = 255)
    private String password;
}
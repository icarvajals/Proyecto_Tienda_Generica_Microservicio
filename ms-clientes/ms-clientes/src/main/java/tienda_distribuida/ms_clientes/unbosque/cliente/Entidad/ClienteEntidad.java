package com.example.tienda_generica_distribuidos.unbosque.cliente.Entidad;

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
@Table(name = "cliente")
public class ClienteEntidad {
    @Id
    @Column(name = "cedula_cliente", nullable = false)
    private Long cedulaCliente;

    @Column(name = "nombre_cliente", nullable = false, length = 255)
    private String nombreCliente;

    @Column(name = "direccion_cliente", nullable = false, length = 255)
    private String direccionCliente;

    @Column(name = "email_cliente", nullable = false, length = 255)
    private String emailCliente;

    @Column(name = "telefono_cliente", nullable = false, length = 255)
    private String telefonoCliente;
}
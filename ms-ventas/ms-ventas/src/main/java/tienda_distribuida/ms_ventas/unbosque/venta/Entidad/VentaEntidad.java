package com.example.tienda_generica_distribuidos.unbosque.venta.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "venta")
public class VentaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "codigo_venta")
    private int codigo_venta;

    @Column(name = "cedula_cliente")
    private int cedula_cliente;

    @Column(name = "cedula_usuario")
    private int cedula_usuario;

    @Column(name = "ivaventa")
    private int ivaventa;

    @Column(name = "valor_venta")
    private int valor_venta;

    @Column(name = "total_venta")
    private int total_venta;
}

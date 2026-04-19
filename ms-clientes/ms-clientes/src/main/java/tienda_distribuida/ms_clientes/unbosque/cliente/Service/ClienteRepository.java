package com.example.tienda_generica_distribuidos.unbosque.cliente.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tienda_generica_distribuidos.unbosque.cliente.Entidad.ClienteEntidad;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidad, Long> {

}
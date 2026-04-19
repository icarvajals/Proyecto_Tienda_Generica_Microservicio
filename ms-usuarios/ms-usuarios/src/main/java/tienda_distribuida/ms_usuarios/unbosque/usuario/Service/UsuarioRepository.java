package com.example.tienda_generica_distribuidos.unbosque.usuario.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tienda_generica_distribuidos.unbosque.usuario.Entidad.UsuarioEntidad;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntidad, Long> {

}
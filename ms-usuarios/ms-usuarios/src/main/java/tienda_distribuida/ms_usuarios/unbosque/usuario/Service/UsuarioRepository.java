package tienda_distribuida.ms_usuarios.unbosque.usuario.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tienda_distribuida.ms_usuarios.unbosque.usuario.Entidad.UsuarioEntidad;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntidad, Long> {

}
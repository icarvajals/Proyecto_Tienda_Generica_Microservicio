package tienda_distribuida.ms_clientes.unbosque.cliente.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tienda_distribuida.ms_clientes.unbosque.cliente.Entidad.ClienteEntidad;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidad, Long> {

}
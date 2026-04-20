package tienda_distribuida.ms_proveedores.unbosque.proveedor.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tienda_distribuida.ms_proveedores.unbosque.proveedor.Entidad.ProveedorEntidad;


@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntidad, Long> {
}
package tienda_distribuida.ms_productos.unbosque.producto.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tienda_distribuida.ms_productos.unbosque.producto.Entidad.ProductoEntidad;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntidad, Integer> {
}

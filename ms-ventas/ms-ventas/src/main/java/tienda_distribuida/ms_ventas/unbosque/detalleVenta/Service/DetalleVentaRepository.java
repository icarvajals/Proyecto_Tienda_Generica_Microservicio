package tienda_distribuida.ms_ventas.unbosque.detalleVenta.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import tienda_distribuida.ms_ventas.unbosque.detalleVenta.Entidad.DetalleVentaEntidad;


public interface DetalleVentaRepository  extends JpaRepository<DetalleVentaEntidad, Integer> {
}

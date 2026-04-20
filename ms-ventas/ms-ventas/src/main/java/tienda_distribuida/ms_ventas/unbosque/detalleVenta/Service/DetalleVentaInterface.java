package tienda_distribuida.ms_ventas.unbosque.detalleVenta.Service;

import tienda_distribuida.ms_ventas.unbosque.detalleVenta.DTO.DetalleVentaDTO;
import java.util.List;

public interface DetalleVentaInterface {

    public DetalleVentaDTO guardarDetalle(DetalleVentaDTO detalleVentaDTO);
    public List<DetalleVentaDTO> listarDetalles();
    public DetalleVentaDTO buscarPorId(int id);
    public String actualizarDetalle(int id, DetalleVentaDTO detalleVentaDTO);
    public String borrarDetalle(int id);
}

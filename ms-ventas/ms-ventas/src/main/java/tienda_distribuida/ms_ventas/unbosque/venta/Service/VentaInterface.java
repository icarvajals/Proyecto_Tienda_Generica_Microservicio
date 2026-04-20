package tienda_distribuida.ms_ventas.unbosque.venta.Service;

import tienda_distribuida.ms_ventas.unbosque.venta.DTO.VentaDTO;

import java.util.List;

public interface VentaInterface {

    public VentaDTO guardarVenta(VentaDTO ventaDTO);
    public List<VentaDTO> listarVentas();
    public VentaDTO buscarPorId(int id);
    public String actualizarVenta(int id, VentaDTO ventaDTO);
    public String borrarVenta(int id);
}

package com.example.tienda_generica_distribuidos.unbosque.venta.Service;

import com.example.tienda_generica_distribuidos.unbosque.venta.DTO.VentaDTO;

import java.util.List;

public interface VentaInterface {

    public VentaDTO guardarVenta(VentaDTO ventaDTO);
    public List<VentaDTO> listarVentas();
    public VentaDTO buscarPorId(int id);
    public String actualizarVenta(int id, VentaDTO ventaDTO);
    public String borrarVenta(int id);
}

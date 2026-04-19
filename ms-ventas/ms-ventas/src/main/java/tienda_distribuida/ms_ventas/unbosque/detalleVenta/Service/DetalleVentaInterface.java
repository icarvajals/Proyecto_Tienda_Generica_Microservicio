package com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Service;

import com.example.tienda_generica_distribuidos.unbosque.detalleVenta.DTO.DetalleVentaDTO;

import java.util.List;

public interface DetalleVentaInterface {

    public DetalleVentaDTO guardarDetalle(DetalleVentaDTO detalleVentaDTO);
    public List<DetalleVentaDTO> listarDetalles();
    public DetalleVentaDTO buscarPorId(int id);
    public String actualizarDetalle(int id, DetalleVentaDTO detalleVentaDTO);
    public String borrarDetalle(int id);
}

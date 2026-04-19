package com.example.tienda_generica_distribuidos.unbosque.proveedor.Service;

import com.example.tienda_generica_distribuidos.unbosque.proveedor.DTO.ProveedorDTO;

import java.util.List;

public interface ProveedorInterface {

    ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO);

    List<ProveedorDTO> listarProveedores();

    ProveedorDTO obtenerProveedorPorNit(Long nit);

    ProveedorDTO actualizarProveedor(ProveedorDTO proveedorDTO);

    void eliminarProveedor(Long nit);
}
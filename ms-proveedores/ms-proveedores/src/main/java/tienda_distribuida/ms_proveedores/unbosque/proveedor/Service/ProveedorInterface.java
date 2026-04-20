package tienda_distribuida.ms_proveedores.unbosque.proveedor.Service;

import tienda_distribuida.ms_proveedores.unbosque.proveedor.DTO.ProveedorDTO;

import java.util.List;

public interface ProveedorInterface {

    ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO);

    List<ProveedorDTO> listarProveedores();

    ProveedorDTO obtenerProveedorPorNit(Long nit);

    ProveedorDTO actualizarProveedor(ProveedorDTO proveedorDTO);

    void eliminarProveedor(Long nit);
}
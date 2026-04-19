package com.example.tienda_generica_distribuidos.unbosque.proveedor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.tienda_generica_distribuidos.unbosque.proveedor.DTO.ProveedorDTO;
import com.example.tienda_generica_distribuidos.unbosque.proveedor.Entidad.ProveedorEntidad;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorImplService implements ProveedorInterface {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Modifica solo estos dos métodos dentro de tu ProveedorImplService
    private ProveedorDTO mapToDTO(ProveedorEntidad entidad) {
        return new ProveedorDTO(
                entidad.getNitProveedor(),
                entidad.getNombreProveedor(),
                entidad.getDireccionProveedor(),
                entidad.getTelefonoProveedor(),
                entidad.getCiudadProveedor()

        );
    }

    private ProveedorEntidad mapToEntidad(ProveedorDTO dto) {
        return new ProveedorEntidad(
                dto.getNitProveedor(),
                dto.getNombreProveedor(),
                dto.getDireccionProveedor(),
                dto.getTelefonoProveedor(),
                dto.getCiudadProveedor()
        );
    }

    @Override
    @Transactional // <--- VITAL: Asegura que se haga el COMMIT
    public ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO) {
        try {
            ProveedorEntidad entidad = mapToEntidad(proveedorDTO);
            // Usamos saveAndFlush para forzar la escritura inmediata
            ProveedorEntidad guardado = proveedorRepository.saveAndFlush(entidad);
            return mapToDTO(guardado);
        } catch (Exception e) {
            System.err.println("ERROR AL ESCRIBIR EN DISCO: " + e.getMessage());
            throw new RuntimeException("Fallo real en BD: " + e.getMessage());
        }
    }

    @Override
    public List<ProveedorDTO> listarProveedores() {
        return proveedorRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public ProveedorDTO obtenerProveedorPorNit(Long nit) {
        return proveedorRepository.findById(nit).map(this::mapToDTO).orElse(null);
    }

    @Override
    @Transactional
    public ProveedorDTO actualizarProveedor(ProveedorDTO proveedorDTO) {
        if (!proveedorRepository.existsById(proveedorDTO.getNitProveedor())) {
            throw new IllegalArgumentException("Proveedor Inexistente");
        }
        return mapToDTO(proveedorRepository.saveAndFlush(mapToEntidad(proveedorDTO)));
    }

    @Override
    @Transactional
    public void eliminarProveedor(Long nit) {
        proveedorRepository.deleteById(nit);
        proveedorRepository.flush();
    }
}
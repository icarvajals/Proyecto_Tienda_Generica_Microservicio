package com.example.tienda_generica_distribuidos.unbosque.proveedor.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tienda_generica_distribuidos.unbosque.proveedor.DTO.ProveedorDTO;
import com.example.tienda_generica_distribuidos.unbosque.proveedor.Service.ProveedorInterface;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    private ProveedorInterface proveedorService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        try {
            ProveedorDTO guardado = proveedorService.guardarProveedor(proveedorDTO);
            return ResponseEntity.ok(guardado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProveedorDTO>> listarProveedores() {
        return ResponseEntity.ok(proveedorService.listarProveedores());
    }

    @GetMapping("/buscar/{nit}")
    public ResponseEntity<?> obtenerProveedorPorNit(@PathVariable Long nit) {
        ProveedorDTO proveedor = proveedorService.obtenerProveedorPorNit(nit);
        if (proveedor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor Inexistente");
        }
        return ResponseEntity.ok(proveedor);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        try {
            ProveedorDTO actualizado = proveedorService.actualizarProveedor(proveedorDTO);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable Long id) {
        try {
            proveedorService.eliminarProveedor(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
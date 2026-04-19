package com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tienda_generica_distribuidos.unbosque.detalleVenta.DTO.DetalleVentaDTO;
import com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Service.DetalleVentaService;

import java.util.List;

@RestController
@RequestMapping("/api/detalleventas")
@CrossOrigin(origins = "*")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping("/agregar")
    public DetalleVentaDTO guardar(@RequestBody DetalleVentaDTO detalleVentaDTO) {
        return detalleVentaService.guardarDetalle(detalleVentaDTO);
    }

    @GetMapping("/listar")
    public List<DetalleVentaDTO> listar() {
        return detalleVentaService.listarDetalles();
    }
}
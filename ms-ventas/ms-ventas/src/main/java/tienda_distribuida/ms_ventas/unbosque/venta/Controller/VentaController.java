package com.example.tienda_generica_distribuidos.unbosque.venta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tienda_generica_distribuidos.unbosque.venta.DTO.VentaDTO;
import com.example.tienda_generica_distribuidos.unbosque.venta.Service.VentaImplService;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaImplService ventaService;

    @GetMapping("/listar")
    public List<VentaDTO> listar() {
        return ventaService.listarVentas();
    }

    @GetMapping("/reporte-clientes")
    public List<Object[]> obtenerReporte() {
        return ventaService.reportePorCliente();
    }

    @GetMapping("/detalle/{id}")
    public List<Object[]> obtenerDetalle(@PathVariable int id) {
        return ventaService.obtenerDetalleFactura(id);
    }
}
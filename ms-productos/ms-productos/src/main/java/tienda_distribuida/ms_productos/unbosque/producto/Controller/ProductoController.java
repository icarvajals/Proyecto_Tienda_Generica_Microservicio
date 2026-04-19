package com.example.tienda_generica_distribuidos.unbosque.producto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tienda_generica_distribuidos.unbosque.producto.DTO.ProductoDTO;
import com.example.tienda_generica_distribuidos.unbosque.producto.Service.ProductoInterface;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoInterface productoService;

    @PostMapping("/agregar")
    public ProductoDTO guardar(@RequestBody ProductoDTO productoDTO) {
        return productoService.guardarProducto(productoDTO);
    }

    @GetMapping("/listar")
    public List<ProductoDTO> listar() {
        return productoService.listarProductos();
    }

    @GetMapping("/buscar/{id}")
    public ProductoDTO buscar(@PathVariable int id) {
        return productoService.buscarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id,@RequestBody ProductoDTO productoDTO) {
        return productoService.actualizarProducto(id, productoDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public String eliminar(@PathVariable int id) {
        return productoService.borrarProducto(id);
    }
}

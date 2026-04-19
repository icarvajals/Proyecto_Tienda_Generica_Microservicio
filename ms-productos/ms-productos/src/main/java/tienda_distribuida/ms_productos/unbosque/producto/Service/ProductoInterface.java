package com.example.tienda_generica_distribuidos.unbosque.producto.Service;

import com.example.tienda_generica_distribuidos.unbosque.producto.DTO.ProductoDTO;

import java.util.List;

public interface ProductoInterface {

    public ProductoDTO guardarProducto(ProductoDTO productoDTO);
    public List<ProductoDTO> listarProductos();
    public ProductoDTO buscarPorId(int id);
    public String actualizarProducto(int id, ProductoDTO productoDTO);
    public String borrarProducto(int id);
}

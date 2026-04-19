package com.example.tienda_generica_distribuidos.unbosque.producto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tienda_generica_distribuidos.unbosque.producto.DTO.ProductoDTO;
import com.example.tienda_generica_distribuidos.unbosque.producto.Entidad.ProductoEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoImplService implements ProductoInterface{

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
        ProductoEntidad entidad = new ProductoEntidad(
                productoDTO.getCodigo_producto(),
                productoDTO.getNitproveedor(),
                productoDTO.getNombre_producto(),
                productoDTO.getPrecio_compra(),
                productoDTO.getPrecio_venta(),
                productoDTO.getIvacompra()
        );

        try {
            ProductoEntidad guardado = productoRepository.save(entidad);
            productoDTO.setCodigo_producto(guardado.getCodigo_producto());
            return productoDTO;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        List<ProductoEntidad> productos = productoRepository.findAll();
        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (ProductoEntidad p : productos) {
            listaDTO.add(new ProductoDTO(
                    p.getCodigo_producto(),
                    p.getNitproveedor(),
                    p.getNombre_producto(),
                    p.getPrecio_compra(),
                    p.getPrecio_venta(),
                    p.getIvacompra()
            ));
        }
        return listaDTO;
    }

    @Override
    public ProductoDTO buscarPorId(int id) {
        ProductoEntidad producto = productoRepository.findById(id).orElse(null);

        if (producto == null) {
            return null;
        } else {
            return new ProductoDTO(
                    producto.getCodigo_producto(),
                    producto.getNitproveedor(),
                    producto.getNombre_producto(),
                    producto.getPrecio_compra(),
                    producto.getPrecio_venta(),
                    producto.getIvacompra()
            );
        }
    }

    @Override
    public String actualizarProducto(int id,ProductoDTO productoDTO) {
        Optional<ProductoEntidad> productoExistente =
                productoRepository.findById(id);

        if (productoExistente.isEmpty()) {
            return "Producto imposible de actualizar";
        } else {
            ProductoEntidad entidad = productoExistente.get();

            entidad.setNitproveedor(productoDTO.getNitproveedor());
            entidad.setNombre_producto(productoDTO.getNombre_producto());
            entidad.setPrecio_compra(productoDTO.getPrecio_compra());
            entidad.setPrecio_venta(productoDTO.getPrecio_venta());
            entidad.setIvacompra(productoDTO.getIvacompra());

            productoRepository.save(entidad);
            return "Producto actualizado correctamente";
        }
    }

    @Override
    public String borrarProducto(int id) {
        try {
            productoRepository.deleteById(id);
            return "Producto eliminado";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

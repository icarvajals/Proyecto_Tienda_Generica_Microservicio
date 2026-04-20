package tienda_distribuida.ms_productos.unbosque.producto.Service;

import tienda_distribuida.ms_productos.unbosque.producto.DTO.ProductoDTO;
import java.util.List;

public interface ProductoInterface {

    public ProductoDTO guardarProducto(ProductoDTO productoDTO);
    public List<ProductoDTO> listarProductos();
    public ProductoDTO buscarPorId(int id);
    public String actualizarProducto(int id, ProductoDTO productoDTO);
    public String borrarProducto(int id);
}

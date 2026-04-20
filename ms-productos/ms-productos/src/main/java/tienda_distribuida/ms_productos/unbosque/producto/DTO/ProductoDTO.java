package tienda_distribuida.ms_productos.unbosque.producto.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private int codigo_producto;
    private int nitproveedor;
    private String nombre_producto;
    private int precio_compra;
    private int precio_venta;
    private int ivacompra;
}

package tienda_distribuida.ms_proveedores.unbosque.proveedor.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorDTO {

    private Long   nitProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private String telefonoProveedor;
    private String ciudadProveedor;

}
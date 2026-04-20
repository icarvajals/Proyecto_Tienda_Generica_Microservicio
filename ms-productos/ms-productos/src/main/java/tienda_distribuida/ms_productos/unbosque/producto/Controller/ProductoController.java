package tienda_distribuida.ms_productos.unbosque.producto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda_distribuida.ms_productos.unbosque.producto.DTO.ProductoDTO;
import tienda_distribuida.ms_productos.unbosque.producto.Service.ProductoInterface;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoInterface productoService;

    @Autowired
    private ProveedorClient proveedorClient;

    @PostMapping("/agregar")
    public ResponseEntity<?> guardar(@RequestBody ProductoDTO productoDTO) {
        try {
            ResponseEntity<?> response = proveedorClient.buscarProveedorPorNit((long) productoDTO.getNitproveedor());

            return ResponseEntity.ok(productoService.guardarProducto(productoDTO));

        } catch (feign.FeignException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: El proveedor con NIT " + productoDTO.getNitproveedor() + " no existe en el sistema.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error técnico: No se pudo validar el proveedor en este momento.");
        }
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

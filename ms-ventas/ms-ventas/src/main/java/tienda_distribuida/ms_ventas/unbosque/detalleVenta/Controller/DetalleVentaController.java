package tienda_distribuida.ms_ventas.unbosque.detalleVenta.Controller;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda_distribuida.ms_ventas.unbosque.detalleVenta.DTO.DetalleVentaDTO;
import tienda_distribuida.ms_ventas.unbosque.detalleVenta.Service.DetalleVentaService;
import tienda_distribuida.ms_ventas.unbosque.venta.DTO.VentaDTO;
import tienda_distribuida.ms_ventas.unbosque.venta.Service.VentaImplService;


import java.util.List;

@RestController
@RequestMapping("/api/detalleventas")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @Autowired
    private VentaImplService ventaImplService;

    @Autowired
    private ProductoClient productoClient;

    @PostMapping("/agregar")
    public ResponseEntity<?> guardar(@RequestBody DetalleVentaDTO detalleVentaDTO) {
        try {
            productoClient.buscarProductoPorID(detalleVentaDTO.getCodigo_producto());

            VentaDTO venta = ventaImplService.buscarPorId(detalleVentaDTO.getCodigo_venta());
            if (venta == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Error: La venta con ID " + detalleVentaDTO.getCodigo_venta() + " no existe.");
            }

            return ResponseEntity.ok(detalleVentaService.guardarDetalle(detalleVentaDTO));

        } catch (FeignException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: El producto con Código " + detalleVentaDTO.getCodigo_producto() + " no existe en el sistema.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error técnico: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<DetalleVentaDTO> listar() {
        return detalleVentaService.listarDetalles();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDetalleVenta(@PathVariable int id){
        try {
            detalleVentaService.borrarDetalle(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
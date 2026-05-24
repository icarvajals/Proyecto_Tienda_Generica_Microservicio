package tienda_distribuida.ms_ventas.unbosque.venta.Controller;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tienda_distribuida.ms_ventas.unbosque.venta.DTO.VentaDTO;
import tienda_distribuida.ms_ventas.unbosque.venta.Service.VentaImplService;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaImplService ventaService;

    @Autowired
    private ClientesClient clientesClient;

    @Autowired UsuarioClient usuarioClient;

    @PostMapping("/agregar")
    public ResponseEntity<?> guardar(@RequestBody VentaDTO ventaDTO){
        try{
            ResponseEntity<?> response = clientesClient.buscarClientePorID((long) ventaDTO.getCedula_cliente());

            ResponseEntity<?> response1 = usuarioClient.buscarUsuarioPorID((long) ventaDTO.getCedula_usuario());

            return ResponseEntity.ok(ventaService.guardarVenta(ventaDTO));
        }catch (FeignException.NotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: El cliente con cedula " + ventaDTO.getCedula_cliente() + " no existe en el sistema" +
                            " O el usuario con cedula " + ventaDTO.getCedula_usuario() + " no existe en el sistema" );

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error técnico: No se pudo validar el cliente o usuario en este momento.");
        }
    }

    @GetMapping("/listar")
    public List<VentaDTO> listar() {
        return ventaService.listarVentas();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable int id){
        try {
            ventaService.borrarVenta(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/reporte-clientes")
    public List<Object[]> obtenerReporte() {
        return ventaService.reportePorCliente();
    }
//
//    @GetMapping("/detalle/{id}")
//    public List<Object[]> obtenerDetalle(@PathVariable int id) {
//        return ventaService.obtenerDetalleFactura(id);
//    }
}
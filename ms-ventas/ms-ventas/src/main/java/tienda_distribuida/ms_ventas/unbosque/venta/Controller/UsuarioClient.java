package tienda_distribuida.ms_ventas.unbosque.venta.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-USUARIOS")
public interface UsuarioClient {

    @GetMapping("/usuarios/buscar/{cedula}")
    ResponseEntity<?> buscarUsuarioPorID(@PathVariable("cedula") Long cedula);
}

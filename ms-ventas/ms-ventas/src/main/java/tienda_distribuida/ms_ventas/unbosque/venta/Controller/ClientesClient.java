package tienda_distribuida.ms_ventas.unbosque.venta.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    value = "clientes-service",
    url = "https://ms-usuarios-production-e7fe.up.railway.app"
)
public interface ClientesClient {

    @GetMapping("/clientes/buscar/{cedula}")
    ResponseEntity<?> buscarClientePorID(@PathVariable("cedula") Long cedula);

}

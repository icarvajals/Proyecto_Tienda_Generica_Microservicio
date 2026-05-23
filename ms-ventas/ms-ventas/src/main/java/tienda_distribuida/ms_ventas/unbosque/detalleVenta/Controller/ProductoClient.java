package tienda_distribuida.ms_ventas.unbosque.detalleVenta.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    value = "producto-service",
    url = "ms-productos-production.up.railway.app"
)
public interface ProductoClient {

    @GetMapping("/api/productos/buscar/{id}")
    ResponseEntity<?> buscarProductoPorID(@PathVariable("id") int id);
}

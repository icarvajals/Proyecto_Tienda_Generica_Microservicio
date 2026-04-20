package tienda_distribuida.ms_productos.unbosque.producto.Controller;

import jakarta.ws.rs.GET;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-PROVEEDORES")
public interface ProveedorClient {

    @GetMapping("/proveedores/buscar/{nit}")
    ResponseEntity<?> buscarProveedorPorNit(@PathVariable("nit") Long nit);
}

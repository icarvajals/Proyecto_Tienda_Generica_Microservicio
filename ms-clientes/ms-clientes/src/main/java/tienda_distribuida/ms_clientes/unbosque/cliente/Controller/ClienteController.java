package com.example.tienda_generica_distribuidos.unbosque.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tienda_generica_distribuidos.unbosque.cliente.DTO.ClienteDTO;
import com.example.tienda_generica_distribuidos.unbosque.cliente.Service.ClienteInterface;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteInterface clienteService;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO guardado = clienteService.guardarCliente(clienteDTO);
            return ResponseEntity.ok(guardado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarClientes());
    }


    @GetMapping("/buscar/{cedula}")
    public ResponseEntity<?> obtenerClientePorCedula(@PathVariable Long cedula) {
        ClienteDTO cliente = clienteService.obtenerClientePorCedula(cedula);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Inexistente");
        }
        return ResponseEntity.ok(cliente);
    }


    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO actualizado = clienteService.actualizarCliente(clienteDTO);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
        try {
            clienteService.eliminarCliente(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

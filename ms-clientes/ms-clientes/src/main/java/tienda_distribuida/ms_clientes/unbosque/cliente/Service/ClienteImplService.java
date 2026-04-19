package com.example.tienda_generica_distribuidos.unbosque.cliente.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tienda_generica_distribuidos.unbosque.cliente.DTO.ClienteDTO;
import com.example.tienda_generica_distribuidos.unbosque.cliente.Entidad.ClienteEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteImplService implements ClienteInterface {

    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteDTO mapToDTO(ClienteEntidad entidad) {
        return new ClienteDTO(
                entidad.getCedulaCliente(),
                entidad.getNombreCliente(),
                entidad.getDireccionCliente(),
                entidad.getEmailCliente(),
                entidad.getTelefonoCliente()
        );
    }


    private ClienteEntidad mapToEntidad(ClienteDTO dto) {
        return new ClienteEntidad(
                dto.getCedulaCliente(),
                dto.getNombreCliente(),
                dto.getDireccionCliente(),
                dto.getEmailCliente(),
                dto.getTelefonoCliente()
        );
    }


    @Override
    public ClienteDTO guardarCliente(ClienteDTO clienteDTO) {
        if (clienteDTO.getCedulaCliente() == null
                || clienteDTO.getNombreCliente()    == null || clienteDTO.getNombreCliente().isBlank()
                || clienteDTO.getDireccionCliente() == null || clienteDTO.getDireccionCliente().isBlank()
                || clienteDTO.getEmailCliente()     == null || clienteDTO.getEmailCliente().isBlank()
                || clienteDTO.getTelefonoCliente()  == null || clienteDTO.getTelefonoCliente().isBlank()) {
            throw new IllegalArgumentException("Faltan datos del cliente");
        }
        ClienteEntidad entidad = clienteRepository.save(mapToEntidad(clienteDTO));
        return mapToDTO(entidad);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        List<ClienteEntidad> entidades = clienteRepository.findAll();
        List<ClienteDTO> lista = new ArrayList<>();
        for (ClienteEntidad e : entidades) {
            lista.add(mapToDTO(e));
        }
        return lista;
    }

    @Override
    public ClienteDTO obtenerClientePorCedula(Long cedula) {
        Optional<ClienteEntidad> optional = clienteRepository.findById(cedula);
        return optional.map(this::mapToDTO).orElse(null);
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) {
        if (!clienteRepository.existsById(clienteDTO.getCedulaCliente())) {
            throw new IllegalArgumentException("Cliente Inexistente");
        }
        if (clienteDTO.getNombreCliente()    == null || clienteDTO.getNombreCliente().isBlank()
                || clienteDTO.getDireccionCliente() == null || clienteDTO.getDireccionCliente().isBlank()
                || clienteDTO.getEmailCliente()     == null || clienteDTO.getEmailCliente().isBlank()
                || clienteDTO.getTelefonoCliente()  == null || clienteDTO.getTelefonoCliente().isBlank()) {
            throw new IllegalArgumentException("Datos faltantes");
        }
        ClienteEntidad entidad = clienteRepository.save(mapToEntidad(clienteDTO));
        return mapToDTO(entidad);
    }


    @Override
    public void eliminarCliente(Long cedula) {
        if (!clienteRepository.existsById(cedula)) {
            throw new IllegalArgumentException("Cédula Errada");
        }
        clienteRepository.deleteById(cedula);
    }
}
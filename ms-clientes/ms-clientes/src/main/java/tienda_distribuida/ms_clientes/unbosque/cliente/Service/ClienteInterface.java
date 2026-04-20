package tienda_distribuida.ms_clientes.unbosque.cliente.Service;

import tienda_distribuida.ms_clientes.unbosque.cliente.DTO.ClienteDTO;
import java.util.List;


public interface ClienteInterface {


    ClienteDTO guardarCliente(ClienteDTO clienteDTO);


    List<ClienteDTO> listarClientes();


    ClienteDTO obtenerClientePorCedula(Long cedula);


    ClienteDTO actualizarCliente(ClienteDTO clienteDTO);


    void eliminarCliente(Long cedula);
}



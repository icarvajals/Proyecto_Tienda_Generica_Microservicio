package com.example.tienda_generica_distribuidos.unbosque.usuario.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tienda_generica_distribuidos.unbosque.usuario.DTO.UsuarioDTO;
import com.example.tienda_generica_distribuidos.unbosque.usuario.Entidad.UsuarioEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioImplService implements UsuarioInterface {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioDTO mapToDTO(UsuarioEntidad entidad) {
        return new UsuarioDTO(
                entidad.getCedulaUsuario(),
                entidad.getNombreUsuario(),
                entidad.getDireccionUsuario(),
                entidad.getEmailUsuario(),
                entidad.getTelefono(),
                entidad.getPassword()
        );
    }

    private UsuarioEntidad mapToEntidad(UsuarioDTO dto) {
        return new UsuarioEntidad(
                dto.getCedulaUsuario(),
                dto.getNombreUsuario(),
                dto.getDireccionUsuario(),
                dto.getEmailUsuario(),
                dto.getTelefono(),
                dto.getPassword()
        );
    }

    @Override
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getCedulaUsuario() == null
                || usuarioDTO.getNombreUsuario() == null || usuarioDTO.getNombreUsuario().isBlank()
                || usuarioDTO.getDireccionUsuario() == null || usuarioDTO.getDireccionUsuario().isBlank()
                || usuarioDTO.getEmailUsuario()  == null || usuarioDTO.getEmailUsuario().isBlank()
                || usuarioDTO.getTelefono()       == null || usuarioDTO.getTelefono().isBlank()
                || usuarioDTO.getPassword()      == null || usuarioDTO.getPassword().isBlank()) {
            throw new IllegalArgumentException("Faltan datos del usuario");
        }
        UsuarioEntidad entidad = usuarioRepository.save(mapToEntidad(usuarioDTO));
        return mapToDTO(entidad);
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioEntidad> entidades = usuarioRepository.findAll();
        List<UsuarioDTO> lista = new ArrayList<>();
        for (UsuarioEntidad e : entidades) {
            lista.add(mapToDTO(e));
        }
        return lista;
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorCedula(Long cedula) {
        Optional<UsuarioEntidad> optional = usuarioRepository.findById(cedula);
        return optional.map(this::mapToDTO).orElse(null);
    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO) {
        if (!usuarioRepository.existsById(usuarioDTO.getCedulaUsuario())) {
            throw new IllegalArgumentException("Usuario Inexistente");
        }
        if (usuarioDTO.getNombreUsuario() == null || usuarioDTO.getNombreUsuario().isBlank()
                || usuarioDTO.getEmailUsuario()  == null || usuarioDTO.getEmailUsuario().isBlank()
                || usuarioDTO.getTelefono()       == null || usuarioDTO.getTelefono().isBlank()
                || usuarioDTO.getPassword()      == null || usuarioDTO.getPassword().isBlank()) {
            throw new IllegalArgumentException("Datos faltantes");
        }
        UsuarioEntidad entidad = usuarioRepository.save(mapToEntidad(usuarioDTO));
        return mapToDTO(entidad);
    }

    @Override
    public void eliminarUsuario(Long cedula) {
        if (!usuarioRepository.existsById(cedula)) {
            throw new IllegalArgumentException("Cédula Errada");
        }
        usuarioRepository.deleteById(cedula);
    }

    @Override
    public boolean login(int usuario, String password) {
        UsuarioEntidad usuarioDB = usuarioRepository.findById((long) usuario).orElse(null);
        if (usuarioDB == null){
            return false;
        }
        if (usuarioDB.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}

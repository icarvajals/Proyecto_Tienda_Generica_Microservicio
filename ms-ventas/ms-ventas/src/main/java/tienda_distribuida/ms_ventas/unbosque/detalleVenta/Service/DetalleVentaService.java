package com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tienda_generica_distribuidos.unbosque.detalleVenta.DTO.DetalleVentaDTO;
import com.example.tienda_generica_distribuidos.unbosque.detalleVenta.Entidad.DetalleVentaEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService implements DetalleVentaInterface {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public DetalleVentaDTO guardarDetalle(DetalleVentaDTO detalleVentaDTO) {
        DetalleVentaEntidad entidad = new DetalleVentaEntidad(
                0,
                detalleVentaDTO.getCodigo_producto(),
                detalleVentaDTO.getCodigo_venta(),
                detalleVentaDTO.getCantidad_producto(),
                detalleVentaDTO.getValor_total(),
                detalleVentaDTO.getValor_venta(),
                detalleVentaDTO.getValoriva()
        );

        try {
            DetalleVentaEntidad guardado = detalleVentaRepository.save(entidad);
            detalleVentaDTO.setCodigo_detalle_venta(guardado.getCodigo_detalle_venta());
            return detalleVentaDTO;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<DetalleVentaDTO> listarDetalles() {
        List<DetalleVentaEntidad> lista = detalleVentaRepository.findAll();
        List<DetalleVentaDTO> dtos = new ArrayList<>();

        for (DetalleVentaEntidad d : lista) {
            dtos.add(new DetalleVentaDTO(
                    d.getCodigo_detalle_venta(),
                    d.getCodigo_producto(),
                    d.getCodigo_venta(),
                    d.getCantidad_producto(),
                    d.getValor_total(),
                    d.getValor_venta(),
                    d.getValoriva()
            ));
        }
        return dtos;
    }

    @Override
    public DetalleVentaDTO buscarPorId(int id) {
        DetalleVentaEntidad d = detalleVentaRepository.findById(id).orElse(null);

        if (d == null) return null;
        return new DetalleVentaDTO(
                d.getCodigo_detalle_venta(),
                d.getCodigo_producto(),
                d.getCodigo_venta(),
                d.getCantidad_producto(),
                d.getValor_total(),
                d.getValor_venta(),
                d.getValoriva()
        );
    }

    @Override
    public String actualizarDetalle(int id, DetalleVentaDTO dto) {
        Optional<DetalleVentaEntidad> existente =
                detalleVentaRepository.findById(dto.getCodigo_detalle_venta());

        if (existente.isEmpty()) {
            return "Detalle venta imposible de actualizar";
        }

        DetalleVentaEntidad entidad = existente.get();
        entidad.setCodigo_producto(dto.getCodigo_producto());
        entidad.setCodigo_venta(dto.getCodigo_venta());
        entidad.setCantidad_producto(dto.getCantidad_producto());
        entidad.setValor_total(dto.getValor_total());
        entidad.setValor_venta(dto.getValor_venta());
        entidad.setValoriva(dto.getValoriva());

        detalleVentaRepository.save(entidad);
        return "Detalle venta actualizado correctamente";
    }

    @Override
    public String borrarDetalle(int id) {
        try {
            detalleVentaRepository.deleteById(id);
            return "Detalle venta eliminado";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}

package com.example.tienda_generica_distribuidos.unbosque.venta.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tienda_generica_distribuidos.unbosque.venta.DTO.VentaDTO;
import com.example.tienda_generica_distribuidos.unbosque.venta.Entidad.VentaEntidad;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaImplService implements VentaInterface {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Object[]> reportePorCliente() {
        return ventaRepository.obtenerVentasPorCliente();
    }

    public List<Object[]> obtenerDetalleFactura(int codigoVenta) {
        return ventaRepository.obtenerDetallePorVenta(codigoVenta);
    }

    @Override
    public VentaDTO guardarVenta(VentaDTO ventaDTO) {
        VentaEntidad entidad = new VentaEntidad();
        entidad.setCedula_cliente(ventaDTO.getCedula_cliente());
        entidad.setCedula_usuario(ventaDTO.getCedula_usuario());
        entidad.setIvaventa(ventaDTO.getIvaventa());
        entidad.setValor_venta(ventaDTO.getValor_venta());
        entidad.setTotal_venta(ventaDTO.getTotal_venta());
        try {
            VentaEntidad guardada = ventaRepository.save(entidad);
            ventaDTO.setCodigo_venta(guardada.getCodigo_venta());
            return ventaDTO;
        } catch (Exception e) { return null; }
    }

    @Override
    public List<VentaDTO> listarVentas() {
        List<VentaEntidad> ventas = ventaRepository.findAll();
        List<VentaDTO> listaDTO = new ArrayList<>();
        for (VentaEntidad v : ventas) {
            listaDTO.add(new VentaDTO(v.getCodigo_venta(), v.getCedula_cliente(), v.getCedula_usuario(), v.getIvaventa(), v.getValor_venta(), v.getTotal_venta()));
        }
        return listaDTO;
    }

    @Override
    public VentaDTO buscarPorId(int id) {
        VentaEntidad v = ventaRepository.findById(id).orElse(null);
        if (v == null) return null;
        return new VentaDTO(v.getCodigo_venta(), v.getCedula_cliente(), v.getCedula_usuario(), v.getIvaventa(), v.getValor_venta(), v.getTotal_venta());
    }

    @Override
    public String actualizarVenta(int id, VentaDTO v) { return ""; }

    @Override
    public String borrarVenta(int id) { return ""; }
}
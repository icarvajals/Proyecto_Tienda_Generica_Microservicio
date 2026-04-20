package tienda_distribuida.ms_usuarios.unbosque.usuario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long   cedulaUsuario;
    private String nombreUsuario;
    private String direccionUsuario;
    private String emailUsuario;
    private String telefono;
    private String password;
}
package com.itp.ingsoftII.restaurante.controlador;

import com.itp.ingsoftII.restaurante.entidad.Usuario;
import com.itp.ingsoftII.restaurante.servicio.UsuarioServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        return usuarioServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<Usuario> obtenerUsuarioPorCorreo(@PathVariable String correo) {
        return usuarioServicio.obtenerPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioServicio.obtenerTodosUsuarios();
    }

    @PutMapping("/{id}")
    public Usuario modificarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioServicio.modificarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioServicio.eliminarUsuario(id);
    }
}

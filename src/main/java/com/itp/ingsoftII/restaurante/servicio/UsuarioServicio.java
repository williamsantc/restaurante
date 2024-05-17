package com.itp.ingsoftII.restaurante.servicio;

import com.itp.ingsoftII.restaurante.entidad.Usuario;
import com.itp.ingsoftII.restaurante.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return this.usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> obtenerPorId(int id) {
        return this.usuarioRepositorio.findById(id);
    }

    public Optional<Usuario> obtenerPorCorreo(String correo) {
        return Optional.ofNullable(this.usuarioRepositorio.findByCorreo(correo));
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    public Usuario modificarUsuario(Usuario usuario) {
        return this.usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(int id) {
        this.usuarioRepositorio.deleteById(id);
    }
}

package com.itp.ingsoftII.restaurante.repositorio;


import com.itp.ingsoftII.restaurante.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String correo);
}

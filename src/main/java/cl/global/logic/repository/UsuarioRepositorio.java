package cl.global.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.global.logic.model.UsuarioModel;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioModel, Integer>{

}

package cl.global.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.global.logic.model.TelefonoModel;

@Repository
public interface TelefonoRepositorio extends JpaRepository<TelefonoModel, Integer>{

}

package cl.global.logic.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cl.global.logic.model.TelefonoModel;
import cl.global.logic.model.UsuarioModel;
import cl.global.logic.repository.UsuarioRepositorio;

@Configuration
@EnableJpaRepositories(basePackageClasses = UsuarioRepositorio.class)
@EntityScan(basePackageClasses = {UsuarioModel.class, TelefonoModel.class })
public class JpaDbConfiguration {

}

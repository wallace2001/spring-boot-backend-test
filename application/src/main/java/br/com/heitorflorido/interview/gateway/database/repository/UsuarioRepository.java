package br.com.heitorflorido.interview.gateway.database.repository;

import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveCrudRepository<UsuarioData, Long> {
    Mono<UsuarioData> findByNome(String nome);

}

package br.com.heitorflorido.interview.gateway.database.repository;

import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.model.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioRepository extends ReactiveCrudRepository<UsuarioData, Long> {
    Mono<UsuarioData> findByNome(String nome);
    Mono<UsuarioData> save(Usuario usuario);
    @Query("SELECT * FROM seg_usuario WHERE LOWER(nm_usuario) LIKE LOWER(CONCAT('%', :nameFilter, '%'))")
    Flux<UsuarioData> findAllBy(Pageable pageable, String nameFilter);

}

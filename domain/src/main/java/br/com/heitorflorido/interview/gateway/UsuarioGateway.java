package br.com.heitorflorido.interview.gateway;

import br.com.heitorflorido.interview.model.Usuario;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

public interface UsuarioGateway {
    Mono<Usuario> execute(Long id);
    Mono<Void> delete(Long id);
    Mono<Usuario> update(Usuario usuario);
    Mono<Page<Usuario>> execute(int page, int size, String nameFilter);
}

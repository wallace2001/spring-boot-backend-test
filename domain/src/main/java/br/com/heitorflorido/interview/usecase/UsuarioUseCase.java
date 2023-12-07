package br.com.heitorflorido.interview.usecase;


import br.com.heitorflorido.interview.gateway.UsuarioGateway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public Mono<Usuario> execute(Long id) {
        return usuarioGateway.execute(id);
    }
    public Mono<Usuario> update(Usuario usuario) {
        return usuarioGateway.update(usuario);
    }
    public Mono<Void> delete(Long id) {
        return usuarioGateway.delete(id);
    }
    public Mono<Page<Usuario>> execute(int page, int size, String nameFilter) {
        return usuarioGateway.execute(page, size, nameFilter);
    }
}

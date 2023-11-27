package br.com.heitorflorido.interview.usecase;


import br.com.heitorflorido.interview.gateway.ObterUsuarioGateway;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ObterUsuarioUseCase {

    private final ObterUsuarioGateway obterUsuarioGateway;

    public Mono<Usuario> execute(Long id) {
        return obterUsuarioGateway.execute(id);
    }
}

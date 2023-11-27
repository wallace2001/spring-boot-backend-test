package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.ObterUsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class ObterUsuarioDatabaseGateway implements ObterUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Mono<Usuario> execute(Long id) {
        return usuarioRepository.findById(id)
            .map(UsuarioData::toUsuario);
    }
}

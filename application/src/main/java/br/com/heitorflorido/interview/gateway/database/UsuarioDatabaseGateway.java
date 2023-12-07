package br.com.heitorflorido.interview.gateway.database;

import br.com.heitorflorido.interview.gateway.UsuarioGateway;
import br.com.heitorflorido.interview.gateway.database.model.UsuarioData;
import br.com.heitorflorido.interview.gateway.database.repository.UsuarioRepository;
import br.com.heitorflorido.interview.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;

import javax.inject.Named;
import java.util.stream.Collectors;

@Named
@RequiredArgsConstructor
public class UsuarioDatabaseGateway implements UsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Mono<Usuario> execute(Long id) {
        return usuarioRepository.findById(id)
            .map(UsuarioData::toUsuario);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return usuarioRepository.deleteById(id);
    }

    @Override
    public Mono<Usuario> update(Usuario usuario) {
        UsuarioData usuarioData = UsuarioData.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .telefone(usuario.getTelefone())
            .uf(usuario.getUf())
            .dataNascimento(usuario.getDataNascimento())
            .build();
        return usuarioRepository.save(usuarioData)
            .map(UsuarioData::toUsuario);
    }

    @Override
    public Mono<Page<Usuario>> execute(int page, int size, String nameFilter) {
        PageRequest pageable = PageRequest.of(page, size);
        return usuarioRepository.findAllBy(pageable, nameFilter)
            .collectList()
            .zipWith(this.usuarioRepository.count())
            .map(p -> new PageImpl<>(p.getT1().stream().map(UsuarioData::toUsuario).collect(Collectors.toList()), pageable, p.getT2()));
    }
}

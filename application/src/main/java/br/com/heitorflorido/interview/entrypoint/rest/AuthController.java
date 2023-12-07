package br.com.heitorflorido.interview.entrypoint.rest;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioUseCase usuarioUseCase;

    @GetMapping("/usuario/{id}")
    public Mono<Usuario> validar(final @PathVariable Long id) {
        return usuarioUseCase.execute(id);
    }

    @GetMapping("/usuarios")
    public Mono<Page<Usuario>> listar(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String nameFilter
    ) {
        return usuarioUseCase.execute(page, size, nameFilter);
    }

    @PatchMapping("/usuario/{id}")
    public Mono<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioUseCase.execute(id)
            .flatMap(usuarioExistente -> {
                Usuario novoUsuario = Usuario.builder()
                    .id(id)
                    .nome(usuario.getNome())
                    .cidade(usuario.getCidade())
                    .telefone(usuario.getTelefone())
                    .uf(usuario.getUf())
                    .dataNascimento(usuario.getDataNascimento())
                    .build();

                return usuarioUseCase.update(novoUsuario);
            });
    }


    @DeleteMapping("/usuario/{id}")
    public Mono<Void> deletar(@PathVariable Long id) {
        return usuarioUseCase.delete(id);
    }
}

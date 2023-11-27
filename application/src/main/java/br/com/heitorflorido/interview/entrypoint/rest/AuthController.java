package br.com.heitorflorido.interview.entrypoint.rest;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.usecase.ObterUsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final ObterUsuarioUseCase obterUsuarioUseCase;

    @GetMapping("/usuario/{id}")
    public Mono<Usuario> validar(final @PathVariable Long id) {
        return obterUsuarioUseCase.execute(id);
    }
}

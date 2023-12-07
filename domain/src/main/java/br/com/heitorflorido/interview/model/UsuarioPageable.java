package br.com.heitorflorido.interview.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder(toBuilder = true)
public class UsuarioPageable {
    List<Usuario> usuarios;
    int size;
    int totalPage;
    int number;

}

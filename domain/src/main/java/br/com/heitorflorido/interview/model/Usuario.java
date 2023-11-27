package br.com.heitorflorido.interview.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Usuario {

    Long id;
    String nome;
    String cidade;
    String uf;
}

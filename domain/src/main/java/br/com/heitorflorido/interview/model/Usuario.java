package br.com.heitorflorido.interview.model;

import lombok.Builder;
import lombok.Value;

import java.sql.Date;
import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class Usuario {

    Long id;
    String nome;
    String cidade;
    String uf;
    String telefone;
    LocalDate dataNascimento;
}

package br.com.heitorflorido.interview.gateway.database.model;

import br.com.heitorflorido.interview.model.Usuario;
import br.com.heitorflorido.interview.model.UsuarioPageable;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Collectors;

@Value
@Builder
@Table("seg_usuario")
public class UsuarioData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column("id_usuario")
    Long id;
    @Column("nm_usuario")
    String nome;
    @Column("ds_cidade")
    String cidade;
    @Column("nr_telefone")
    String telefone;
    @Column("data_nascimento")
    LocalDate dataNascimento;
    @Column("cd_uf")
    String uf;

    public static UsuarioData toUsuarioData(final Usuario usuario) {

        return UsuarioData.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .telefone(usuario.getTelefone())
            .cidade(usuario.getCidade())
            .uf(usuario.getUf())
            .build();
    }

    public static Usuario toUsuario(final UsuarioData usuario) {

        return Usuario.builder()
            .id(usuario.getId())
            .nome(usuario.getNome())
            .cidade(usuario.getCidade())
            .telefone(usuario.getTelefone())
            .dataNascimento(usuario.getDataNascimento())
            .uf(usuario.getUf())
            .build();
    }

    public static UsuarioPageable toUsuarioPageable(final Page<UsuarioData> pageUser) {
        return UsuarioPageable.builder()
            .usuarios(pageUser.getContent().stream().map(UsuarioData::toUsuario).collect(Collectors.toList()))
            .size(pageUser.getSize())
            .totalPage(pageUser.getTotalPages())
            .number(pageUser.getNumber())
            .build();
    }
}

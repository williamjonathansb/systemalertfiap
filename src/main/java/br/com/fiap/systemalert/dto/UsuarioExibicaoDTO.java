package br.com.fiap.systemalert.dto;

import br.com.fiap.systemalert.model.Usuario;

public record UsuarioExibicaoDTO (
        Long usuarioId,
        String nome,
        String email) {

    public UsuarioExibicaoDTO(Usuario usuario) {
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
package br.com.fiap.systemalert.dto;

import java.util.Date;

public record AlertaDesastreCadastroDTO(
        Long alertaDesastreId,
        String area,
        String nivel,
        String tipo,
        String mensagem,
        Date Data
) {
}
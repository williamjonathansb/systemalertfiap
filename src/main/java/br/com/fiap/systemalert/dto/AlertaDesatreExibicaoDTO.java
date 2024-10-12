package br.com.fiap.systemalert.dto;

import br.com.fiap.systemalert.model.AlertaDesastre;

import java.util.Date;

public record AlertaDesatreExibicaoDTO(
        Long alertaDesastreId,
        String area,
        String nivel,
        String tipo,
        String mensagem,
        Date Data

) {

    public AlertaDesatreExibicaoDTO(AlertaDesastre alertaDesastre) {
        this(
                alertaDesastre.getAlertaDesastreId(),
                alertaDesastre.getArea(),
                alertaDesastre.getNivel(),
                alertaDesastre.getTipo(),
                alertaDesastre.getMensagem(),
                alertaDesastre.getData()
        );
    }

}
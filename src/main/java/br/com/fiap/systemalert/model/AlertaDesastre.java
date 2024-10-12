package br.com.fiap.systemalert.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_alertadesastres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AlertaDesastre {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ALERTADESASTRE"
    )
    @SequenceGenerator(
            name = "SEQ_ALERTADESASTRE",
            sequenceName = "SEQ_ALERTADESASTRE",
            allocationSize = 1
    )
    private Long alertaDesastreId;

    private String tipo;
    private String area;
    private String nivel;
    private String mensagem;
    private Date data;
}
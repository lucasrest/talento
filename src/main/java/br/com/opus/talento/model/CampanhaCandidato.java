package br.com.opus.talento.model;

import br.com.opus.talento.anotation.DataAPI;
import br.com.opus.talento.enums.Status;
import br.com.opus.talento.util.LocalDateTimeUtils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
//@Entity
@Table(name = "campanha_candidato", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_campanha_candidato", name = "id", schema = "opus", allocationSize = 1)
public class CampanhaCandidato {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    private Long id;

    @DataAPI
    @Column
    private LocalDateTime alteracao;

    @DataAPI
    @Column(nullable = false)
    private LocalDateTime inclusao;

    @Column
    private Integer status = Status.ATIVO.getValue();

    @Column(name = "campanha_id")
    private Long campanhaId;

    @Column(name = "candidato_id")
    private Long candidatoId;

    @PrePersist
    public void prePersist() {
        inclusao = LocalDateTimeUtils.dataAtual();
    }

    @PreUpdate
    public void preUpdate() {
        alteracao = LocalDateTimeUtils.dataAtual();
    }
}

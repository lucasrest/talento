package br.com.opus.talento.robo.model;

import br.com.opus.talento.anotation.DataAPI;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_formacao_academica", schema = "bsx")
@SequenceGenerator(sequenceName = "bsx.seq_tb_formacao_academica", name = "id", schema = "bsx", allocationSize = 1)
public class FormacaoAcademica {

    @Id
    private Long id;

    private String nivel;
    private String outrosCursos;
    private String idioma;

    private String instituicao;
    private String curso;
    private Boolean atual;

    @DataAPI
    @Column(name = "ano_conclusao")
    private LocalDateTime anoConclusao;

    @OneToOne
    @JsonBackReference("formacoes")
    @JoinColumn(name = "id_resultado", referencedColumnName = "id")
    private Resultado resultado;
}


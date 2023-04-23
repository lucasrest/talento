package br.com.opus.talento.robo.model;

import br.com.opus.talento.anotation.DataAPI;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_experiencia_profissional", schema = "bsx")
@SequenceGenerator(sequenceName = "bsx.seq_tb_experiencia_profissional", name = "id", schema = "bsx", allocationSize = 1)
public class ExperienciaProfissional  {

    @Id
    private Long id;

    private String nomeEmpresa;
    private String periodoEmpresa;
    private String atividadeEmpresa;
    private String funcao;
    private String atribuicoes;
    private BigDecimal ultimoSalario;

    private Boolean atual;

    @DataAPI
    @Column(name = "data_inicial")
    private LocalDateTime dataInicial;

    @DataAPI
    @Column(name = "data_final")
    private LocalDateTime dataFinal;

    @OneToOne
    @JsonBackReference("experiencias")
    @JoinColumn(name = "id_resultado", referencedColumnName = "id")
    private Resultado resultado;
}


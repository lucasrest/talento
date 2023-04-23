package br.com.opus.talento.robo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_idioma", schema = "bsx",
        indexes = {
                @Index(name = "tb_idioma_pk", columnList = "id", unique = true),
                @Index(name = "fk_resultado", columnList = "id_resultado")
        })
@SequenceGenerator(sequenceName = "bsx.seq_tb_idioma", name = "id", schema = "bsx", allocationSize = 1)
public class Idioma  {

    @Id
    private Long id;

    private String descricao;

    private String nivel;

    @ManyToOne
    @JsonBackReference("idiomas")
    @JoinColumn(name = "id_resultado", referencedColumnName = "id")
    private Resultado resultado;

}


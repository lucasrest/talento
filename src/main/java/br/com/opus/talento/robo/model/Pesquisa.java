package br.com.opus.talento.robo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_pesquisa", schema = "bsx")
@SequenceGenerator(sequenceName = "bsx.seq_tb_pesquisa", name = "id", schema = "bsx", allocationSize = 1)
public class Pesquisa  {

    @Id
    private Long id;

    private String uuid;
//    private OrigemEnum origemEnum;

    private Long campanhaId;

    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference("resultados")
    @OneToMany(mappedBy = "pesquisa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Resultado> resultados = new ArrayList<>();

}

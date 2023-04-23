package br.com.opus.talento.robo.model;

import br.com.opus.talento.anotation.DataAPI;
import br.com.opus.talento.robo.enums.OrigemEnum;
import br.com.opus.talento.robo.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "tb_resultado", schema = "bsx")
@SequenceGenerator(sequenceName = "bsx.seq_tb_resultado", name = "id", schema = "bsx", allocationSize = 1)
public class Resultado {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;
    private String email;
    private Integer idade;
    private String sexo;
    private String cargo;
    private BigDecimal salario;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String cep;
    private String telefone;
    private String telefoneResidencial;
    private String estadoCivil;
    private String deficiencia;
    private String sms;
    private String curriculoUrl;
    private String idCurriculo;
    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacao = SituacaoEnum.CARREGADO;
    @Enumerated(EnumType.STRING)
    private OrigemEnum origem = OrigemEnum.BNE;
    private String github;
    private String linkedin;
    private String mensagem;
    private BigDecimal pretensao;
    private boolean bloqueadoContratacao;
    private boolean autorizado;
    private boolean primeiroContato;
    private boolean desautorizadoPeloCandidato;
    private boolean bloqueadoPeriodoExclusividade;
    private boolean msgDia;
    private String hireable;
    private int publicRepos;
    private int publicGists;
    private int followers;
    private int following;
    private String twitter;
    private String gitCriadoDesde;
    @DataAPI
    @Column(name = "data_contratacao")
    private LocalDateTime dataContratacao;
    @DataAPI
    @Column(name = "data_exclusividade")
    private LocalDateTime dataExclusividade;

    @Column(nullable = false)
    private String uuid;


    @OneToOne
    @JsonBackReference("resultados")
    @JoinColumn(name = "id_pesquisa", referencedColumnName = "id")
    private Pesquisa pesquisa;

    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference("experiencias")
    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ExperienciaProfissional> experienciasProfissionais = new ArrayList<>();

    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference("formacoes")
    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<FormacaoAcademica> formacoesAcademicas = new ArrayList<>();

    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference("idiomas")
    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Idioma> idiomas = new ArrayList<>();

}


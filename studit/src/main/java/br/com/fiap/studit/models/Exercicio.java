package br.com.fiap.studit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_studit_exercicio")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercicio_id")
    private Long id;

    @NotNull(message = "A pergunta é obrigatória")
    @Column(name = "exercicio_pergunta")
    private String pergunta;

    @ElementCollection
    @CollectionTable(name = "tb_studit_exercicio_alternativas", joinColumns = @JoinColumn(name = "exercicio_id"))
    @Column(name = "alternativa")
    private List<String> alternativas;


    @NotNull(message = "A resposta do exercício é obrigatória")
    @Column(name = "exercicio_resposta")
    private String resposta;

    @NotNull(message = "A resolução do exercício é obrigatória")
    @Column(name = "exercicio_resolucao")
    private String resolucao;

    @NotNull(message = "A matéria é obrigatótia para o exercício")
    @Column(name = "exercicio_materia")
    private MateriaEnum materiaEnum;

    @NotNull(message = "O usuário é obrigatório")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

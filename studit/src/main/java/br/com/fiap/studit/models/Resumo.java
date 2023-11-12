package br.com.fiap.studit.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_studit_resumo")
public class Resumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resumo_id")
    private Long id;

    @NotNull(message = "O conteúdo é obrigatório")
    @Column(name = "resumo_conteudo")
    private String conteudo;

    @NotNull(message = "A data de criação do resumo é obrigatória")
    @Column(name = "resumo_data")
    private LocalDateTime dataCriacao;

    @Column(name = "resumo_materia")
    private MateriaEnum materiaEnum;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

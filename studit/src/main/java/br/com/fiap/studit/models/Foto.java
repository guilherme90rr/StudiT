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
@Table(name = "tb_studit_foto")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foto_id")
    private Long id;

    @NotNull(message = "A url da imagem é obigatório")
    @Column(name = "foto_url")
    private String url;

    @Column(name = "foto_descricao")
    private String descricao;

    @NotNull(message = "O tamanho da imagem em bytes é obrigatório")
    @Column(name = "foto_tamanho")
    private int tamanhoBytes;

    @NotNull(message = "A data de criação da foto é obrrigatório")
    @Column(name = "foto_data")
    private LocalDateTime dataCriacao;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

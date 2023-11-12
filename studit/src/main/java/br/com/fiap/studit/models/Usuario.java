package br.com.fiap.studit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_studit_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @NotNull(message = "O nome do usuário pe obrigatório")
    @Column(name = "usuario_nome")
    private String nome;

    @NotNull(message = "O email do usuário é obrigatório")
    @Column(name = "usuario_email")
    private String email;

    @NotNull(message = "A senha do usuário é obrigatório")
    @Column(name = "usuario_senha")
    private String senha;

    @Column(name = "usuario_data")
    private LocalDateTime dataNascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Foto> fotos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Resumo> resumos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Exercicio> exercicios;
}

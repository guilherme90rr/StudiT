package br.com.fiap.studit.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private LocalDateTime dataNascimento;
}


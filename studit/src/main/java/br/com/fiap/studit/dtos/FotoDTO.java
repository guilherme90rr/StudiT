package br.com.fiap.studit.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FotoDTO {
    private String url;

    private String descricao;

    private int tamanhoBytes;

    private LocalDateTime dataCriacao;
}


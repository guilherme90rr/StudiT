package br.com.fiap.studit.dtos;

import br.com.fiap.studit.models.MateriaEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResumoDTO {
    private String conteudo;

    private LocalDateTime dataCriacao;

    private MateriaEnum materiaEnum;
}

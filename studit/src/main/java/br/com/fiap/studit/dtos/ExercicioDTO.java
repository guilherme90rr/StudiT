package br.com.fiap.studit.dtos;

import br.com.fiap.studit.models.MateriaEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ExercicioDTO {
    private String pergunta;

    private List<String> alternativas;

    private String resposta;

    private String resolucao;

    private MateriaEnum materiaEnum;
}

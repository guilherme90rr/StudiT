package br.com.fiap.studit.services;

import br.com.fiap.studit.models.Exercicio;
import br.com.fiap.studit.models.MateriaEnum;
import br.com.fiap.studit.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {
    private final ExercicioRepository exercicioRepository;

    @Autowired
    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Page<Exercicio> getAllExercicios(Pageable pageable) {
        return exercicioRepository.findAll(pageable);
    }

    public Page<Exercicio> getAllExerciciosByMateria(String materia, Pageable pageable) {
        Exercicio exemplo = new Exercicio();
        exemplo.setMateriaEnum(MateriaEnum.valueOf(materia));

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Exercicio> example = Example.of(exemplo, matcher);

        return exercicioRepository.findAll(example, pageable);
    }

    public Optional<Exercicio> getExercicioById(Long id) {
        return exercicioRepository.findById(id);
    }

    public Exercicio saveExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public Exercicio updateExercicio(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }

    public void deleteExercicioById(Long id) {
        exercicioRepository.deleteById(id);
    }
}

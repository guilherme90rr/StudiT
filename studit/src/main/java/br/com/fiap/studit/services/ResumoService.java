package br.com.fiap.studit.services;

import br.com.fiap.studit.models.MateriaEnum;
import br.com.fiap.studit.models.Resumo;
import br.com.fiap.studit.repository.ResumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class ResumoService {
    private final ResumoRepository resumoRepository;

    @Autowired
    public ResumoService(ResumoRepository resumoRepository) {
        this.resumoRepository = resumoRepository;
    }

    public Page<Resumo> getAllResumos(Pageable pageable) {
        return resumoRepository.findAll(pageable);
    }

    public Page<Resumo> getAllResumosByConteudo(String conteudo, Pageable pageable) {
        return resumoRepository.findByConteudoContainingIgnoreCase(conteudo, pageable);
    }

    public Page<Resumo> getAllResumosByConteudoAndMateria(String conteudo, Pageable pageable, String materia) {
        MateriaEnum materiaEnum = null;

        if (!StringUtils.isEmpty(materia)) {
            try {
                materiaEnum = MateriaEnum.valueOf(materia);
            } catch (IllegalArgumentException e) {
            }
        }

        return resumoRepository.findByConteudoAndMateria(conteudo,materiaEnum,pageable);
    }

    public Page<Resumo> getAllResumosByMateria(Pageable pageable, String materia) {
        MateriaEnum materiaEnum = null;

        if (!StringUtils.isEmpty(materia)) {
            try {
                materiaEnum = MateriaEnum.valueOf(materia);
            } catch (IllegalArgumentException e) {
            }
        }

        return resumoRepository.findByMateria(materiaEnum,pageable);
    }

    public Optional<Resumo> getResumoById(Long id) {
        return resumoRepository.findById(id);
    }

    public Resumo saveResumo(Resumo resumo) {
        return resumoRepository.save(resumo);
    }

    public Resumo updateResumo(Resumo resumo) {
        return resumoRepository.save(resumo);
    }

    public void deleteResumoById(Long id) {
        resumoRepository.deleteById(id);
    }
}

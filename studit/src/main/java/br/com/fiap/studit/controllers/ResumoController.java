package br.com.fiap.studit.controllers;
import br.com.fiap.studit.dtos.ResumoDTO;
import br.com.fiap.studit.models.Resumo;
import br.com.fiap.studit.services.ResumoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/resumo")
public class ResumoController {
    private final ResumoService resumoService;

    @Autowired
    public ResumoController(ResumoService resumoService) {
        this.resumoService = resumoService;
    }

    @GetMapping
    public ResponseEntity<Page<Resumo>> getAllResumos(@RequestParam(required = false) String conteudo,
                                                      @RequestParam(required = false) String materia,
                                                      @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5) Pageable pageable) {
        Page<Resumo> resumos;
        if (!StringUtils.isEmpty(conteudo) && !StringUtils.isEmpty(materia)) {
            resumos = resumoService.getAllResumosByConteudoAndMateria(conteudo, pageable, materia);
        } else if (!StringUtils.isEmpty(conteudo)) {
            resumos = resumoService.getAllResumosByConteudo(conteudo, pageable);
        } else if (!StringUtils.isEmpty(materia)) {
            resumos = resumoService.getAllResumosByMateria(pageable, materia);
        } else {
            resumos = resumoService.getAllResumos(pageable);
        }
        return ResponseEntity.ok(resumos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resumo> getResumoById(@PathVariable Long id) {
        Optional<Resumo> resumo = resumoService.getResumoById(id);
        return resumo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Resumo> saveResumo(@RequestBody @Valid Resumo resumo) {
        Resumo savedResumo = resumoService.saveResumo(resumo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResumo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resumo> updateResumo(@PathVariable Long id, @RequestBody @Valid ResumoDTO resumoDTO) {
        Optional<Resumo> existingResumo = resumoService.getResumoById(id);

        if (existingResumo.isPresent()) {
            Resumo resumo = existingResumo.get();

            if (resumoDTO.getConteudo() != null) {
                resumo.setConteudo(resumoDTO.getConteudo());
            }
            if (resumoDTO.getDataCriacao() != null) {
                resumo.setDataCriacao(resumoDTO.getDataCriacao());
            }
            if (resumoDTO.getMateriaEnum() != null) {
                resumo.setMateriaEnum(resumoDTO.getMateriaEnum());
            }

            Resumo updatedResumo = resumoService.updateResumo(resumo);
            return ResponseEntity.ok(updatedResumo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResumoById(@PathVariable Long id) {
        Optional<Resumo> existingResumo = resumoService.getResumoById(id);
        if (existingResumo.isPresent()) {
            resumoService.deleteResumoById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

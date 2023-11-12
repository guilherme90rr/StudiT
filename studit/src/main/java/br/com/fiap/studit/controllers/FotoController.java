package br.com.fiap.studit.controllers;

import br.com.fiap.studit.dtos.FotoDTO;
import br.com.fiap.studit.models.Foto;
import br.com.fiap.studit.services.FotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foto")
public class FotoController {
    private final FotoService fotoService;

    @Autowired
    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping
    public ResponseEntity<List<Foto>> getAllFotos() {
        List<Foto> fotos = fotoService.getAllFotos();
        return ResponseEntity.ok(fotos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foto> getFotoById(@PathVariable Long id) {
        Optional<Foto> foto = fotoService.getFotoById(id);
        return foto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Foto> createFoto(@RequestBody @Valid Foto foto) {
        Foto createdFoto = fotoService.saveFoto(foto);
        return ResponseEntity.ok(createdFoto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foto> updateFoto(@PathVariable Long id, @RequestBody @Valid FotoDTO fotoDTO) {
        Optional<Foto> existingFoto = fotoService.getFotoById(id);

        if (existingFoto.isPresent()) {
            Foto foto = existingFoto.get();

            // Atualiza os campos com os valores do FotoDTO
            if (fotoDTO.getUrl() != null) {
                foto.setUrl(fotoDTO.getUrl());
            }
            if (fotoDTO.getDescricao() != null) {
                foto.setDescricao(fotoDTO.getDescricao());
            }
            if (fotoDTO.getTamanhoBytes() != 0) {
                foto.setTamanhoBytes(fotoDTO.getTamanhoBytes());
            }
            if (fotoDTO.getDataCriacao() != null) {
                foto.setDataCriacao(fotoDTO.getDataCriacao());
            }

            Foto updatedFoto = fotoService.updateFoto(foto);
            return ResponseEntity.ok(updatedFoto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoto(@PathVariable Long id) {
        Optional<Foto> existingFoto = fotoService.getFotoById(id);

        if (existingFoto.isPresent()) {
            fotoService.deleteFotoById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

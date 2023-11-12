package br.com.fiap.studit.services;

import br.com.fiap.studit.models.Foto;
import br.com.fiap.studit.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoService {
    private final FotoRepository fotoRepository;

    @Autowired
    public FotoService(FotoRepository fotoRepository){
        this.fotoRepository = fotoRepository;
    }

    public List<Foto> getAllFotos() {
        return fotoRepository.findAll();
    }

    public Optional<Foto> getFotoById(Long id) {
        return fotoRepository.findById(id);
    }

    public Foto saveFoto(Foto foto) {
        return fotoRepository.save(foto);
    }

    public Foto updateFoto(Foto foto) {
        return fotoRepository.save(foto);
    }

    public void deleteFotoById(Long id) {
        fotoRepository.deleteById(id);
    }
}

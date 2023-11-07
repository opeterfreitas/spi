package app.spi.services;

import app.spi.controllers.dtos.EmbalagemDTO;
import app.spi.models.Embalagem;
import app.spi.repositories.EmbalagemRepository;
import app.spi.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmbalagemService {

    private final EmbalagemRepository repository;

    public EmbalagemService(EmbalagemRepository repository) {
        this.repository = repository;
    }

    public Embalagem findById(Long id) {
        Optional<Embalagem> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Embalagem> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Embalagem create(EmbalagemDTO objDTO) {
        objDTO.setId(null);
        Embalagem newObj = new Embalagem(objDTO);
        return repository.save(newObj);
    }

    @Transactional
    public Embalagem update(Long id, EmbalagemDTO objDTO) {
        objDTO.setId(id);
        Embalagem oldObj = findById(id);
        oldObj = new Embalagem(objDTO);
        return repository.save(oldObj);
    }

    @Transactional
    public void delete(Long id) {
        Embalagem obj = findById(id);
        repository.deleteById(id);
    }
}

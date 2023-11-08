package app.spi.services;

import app.spi.controllers.dtos.DespesaDTO;
import app.spi.models.Despesa;
import app.spi.repositories.DespesaRepository;
import app.spi.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    private final DespesaRepository repository;

    public DespesaService(DespesaRepository repository) {
        this.repository = repository;
    }

    public Despesa findById(Long id) {
        Optional<Despesa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Despesa> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Despesa create(DespesaDTO objDTO) {
        objDTO.setId(null);
        Despesa newObj = new Despesa(objDTO);
        return repository.save(newObj);
    }

    @Transactional
    public Despesa update(Long id, DespesaDTO objDTO) {
        objDTO.setId(id);
        Despesa oldObj = findById(id);
        oldObj = new Despesa(objDTO);
        return repository.save(oldObj);
    }

    @Transactional
    public void delete(Long id) {
        Despesa obj = findById(id);
        repository.deleteById(id);
    }
}

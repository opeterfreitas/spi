package app.spi.services;

import app.spi.controllers.dtos.IngredienteDTO;
import app.spi.models.Ingrediente;
import app.spi.repositories.IngredienteRepository;
import app.spi.services.exceptions.DataIntegrityViolationException;
import app.spi.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    private final IngredienteRepository repository;

    public IngredienteService(IngredienteRepository repository) {
        this.repository = repository;
    }

    public Ingrediente findById(Long id) {
        Optional<Ingrediente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Ingrediente> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Ingrediente create(IngredienteDTO objDTO) {
        objDTO.setId(null);
        Ingrediente newObj = new Ingrediente(objDTO);
        return repository.save(newObj);
    }

    @Transactional
    public Ingrediente update(Long id, IngredienteDTO objDTO) {
        objDTO.setId(id);
        Ingrediente oldObj = findById(id);
        oldObj = new Ingrediente(objDTO);
        return repository.save(oldObj);
    }

    @Transactional
    public void delete(Long id) {
        Ingrediente obj = findById(id);
        if (obj.getReceitas().size() > 0) {
            throw new DataIntegrityViolationException("Ingrediente sendo usado em receita e não pode ser deletado!");
        }
        repository.deleteById(id);
    }
}

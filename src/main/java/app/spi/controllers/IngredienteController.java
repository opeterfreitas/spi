package app.spi.controllers;

import app.spi.controllers.dtos.IngredienteDTO;
import app.spi.models.Ingrediente;
import app.spi.services.IngredienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    private final IngredienteService service;

    public IngredienteController(IngredienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredienteDTO> findById(@PathVariable Long id) {
        Ingrediente obj = service.findById(id);
        return ResponseEntity.ok().body(new IngredienteDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<IngredienteDTO>> findAll() {
        List<Ingrediente> list = service.findAll();
        List<IngredienteDTO> listDTO = list.stream().map(obj -> new IngredienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<IngredienteDTO> create(@Valid @RequestBody IngredienteDTO objDTO) {
        Ingrediente newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredienteDTO> update(@PathVariable Long id, @Valid @RequestBody IngredienteDTO objDTO) {
        Ingrediente newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new IngredienteDTO(newObj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<IngredienteDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
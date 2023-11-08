package app.spi.controllers;

import app.spi.controllers.dtos.DespesaDTO;
import app.spi.models.Despesa;
import app.spi.services.DespesaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/despesas")
public class DespesaController {

    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaDTO> findById(@PathVariable Long id) {
        Despesa obj = service.findById(id);
        return ResponseEntity.ok().body(new DespesaDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<DespesaDTO>> findAll() {
        List<Despesa> list = service.findAll();
        List<DespesaDTO> listDTO = list.stream().map(obj -> new DespesaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<DespesaDTO> create(@Valid @RequestBody DespesaDTO objDTO) {
        Despesa newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaDTO> update(@PathVariable Long id, @Valid @RequestBody DespesaDTO objDTO) {
        Despesa newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new DespesaDTO(newObj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DespesaDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

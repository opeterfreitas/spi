package app.spi.controllers;

import app.spi.controllers.dtos.EmbalagemDTO;
import app.spi.models.Embalagem;
import app.spi.services.EmbalagemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/embalagens")
public class EmbalagemController {

    private final EmbalagemService service;

    public EmbalagemController(EmbalagemService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmbalagemDTO> findById(@PathVariable Long id) {
        Embalagem obj = service.findById(id);
        return ResponseEntity.ok().body(new EmbalagemDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<EmbalagemDTO>> findAll() {
        List<Embalagem> list = service.findAll();
        List<EmbalagemDTO> listDTO = list.stream().map(obj -> new EmbalagemDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<EmbalagemDTO> create(@Valid @RequestBody EmbalagemDTO objDTO) {
        Embalagem newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmbalagemDTO> update(@PathVariable Long id, @Valid @RequestBody EmbalagemDTO objDTO) {
        Embalagem newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new EmbalagemDTO(newObj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmbalagemDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

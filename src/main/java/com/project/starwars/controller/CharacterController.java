package com.project.starwars.controller;

import com.project.starwars.model.Character;
import com.project.starwars.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@Tag(name = "Star Wars Characters", description = "CRUD de personagens de Star Wars")
public class CharacterController {

    @Autowired
    private CharacterService service;

    @GetMapping
    @Operation(summary = "Listar todos os personagens")
    public List<Character> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter personagem por ID")
    public ResponseEntity<Character> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar novo personagem")
    public Character create(@RequestBody Character character) {
        return service.save(character);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar personagem existente")
    public ResponseEntity<Character> update(@PathVariable Long id, @RequestBody Character character) {
        return service.findById(id)
                .map(existing -> {
                    character.setId(existing.getId());
                    return ResponseEntity.ok(service.save(character));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar personagem por ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

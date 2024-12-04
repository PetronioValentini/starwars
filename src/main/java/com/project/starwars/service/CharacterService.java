package com.project.starwars.service;

import com.project.starwars.model.Character;
import com.project.starwars.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository repository;

    public List<Character> findAll() {
        return repository.findAll();
    }

    public Optional<Character> findById(Long id) {
        return repository.findById(id);
    }

    public Character save(Character character) {
        return repository.save(character);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

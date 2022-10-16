package com.example.animalcare.repositories;

import com.example.animalcare.model.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParentRepositoryImp {

    private final ParentRepository parentRepository;

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }
}

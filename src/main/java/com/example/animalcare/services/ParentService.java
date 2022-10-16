package com.example.animalcare.services;

import com.example.animalcare.model.Parent;
import com.example.animalcare.model.Pet;
import com.example.animalcare.repositories.ParentRepositoryImp;
import com.example.animalcare.repositories.PetRepositoryImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepositoryImp parentRepositoryImp;
    private final PetRepositoryImp petRepositoryImp;

    public Parent createParent(Parent parent) {
        parent.getPets().forEach(pet -> pet.setParent(parent));
        return parentRepositoryImp.createParent(parent);
    }
}

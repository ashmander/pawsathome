package com.example.animalcare.services;

import com.example.animalcare.model.Pet;
import com.example.animalcare.repositories.PetRepositoryImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepositoryImp petRepositoryImp;

    public Pet getPetById(Long id) {
        return petRepositoryImp.findById(id);
    }
}

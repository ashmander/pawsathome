package com.example.animalcare.controllers;

import com.example.animalcare.dto.CallDto;
import com.example.animalcare.model.Parent;
import com.example.animalcare.services.ParentService;
import com.example.animalcare.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Handler {

    private final ParentService parentService;
    private final PetService petService;

    public Mono<ServerResponse> getPet(ServerRequest request) {
        return Mono.just(petService.getPetById(Long.parseLong(request.pathVariable("id"))))
                .flatMap(petGet -> ServerResponse.ok().bodyValue(petGet));
    }

    public Mono<ServerResponse> createParent(ServerRequest request) {
        return request.bodyToMono(Parent.class)
                .map(parentToCreate -> parentService.createParent(parentToCreate))
                .flatMap(parentCreated -> ServerResponse.ok().bodyValue(parentCreated));
    }

}

package com.example.animalcare.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private String birthday;
    private Double size;
    private String race;
    private String behaviors;
    private Boolean hasPendant;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnoreProperties("pets")
    private Parent parent;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_information_id")
    private MedicalInformation medicalInformation;
}

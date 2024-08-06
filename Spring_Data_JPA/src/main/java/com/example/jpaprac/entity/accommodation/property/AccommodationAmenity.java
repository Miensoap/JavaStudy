package com.example.jpaprac.entity.accommodation.property;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Embeddable
public class AccommodationAmenity {
    @Id
    private String name;
}

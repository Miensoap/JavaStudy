package com.example.jpaprac.entity.accommodation.property;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class AccommodationLocation {
    private String address;
    private Integer zipCode;
//    private Point point;
}

package com.example.jpaprac.entity;

import com.example.jpaprac.entity.user.property.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "USERS")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private String email;
    private String picture;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @NotNull
    private String registrationId;

    @OneToMany(mappedBy = "host")
    private List<AccommodationEntity> accommodations = new ArrayList<>();

    @OneToMany(mappedBy = "booker")
    private List<BookingEntity> bookings = new ArrayList<>();

    public UserEntity(String name, Role role, String registrationId) {
        this.name = name;
        this.role = role;
        this.registrationId = registrationId;
    }
}

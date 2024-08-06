package com.example.jpaprac.entity;

import com.example.jpaprac.entity.accommodation.property.AccommodationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACCOMMODATION")
public class AccommodationEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private UserEntity host;

    private AccommodationType type;

//    @Embedded
//    private RoomInformation roomInformation;
//
//    @Embedded
//    private AccommodationLocation address;

    // Description
    private String name;
    private String description;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "accommodation_id")
//    private List<Pictures> pictures;

    private Integer basePricePerDay;

    @OneToMany(mappedBy = "accommodation")
    private List<ProductEntity> products = new ArrayList<>();

    public void confirmHost(UserEntity user){
        this.host = user;
    }
}

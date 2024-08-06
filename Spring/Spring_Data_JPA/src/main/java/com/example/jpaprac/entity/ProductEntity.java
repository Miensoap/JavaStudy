package com.example.jpaprac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    AccommodationEntity accommodation;

    LocalDate date;
    Integer price;

    @ManyToOne
    BookingEntity booking;

    public static ProductEntity from(AccommodationEntity accommodation, LocalDate date, Integer price) {
        ProductEntity created = new ProductEntity(accommodation, date, price);
        accommodation.getProducts().add(created);
        return created;
    }

    private ProductEntity(AccommodationEntity accommodation, LocalDate date, Integer price) {
        this.accommodation = accommodation;
        this.date = date;
        this.price = price;
    }

    public void book(BookingEntity booking){
        this.booking = booking;
    }
}

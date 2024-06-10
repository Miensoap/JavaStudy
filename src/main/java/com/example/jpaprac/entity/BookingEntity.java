package com.example.jpaprac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "BOOKING")
@Entity
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserEntity booker;

    @OneToMany(mappedBy = "booking")
    private List<ProductEntity> bookingProducts = new ArrayList<>();


    public static BookingEntity book(UserEntity booker, List<ProductEntity> products) {
        BookingEntity booking = new BookingEntity(booker, products);
        booker.getBookings().add(booking);
        products.forEach(product->product.book(booking));

        return booking;
    }

    public BookingEntity(UserEntity booker, List<ProductEntity> bookingProducts) {
        this.booker = booker;
        this.bookingProducts = bookingProducts;
    }
}

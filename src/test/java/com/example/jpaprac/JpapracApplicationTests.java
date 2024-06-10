package com.example.jpaprac;

import com.example.jpaprac.entity.AccommodationEntity;
import com.example.jpaprac.entity.BookingEntity;
import com.example.jpaprac.entity.ProductEntity;
import com.example.jpaprac.entity.UserEntity;
import com.example.jpaprac.entity.user.property.Role;
import com.example.jpaprac.repository.AccommodationRepository;
import com.example.jpaprac.repository.BookingRepository;
import com.example.jpaprac.repository.ProductRepository;
import com.example.jpaprac.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JpapracApplicationTests {

    @Autowired
    AccommodationRepository accommodationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BookingRepository bookingRepository;

    @Test
    @Transactional
    void UserAndAccommodation() {
        UserEntity user = userRepository.save(new UserEntity("name", Role.HOST, "id"));
        AccommodationEntity accommodation = AccommodationEntity.builder()
                .name("test")
                .build();

        UserEntity proxyUser = userRepository.getReferenceById(1L);
        accommodation.confirmHost(proxyUser);
        AccommodationEntity saved = accommodationRepository.save(accommodation);
        System.out.println(saved.getHost().getName());
        System.out.println(proxyUser.getAccommodations());
    }

    @Test
    @Transactional
    void AccommodationAndProduct() {
        UserEntity user = userRepository.save(new UserEntity("name", Role.HOST, "id"));
        AccommodationEntity accommodation = AccommodationEntity.builder()
                .name("test")
                .products(new ArrayList<>())
                .build();
        accommodation.confirmHost(user);
        long id = accommodationRepository.save(accommodation).getId();


        AccommodationEntity proxyAccommodation = accommodationRepository.getReferenceById(id);
        ProductEntity newProduct = ProductEntity.from(proxyAccommodation, LocalDate.parse("2024-07-07"), 1000);
        ProductEntity saved = productRepository.save(newProduct);

        System.out.println(saved.getAccommodation().getName());
        System.out.println(saved.getAccommodation().getHost());
        System.out.println(saved.getDate());
        System.out.println(saved.getPrice());
    }

    @Test
    @Transactional
    void BookingAndProduct() {
        UserEntity user = userRepository.save(new UserEntity("name", Role.HOST, "id"));
        AccommodationEntity accommodation = AccommodationEntity.builder()
                .name("test")
                .products(new ArrayList<>())
                .build();
        accommodation.confirmHost(user);

        ProductEntity newProduct = ProductEntity.from(accommodation, LocalDate.parse("2024-07-07"), 1000);
        Long productId = productRepository.save(newProduct).getId();


        ProductEntity referenceById = productRepository.getReferenceById(productId);
        BookingEntity saved = bookingRepository.save(BookingEntity.book(user, List.of(referenceById)));

        System.out.println(saved.getBooker().getName());
        System.out.println(saved.getBookingProducts());

        // 동일성 보장
        System.out.println(referenceById.equals(newProduct));
        System.out.println(newProduct.getBooking().getBooker().getName());
    }
}

package com.example.jpaprac.repository;

import com.example.jpaprac.entity.AccommodationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<AccommodationEntity, Long> {

}

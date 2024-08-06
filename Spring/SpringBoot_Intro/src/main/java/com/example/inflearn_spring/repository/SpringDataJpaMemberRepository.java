package com.example.inflearn_spring.repository;

import com.example.inflearn_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    /**
     * 인터페이스를 통한 기본적인 CRUD
     * indByName 등 .. 메서드 이름만으로 조회 기능 제공
     * 페이징 기능 자동 제공
     */

    @Override
    Optional<Member> findByName(String name);
    // JPQL select m form Member m where m.name = ?
}

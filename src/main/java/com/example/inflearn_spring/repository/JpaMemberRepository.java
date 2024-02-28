package com.example.inflearn_spring.repository;

import com.example.inflearn_spring.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // jpql
        return em.createQuery("select m from Member m where  m.name = :name", Member.class)
                .setParameter("name",name)
                .getResultList()
                .stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체로 쿼리 가능
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}

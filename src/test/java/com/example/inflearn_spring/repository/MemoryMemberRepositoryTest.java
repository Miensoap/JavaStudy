package com.example.inflearn_spring.repository;

import com.example.inflearn_spring.domain.Member;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    static MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void setUp(){
        repository.clearRepository();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        Member result = repository.findByName("member2").get();
        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}

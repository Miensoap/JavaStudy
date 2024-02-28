package com.example.inflearn_spring;

import com.example.inflearn_spring.aop.TimeTraceAop;
import com.example.inflearn_spring.repository.*;
import com.example.inflearn_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /**
     * Controller , Service , Repository 등의 정형화된 코드는 컴포넌트 스캔 (어노태이션) 사용
     * 정형화되지 않거나, 상황에 따라 구현을 변경해야 하면 config 를 통해 빈으로 등록
     * Autowired 어노태이션은 스프링이 관리하는 클래스에만 작동
     */

    private final MemberRepository memberRepository;


    // 생성자가 1개일 경우 생략가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}

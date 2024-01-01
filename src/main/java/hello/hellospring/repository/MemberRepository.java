package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

// repository => 저장소

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

// Optional => null을 그대로 반환하는 대신 Optional로 반환, Java8에 들어간 개념


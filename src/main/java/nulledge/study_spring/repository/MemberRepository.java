package nulledge.study_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nulledge.study_spring.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}

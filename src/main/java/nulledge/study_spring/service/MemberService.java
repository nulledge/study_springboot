package nulledge.study_spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nulledge.study_spring.entity.Member;
import nulledge.study_spring.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
public class MemberService {
	
	@Autowired
	MemberRepository repository;

	@Transactional(readOnly = false)
	public Optional<Member> register(Member member) {
		if (repository.findById(member.getId()).isPresent())
			return Optional.empty();

		return Optional.of(repository.save(member));
	}

	public Optional<Member> findById(String id){
		return repository.findById(id);
	}

	public Boolean checkDuplicated(String id) {
		return repository.findById(id).isPresent();
	}
}

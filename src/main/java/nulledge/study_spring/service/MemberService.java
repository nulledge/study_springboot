package nulledge.study_spring.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nulledge.study_spring.entity.Member;
import nulledge.study_spring.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
public class MemberService {
	
	final MemberRepository repository;
	final PasswordEncoder passwordEncoder;

	public MemberService(MemberRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}


	@Transactional(readOnly = false)
	public Optional<Member> register(Member member) {
		if (repository.findById(member.getId()).isPresent())
			return Optional.empty();

		String plainPassword = member.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
		member.setPassword(encodedPassword);

		return Optional.of(repository.save(member));
	}

	public Optional<Member> findById(String id){
		return repository.findById(id);
	}

	public Boolean checkDuplicated(String id) {
		return repository.findById(id).isPresent();
	}
}

package nulledge.study_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nulledge.study_spring.entity.Member;
import nulledge.study_spring.repo.MemberRepository;

@Service
@Transactional(readOnly = true)
public class MemberService {
	
	@Autowired
	MemberRepository repository;

	@Transactional(readOnly = false)
	public Long create(Member member) {
		return repository.save(member);
	}

	public Member read(Long id) {
		return repository.find(id);
	}

	@Transactional(readOnly = false)
	public Member update(Long id, Member member) {
		Member target = this.read(id);
		target.setName(member.getName());
		target.setPassword(member.getPassword());
		return target;
	}

	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		return repository.delete(id);
	}
}

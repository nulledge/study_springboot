package nulledge.study_spring.repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nulledge.study_spring.entity.Member;

@Repository
public class MemberRepository {

	@Autowired
	EntityManager manager;

	public Long save(Member member) {
		manager.persist(member);
		return member.getId();
	}

	public Member find(Long id) {
		return manager.find(Member.class, id);
	}

	public boolean delete(Long id) {
		Member member = this.find(id);
		try {
			manager.remove(member);
			manager.flush();
			manager.clear();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
}

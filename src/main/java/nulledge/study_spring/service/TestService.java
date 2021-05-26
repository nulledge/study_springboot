package nulledge.study_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nulledge.study_spring.entity.TestEntity;
import nulledge.study_spring.repo.TestRepository;

@Service
@Transactional(readOnly = true)
public class TestService {
	
	@Autowired
	TestRepository repository;

	@Transactional(readOnly = false)
	public Long create(TestEntity entity) {
		return repository.save(entity);
	}

	public TestEntity read(Long id) {
		return repository.find(id);
	}

	@Transactional(readOnly = false)
	public TestEntity update(Long id, TestEntity entity) {
		TestEntity target = this.read(id);
		target.setName(entity.getName());
		return target;
	}

	@Transactional(readOnly = false)
	public boolean delete(Long id) {
		return repository.delete(id);
	}

}

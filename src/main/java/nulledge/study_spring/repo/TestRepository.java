package nulledge.study_spring.repo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import nulledge.study_spring.entity.TestEntity;

@Repository
public class TestRepository {

	@Autowired
	EntityManager manager;

	public Long save(TestEntity entity) {
		manager.persist(entity);
		return entity.getId();
	}

	public TestEntity find(Long id) {
		return manager.find(TestEntity.class, id);
	}

	public boolean delete(Long id) {
		TestEntity entity = this.find(id);
		try {
			manager.remove(entity);
			manager.flush();
			manager.clear();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}

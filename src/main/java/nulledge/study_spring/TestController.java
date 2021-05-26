package nulledge.study_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nulledge.study_spring.entity.TestEntity;
import nulledge.study_spring.service.TestService;

@RestController
public class TestController {

	@Autowired
	TestService service;
	
	@GetMapping("/")
	String getHello() {
		return "Hello World!";
	}

	@PostMapping("/test")
	Long create(@RequestBody TestEntity entity) {
		return service.create(entity);
	}

	@GetMapping("/test/{id}")
	TestEntity read(@PathVariable Long id) {
		return service.read(id);
	}

	@PutMapping("/test/{id}")
	TestEntity update(@RequestBody TestEntity entity, @PathVariable Long id) {
		return service.update(id, entity);
	}

	@DeleteMapping("/test/{id}")
	boolean delete(@PathVariable Long id) {
		return service.delete(id);
	}
}

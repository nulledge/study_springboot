package nulledge.study_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nulledge.study_spring.entity.Member;
import nulledge.study_spring.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;

	@PostMapping("/member")
	Long create(@RequestBody Member member) {
		return service.create(member);
	}

	@GetMapping("/member/{id}")
	Member read(@PathVariable Long id) {
		return service.read(id);
	}

	@PutMapping("/member/{id}")
	Member update(@RequestBody Member member, @PathVariable Long id) {
		return service.update(id, member);
	}

	@DeleteMapping("/member/{id}")
	boolean delete(@PathVariable Long id) {
		return service.delete(id);
	}
}

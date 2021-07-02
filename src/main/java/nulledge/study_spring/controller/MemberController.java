package nulledge.study_spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nulledge.study_spring.entity.Member;
import nulledge.study_spring.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;

	// curl -X POST localhost:8080/member -H 'Content-type:application/json' -d '{"id" : "ID", "name" : "NAME", "password" : "PASSWORD"}'
	@PostMapping("/member")
	Optional<Member> register(@RequestBody Member member) {
		return service.register(member);
	}

	@GetMapping("/member/duplicated/{id}")
	Boolean checkDuplicated(@PathVariable String id) {
		return service.checkDuplicated(id);
	}

	// curl -X GET localhost:8080/member/ID
	@GetMapping("/member/{id}")
	Optional<Member> get(@PathVariable String id) {
		return service.findById(id);
	}
}

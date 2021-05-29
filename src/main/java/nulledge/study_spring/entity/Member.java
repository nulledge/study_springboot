package nulledge.study_spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	@Id
	private String id;

	@Column(nullable = false)
	private String password;

	private String name;
}

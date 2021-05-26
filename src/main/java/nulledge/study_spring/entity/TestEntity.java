package nulledge.study_spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TestEntity {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	@Override
	public String toString() {
		return String.format("Test(id=%d, name=%s)", id, name);
	}
}

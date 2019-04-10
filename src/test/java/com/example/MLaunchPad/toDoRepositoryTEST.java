package com.example.MLaunchPad;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MLaunchPad.domain.Type;
import com.example.MLaunchPad.domain.toDo;
import com.example.MLaunchPad.domain.toDoRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class toDoRepositoryTEST {

	@Autowired
	private toDoRepository todoRepo;
	
	@Test
	public void findByLocationShouldReturntoDo() {
		List<toDo> toDos = todoRepo.findByLocation("Pasila");
		
		assertThat(toDos).hasSize(1);
		assertThat(toDos.get(0).getLocation()).isEqualTo("Pasila");
	}
	
	@Test
	public void createNewtoDo() {
		toDo todo = new toDo(0, "Some nice info", "20.05 14:20-15:00", "Office", new Type("TestType"));
		todoRepo.save(todo);
		assertThat(todo.getId()).isNotNull();
	}
	
}

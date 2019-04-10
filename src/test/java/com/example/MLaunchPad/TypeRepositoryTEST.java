package com.example.MLaunchPad;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MLaunchPad.domain.Type;
import com.example.MLaunchPad.domain.TypeRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TypeRepositoryTEST {
	
	@Autowired
	private TypeRepository TypeRepo;
	
	@Test
	public void findByTypeNameShouldReturnType() {
		List<Type> types = TypeRepo.findBytypeName("Work");
		
		assertThat(types).hasSize(1);
		assertThat(types.get(0).getTypeName()).isEqualTo("Work");
	}
	
	@Test
	public void createNewType() {
		Type type = new Type("Test");
		TypeRepo.save(type);
		
		assertThat(type.getTypeID()).isNotNull();
	}

}

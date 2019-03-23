package com.example.MLaunchPad.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface toDoRepository extends CrudRepository<toDo, Long>{
	
	List<toDo> findByLocation(String location);
	
	List<toDo> findByTime(String time);

}

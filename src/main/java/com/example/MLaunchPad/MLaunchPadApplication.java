package com.example.MLaunchPad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.MLaunchPad.domain.toDo;
import com.example.MLaunchPad.domain.Type;
import com.example.MLaunchPad.domain.TypeRepository;
import com.example.MLaunchPad.domain.toDoRepository;

@SpringBootApplication
public class MLaunchPadApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MLaunchPadApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MLaunchPadApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner hardCoded(toDoRepository toDoRepo, TypeRepository TypeRepo) {
		return (args)-> {
			
			log.info("SAVING TYPES");
			TypeRepo.save(new Type("  "));
			TypeRepo.save(new Type("Exam"));
			TypeRepo.save(new Type("FreeTime"));
			TypeRepo.save(new Type("Gym"));
			TypeRepo.save(new Type("Study"));
			TypeRepo.save(new Type("Sports"));
			TypeRepo.save(new Type("Work"));
			
			log.info("SAVING EXAMPLE TODOS");
			toDoRepo.save(new toDo(0, "Math exam", "12:00-13:00", "Pasila", TypeRepo.findBytypeName("Exam").get(0)));
			toDoRepo.save(new toDo(0, "Gym with Max", "16:00-17:30", "FitnessWorld Helsinki", TypeRepo.findBytypeName("Gym").get(0)));
			
			log.info("FETCH ALL SAVED DATA");
			for(toDo todo : toDoRepo.findAll()) {
				log.info(todo.toString());
			}
		};
	}

}

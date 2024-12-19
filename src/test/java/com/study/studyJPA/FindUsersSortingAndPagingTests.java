package com.study.studyJPA;

import com.study.studyJPA.model.User;
import com.study.studyJPA.repositories.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class StudyJpaApplicationTests {

	@Autowired
	UserRepository userRepository;

	@BeforeAll
	void beforeAll() {
		userRepository.saveAll(generateUser());
	}

	private static List<User> generateUser(){
		List<User> users = new ArrayList<>();

		User john = new User("john", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("John@somedomin.com");
		john.setLevel(1);

		john.setActive(true);

		users.add(john);

		return users;
	}

	@AfterAll
	void afterAll(){
		userRepository.deleteAll();
	}
}

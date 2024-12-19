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
		System.out.println("BeforeAll 실행 시작");
		userRepository.saveAll(generateUser());
	}

	private static List<User> generateUser(){
		List<User> users = new ArrayList<>();

		User john = new User("john", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("John@somedomin.com");
		john.setLevel(1);

		john.setActive(true);

		users.add(john);

		User xh = new User("xh", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("xh@somedomin.com");
		john.setLevel(1);

		john.setActive(true);

		users.add(xh);

		User three = new User("three", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("three@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(three);


		User four = new User("four", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("four@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(four);


		User five = new User("five", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("five@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(five);


		User six = new User("six", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("six@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(six);


		User seven = new User("seven", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("seven@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(seven);


		User eight = new User("eight", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("eight@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(eight);


		User nine = new User("nine", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("nine@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(nine);


		User ten = new User("ten", LocalDate.of(2020, Month.APRIL, 13));
		john.setEmail("ten@somedomin.com");
		john.setLevel(2);

		john.setActive(true);

		users.add(ten);



		return users;
	}

	@AfterAll
	void afterAll(){
		userRepository.deleteAll();
	}
}

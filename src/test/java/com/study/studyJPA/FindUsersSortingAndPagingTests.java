package com.study.studyJPA;

import com.study.studyJPA.model.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class FindUsersSortingAndPagingTests extends StudyJpaApplicationTests {

	@Test
	void testFindAll(){
		User user1 = userRepository.findFirstByOrderByUsernameAsc();
		System.out.println("##: " + userRepository.findAll());
		User user2 = userRepository.findTopByOrderByUsernameAsc();
		Page<User> userPage = userRepository.findAll(PageRequest.of(1,3));
		List<User> users = userRepository.findFirst2ByLevel(2, Sort.by("registrationDate"));

		assertAll(
				()-> assertEquals("beth", user1.getUsername()),
				()-> assertEquals("julius", user2.getUsername()),
				()-> assertEquals(2, users.size()),
				()-> assertEquals(3, userPage.getSize()),
				()-> assertEquals("beth", users.get(0).getUsername()),
				()-> assertEquals("marion", users.get(1).getUsername())
		);
	}

	@Test
	void testFindByLevel(){
		Sort.TypedSort<User> user = Sort.sort(User.class);

		List<User> users = userRepository.findByLevel(3,
				user.by(User::getRegistrationDate).descending());
		assertAll(
				() -> assertEquals(2, users.size()),
				() -> assertEquals("james", users.get(0).getUsername())
		);
	}

	@Test
	void testFindByActive(){
		List<User> users = userRepository.findByActive(true,
				PageRequest.of(1, 2, Sort.by("registrationDate")));
		System.out.println("##: "+ users.toString());
				assertAll(
				() -> assertEquals(4, users.size()),
				() -> assertEquals("burk", users.get(0).getUsername())
		);
	}

}

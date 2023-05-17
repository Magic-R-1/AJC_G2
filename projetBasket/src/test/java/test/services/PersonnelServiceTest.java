package test.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Personnel;
import repositories.PersonnelRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class PersonnelServiceTest {

		@Autowired
		PersonnelRepository personnelRepo;
		
		@Test
		void test() {
			
		}

}

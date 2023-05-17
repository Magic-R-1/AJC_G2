package test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import entities.Personnel;
import repositories.PersonnelRepository;

@SpringJUnitConfig(configurations.JpaConfig.class)
class PersonnelTest {

		@Autowired
		PersonnelRepository personnelRepo;
		
		@Test
		void test() {
			
			Personnel Personnel= new Personnel("Kodjo", "koffi", 1000, null, null);
			personnelRepo.save(Personnel);
			
		}

}

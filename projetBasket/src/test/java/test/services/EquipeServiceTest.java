package test.services;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import configurations.JpaConfig;
import entities.Equipe;
import services.EquipeService;


@SpringJUnitConfig(JpaConfig.class)
@Transactional
@Rollback
public class EquipeServiceTest {

	@Autowired
	private EquipeService equipeSrv;
	

@Test
@Disabled
void insertTest() {
	equipeSrv.create(new Equipe("Poule", null, null, null, null, null, null));
}
}
package in.nareshit.raghu;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import in.nareshit.raghu.entity.Specialization;
import in.nareshit.raghu.repo.SpecializationRepository;


@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
//@TestMethodOrder(OrderAnnotation.class)
public class SpecializationRepositoryTest {
	
	@Autowired
	private SpecializationRepository repo;
	
	/***
	 * 1.Test Save Operation
	 */
	//@Disabled
	@Test
	@Order(1)
	public void testSpecCreate() {
		Specialization spec= new Specialization(null,"CRDLS","Cardiologists","Cardiology specialists focus on care of the heart and cardiovascular system.");
		repo.save(spec);
		assertNotNull(spec.getId(),"Spec is not Cretaed");
	}
	
	/***
	 * Test dispaly all operation
	 */
	@Test
	@Order(2)
	public void testSpecFetchAll() {
		List<Specialization> list= repo.findAll();
		assertNotNull(list);
		if(list.isEmpty()) {
			fail("No data exis in Database");
		}
	}
	
	
}

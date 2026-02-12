package person_hibernate1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.prac.person;
import com.prac.persondao;

public class persondoatest {

	static EntityManagerFactory emf;
	static EntityManager em;
	
	@BeforeAll
	public  void intiEmf() {
		emf = Persistence.createEntityManagerFactory("postgres");
	}
	
	@BeforeEach
	public  void initEm() {
		em = emf.createEntityManager();
	}
	@Test
	public void insertdata() {
		persondao dao = new persondao();
		
		person p = new person();
		
		p.setId(45);
		p.setName("Rohit");
		p.setDOB("1999");
		p.setAddress("lalchuak");
		p.setPincode(144422);
		
		dao.insertdata(p);
		
		person p1 = dao.findById(45);
		assertNotNull(p1);
		
		assertEquals("Rohit" , p1.getName());
		
		
		
 }
	
	@Test
	public void deletedata() {
		persondao dao= new persondao();
		
		assertTrue(dao.deletedata(45));
	}
	
	@Test
	public void deletedatano() {
		persondao dao= new persondao();
		assertFalse(dao.deletedata(19));
	}
	
	
	@AfterEach
	public void destoryEm() {
		em.close();
	}
	
	@AfterAll
	public void destoryEmf() {
		emf.close();
	}

}

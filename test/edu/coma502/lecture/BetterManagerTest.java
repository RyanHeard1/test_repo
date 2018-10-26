package edu.coma502.lecture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class BetterManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateManager() {
		Employee john = new Employee("John", 
				"Coffie", 
				20161107, 
				10000.00, 
				"IT", 
				true, 
				3);
		Employee[] team = {john};
		BetterManager annette = new BetterManager("Annette", "Smith", 20160101, 50000, "IT", false, 0, team);
		assertNotNull(annette);
		assertEquals("Annette Smith", annette.getFullName());
	}
	
	@Test
	public void testGoodTeamAverageManager() {
		Employee john = new Employee("John", "Doe", 20180101, 25000, "HR", false, 0);
		Employee jane = new Employee("Jane", "Doe", 20180101, 35000, "HR", false, 0);
		Employee[] team = {jane, john};
		BetterManager george = new BetterManager("George", "Smith", 20170801, 55000, "HR", false, 0, team);
		
		john.performance(10);
		jane.performance(10);
		george.performance(4);
		
		assertEquals("Good", george.review());
		
	}

	@Test
	public void testAverageTeamGoodManager() {
		Employee john = new Employee("John", "Doe", 20180101, 25000, "HR", false, 0);
		Employee jane = new Employee("Jane", "Doe", 20180101, 35000, "HR", false, 0);
		Employee[] team = {jane, john};
		BetterManager george = new BetterManager("George", "Smith", 20170801, 55000, "HR", false, 0, team);
		
		john.performance(5);
		jane.performance(5);
		george.performance(8);
		
		assertEquals("Average", george.review());
	}
	
	@Test
	public void testSizeOfTeam() {
		Employee john = new Employee("John", "Doe", 20180101, 25000, "HR", false, 0);
		Employee jane = new Employee("Jane", "Doe", 20180101, 35000, "HR", false, 0);
		Employee[] team = {jane, john};
		BetterManager george = new BetterManager("George", "Smith", 20170801, 55000, "HR", false, 0, team);
		assertEquals(3, george.getSizeOfTeam());
	}
}

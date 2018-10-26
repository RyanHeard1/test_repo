package edu.coma502.lecture;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	
	private Employee john;
	
	@Before
	public void setUp() throws Exception {
		john = new Employee("John", 
						"Coffie", 
						20161107, 
						10000.00, 
						"IT", 
						true, 
						3);
	}

	@After
	public void tearDown() throws Exception {
		john.terminate();
	}

	@Test
	public void testEmployeeConstructor() {
		assertNotNull(john);
		john.terminate();
	}
	
	@Test
	public void testGetFullName() {
		String expectedResult = "John Coffie";
		String actualResult = john.getFullName();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testChangeMaritalStatus() {
		boolean originalStatus = true;
		boolean expectedStatus = false;
		assertEquals(originalStatus, john.getMaritalStatus());
		john.setMaritalStatus(expectedStatus);
		assertEquals(expectedStatus, john.getMaritalStatus());
	}
	
	@Test
	public void testSetNumberOfChildren() {
		int originalNumberOfChildren = 3;
		int expectedNumberOfChildren = 4;
		assertEquals(originalNumberOfChildren, john.getNumberOfChildren());
		john.setNumberOfChildren(expectedNumberOfChildren);
		assertEquals(expectedNumberOfChildren, john.getNumberOfChildren());
	}
	
	@Test
	public void testAddPaidTimeOff() {
		assertEquals(0, john.getPaidTimeOff());
		john.addPaidTimeOff(5);
		assertEquals(5, john.getPaidTimeOff());
		john.addPaidTimeOff(5);
		assertEquals(10, john.getPaidTimeOff());
	}
	
	@Test
	public void testGetYearsOfServiceAsOf20181012() {
		int asOf = 20181012;
		int expectedYearsOfService = 1;
		int actualYearsOfService = john.getYearsOfServiceAsOf(asOf);
		assertEquals(expectedYearsOfService, actualYearsOfService);
	}
	
	@Test
	public void testGetYearsOfServiceAsOf20181101() {
		int asOf = 20181101;
		int expectedYearsOfService = 1;
		int actualYearsOfService = john.getYearsOfServiceAsOf(asOf);
		assertEquals(expectedYearsOfService, actualYearsOfService);
	}

	@Test
	public void testScheduleTimeOff() {
		assertEquals(0, john.getPaidTimeOff());
		john.addPaidTimeOff(5);
		boolean actualResult = john.scheduleTimeOff(4);
		assertEquals(true, actualResult);
		assertEquals(1, john.getPaidTimeOff());
	}
	
	@Test
	public void testNumberOfEmployees() {
		assertEquals(1, Employee.numberOfEmployees);
	}
}

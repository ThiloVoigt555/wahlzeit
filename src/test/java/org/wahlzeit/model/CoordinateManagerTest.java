package org.wahlzeit.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoordinateManagerTest {
	CoordinateManager manager = CoordinateManager.getInstance();
	Coordinate A;
	Coordinate B;
	
	@Test
	public void testCartesianCoordinateCreation() {
		A = manager.getCoordinate(1, 2, 42);
		B = manager.getCoordinate(1, 2, 42);
		
		assertTrue(A == B);
	}
	
	@Test
	public void testSphericCoordinateCreation() {
		A = manager.getCoordinate(33.5, 76);
		B = manager.getCoordinate(44.3, 44.3);
		
		assertTrue(A == B);
	}
}

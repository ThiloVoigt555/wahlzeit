package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CartesianCoordinateTest {
	private final double DELTA = 0.001; // used to ignore minor differences in double value comparison

	@Test
	public void testConversionMethod() {
		SphericCoordinate pointA = new SphericCoordinate(12.2, 15.7);
		SphericCoordinate pointB = new SphericCoordinate(9.9, 64.3);
		double expected = pointA.getDistance(pointB);
		
		// this should be the same points A and B in the different systems
		CartesianCoordinate pointACartesian = new CartesianCoordinate(12.2, 313.1, 44);
		CartesianCoordinate pointBCartesian = new CartesianCoordinate(14.2, 92, 83.4);
		double actual = pointACartesian.getDistance(pointBCartesian);
		
		assertEquals(expected, actual, DELTA);
	}
	
	@Test
	public void testIsEqual() {
		CartesianCoordinate pointACartesian = new CartesianCoordinate(14.2, 92, 83.4);
		CartesianCoordinate pointBCartesian = new CartesianCoordinate(14.2, 92, 83.4);		
		CartesianCoordinate pointCCartesian = new CartesianCoordinate(14.2, 92.1, 83.4);		

		assertEquals(pointACartesian, pointBCartesian);
		assertEquals(pointACartesian.isEqual(pointBCartesian), true);
		assertEquals(pointACartesian.getDistance(pointBCartesian), 0, DELTA);
		assertEquals(pointACartesian.isEqual(pointCCartesian), false);
	}
	
	@Test
	public void testZeroConversionMethod() {
		SphericCoordinate pointA = new SphericCoordinate(0, 0);
		SphericCoordinate pointB = new SphericCoordinate(0, 0);
		double expected = pointA.getDistance(pointB);
		
		// this should be the same points A and B in the different systems
		CartesianCoordinate pointACartesian = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate pointBCartesian = new CartesianCoordinate(0, 0, 0);
		double actual = pointACartesian.getDistance(pointBCartesian);
		
		assertEquals(expected, actual, DELTA);
	}
}

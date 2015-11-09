package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test of SphericCoordinate and conversion methods in CartesianCoordinate
 */
public class SphericCoordinateTest {
	private SphericCoordinate expected;
	private SphericCoordinate actual;
	private final double LONGITUDE = 25.4;
	private final double LATITUDE = 53.1;
	private final double DELTA = 0.001; // used to ignore minor differences in double value comparison
	
	@Before
	public void setUp() throws Exception {
		this.expected = new SphericCoordinate(LATITUDE, LONGITUDE);
	}

	@Test
	public void testConstrictor() throws Exception {
		SphericCoordinate actual = new SphericCoordinate(LATITUDE, LONGITUDE);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsEuals() {
		this.actual = new SphericCoordinate(LATITUDE, LONGITUDE);
		
		assertEquals(expected.getLatitude(), actual.getLatitude(), DELTA);
		assertEquals(expected.getLongitude(), actual.getLongitude(), DELTA);
		assertEquals(expected.isEqual(actual), true);
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		this.expected.getDistance(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLatitude() {
		this.actual = new SphericCoordinate(91, LONGITUDE);
		this.actual = new SphericCoordinate(-91, LONGITUDE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLongitude() {
		this.actual = new SphericCoordinate(LATITUDE, 181);
		this.actual = new SphericCoordinate(LATITUDE, -181);
	}

	@Test
	public void testGetDistance() {
		this.actual = new SphericCoordinate(53.2, 134.3);
		double distance = 22; // expected distance
		
		assertEquals(this.expected.getDistance(actual), distance, DELTA);
	}
}

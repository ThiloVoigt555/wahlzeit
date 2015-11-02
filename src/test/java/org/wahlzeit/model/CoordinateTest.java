package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	private Coordinate expected;
	private final double LONGITUDE = 25.4;
	private final double LATITUDE = 53.1;
	private final double DELTA = 0.001; // used to ignore minor differences in double value comparison
	
	@Before
	public void setUp() throws Exception {
		this.expected = new Coordinate(LATITUDE, LONGITUDE);
	}

	@Test
	public void testConstrictor() throws Exception {
		Coordinate actual = new Coordinate(LATITUDE, LONGITUDE);
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testException() {
		this.expected.getDistance(null);
	}
	
	@Test
	public void testDoubleValueGetter() {
		
	}

	@Test
	public void testGetDistance() {
		
	}
}

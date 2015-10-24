package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	private Coordinate location;
	private final double LONGITUDE = 25.4;
	private final double LATITUDE = 53.1;
	private final double DELTA = 0.001; // used to ignore minor differences in double value comparison
	
	@Before
	public void setUp() throws Exception {
		this.location = new Coordinate(LATITUDE, LONGITUDE);
	}

	@Test
	public void testDoubleValueGetter() {
		assertEquals(this.LONGITUDE, this.location.getLongitudinalDisance(), DELTA);
		assertEquals(this.LATITUDE, this.location.getLatitudinalDistance(), DELTA);
	}

	@Test
	public void testGetDistance() {
		assertEquals(new Coordinate(LATITUDE, LONGITUDE), this.location.getDistance());
	}
}

package org.wahlzeit.model;

public interface Coordinate {
	
	/**
	 * Calculates the distance between this and there.
	 * @param A second coordinate
	 * @return The distance to the second coordinate
	 */
	public double getDistance(Coordinate there);
	
	/**
	 * Checks, if the given coordinate represents the same place as this.
	 * @param there
	 * @return True, if they represent the same place
	 */
	public boolean isEqual(Coordinate there);
	
	/**
	 * Return an universal representation of a Coordinate.
	 * @return Spheric representation of the Coordinate
	 */
	public SphericCoordinate asSphericCoordinate();
}

package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * Represents coordinates of a point in Space.
 */
@Subclass
public class CartesianCoordinate extends AbstractCoordinate {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7326971247858929780L;
	
	private double x;
	private double y;
	private double z;
	
	/**
	 * Creates a CartesianCoordinate with given x, y and z values.
	 * @param x must be greater than zero.
	 * @param y must be greater than zero.
	 * @param z must be greater than zero.
	 * @throws IllegalArgumentException when x, y or z are smaller than zero.
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		super();
		this.assertPrecondition(x, y, z);
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}
	
	/** 
	 * Retruns a spheric representation of the {@link CartesianCoordinate}
	 * @return A {@link SphericCoordinate} representation.
	 * @see Quelle Die Umrechnung: https://de.wikipedia.org/wiki/Kugelkoordinaten#Umrechnungen
	 * @throws IllegalStateException when the state of the {@link CartesianCoordinate} is illegal.
	 * @methodtype conversion
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double latitude = Math.acos(z / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)));
		this.assertInvariant();
		
		double longitude = 0;
		if (x > 0) {
			longitude = Math.atan(y / x);			
		} else if (x == 0) {
			if (y >= 0) {
				longitude = Math.PI / 2;
			} else {
				longitude = - Math.PI / 2;
			}
		} else if (x < 0 && y >= 0) {
			longitude = Math.atan(y / x) + Math.PI;
		} else if (x < 0 && y < 0) {
			longitude = Math.atan(y / x) - Math.PI;
		}
		this.assertInvariant();

		return new SphericCoordinate(latitude, longitude);
	}
	
	/**
	 * Asserts, that the given position is a valid one.
	 * @param x must be greater than zero.
	 * @param y must be greater than zero.
	 * @param z must be greater than zero.
	 * @throws IllegalArgumentException when x, y or z are smaller than zero. 
	 * @methodtype assert
	 */
	private void assertPrecondition(double x, double y, double z) {
		if (x < 0)
			throw new IllegalArgumentException("X must be between grater that zero.");
		
		if (y < 0) 
			throw new IllegalArgumentException("Y must be between grater that zero.");
		
		if (z < 0) 
			throw new IllegalArgumentException("Z must be between grater that zero.");
	}
	
	/**
	 * Asserts, that the class is in a valid state.
	 * @throws IllegalStateException when one of the internal fields is outside of the valid range.
	 * @methodtype assert
	 */
	private void assertInvariant() {
		if (this.getX() < 0)
			throw new IllegalStateException("X must be between grater that zero.");
		
		if (this.getY() < 0) 
			throw new IllegalStateException("Y must be between grater that zero.");
		
		if (this.getZ() < 0) 
			throw new IllegalStateException("Z must be between grater that zero.");
	}
	
	/**
	 * @methodtype get
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/**
	 * @methodtype boolean comparison
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CartesianCoordinate))
			return false;
		CartesianCoordinate other = (CartesianCoordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	/**
	 * @methodtype conversion
	 */
	@Override
	public String toString() {
		return "CartesianCoordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
}

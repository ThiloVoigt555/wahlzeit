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
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		super();
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
	 * Quelle der Umrechnung: https://de.wikipedia.org/wiki/Kugelkoordinaten#Umrechnungen
	 * @methodtype conversion
	 */
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double latitude = Math.acos(z / Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)));
		
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

		return new SphericCoordinate(latitude, longitude);
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

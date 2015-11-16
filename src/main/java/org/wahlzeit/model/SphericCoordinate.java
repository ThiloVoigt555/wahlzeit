package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

/**
 * Represents coordinates of a point on earth.
 */
@Subclass
public class SphericCoordinate extends AbstractCoordinate {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5236099320619043584L;
	
	private double latitude;
	private double longitude;
	private double radius = 6371; // earth radius
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude) {
		if(isValidLatitude(latitude) && isValidLongitude(longitude)) {
			this.latitude = latitude;
			this.longitude = longitude;			
		} else {
			throw new IllegalArgumentException(
					"Latitude be between -90 and 90 and Lonitude between -180 and 180.");			
		}
	}
	
	/**
	 * @methodtype get
	 */
	public double getLatitude() {
		return this.latitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * @methodtype converter
	 */
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	/**
	 * @methodtype comparison
	 */
	@SuppressWarnings("unused")
	private double getDistance(SphericCoordinate there) {
		if(there == null)
			throw new IllegalArgumentException("Input was Null!");
		
		if (this.equals(there)) {
			return 0;
		} else {			
			return calculateDistance(there);
		}
	}
	
	/**
	 * @methodtype helper
	 */
	private double calculateDistance(SphericCoordinate there) {
		double squaredLatitude = Math.pow(this.getLatitudinalDistance(there), 2);
		double squaredLongitude = Math.pow(this.getLongitudinalDisance(there), 2);
		return Math.sqrt(squaredLatitude + squaredLongitude);
	}
	
	/**
	 * @methodtype comparison
	 */
	private double getLatitudinalDistance(SphericCoordinate there) {
		if(there == null)
			throw new IllegalArgumentException("Input was Null!");
		
		return Math.abs(this.latitude - there.getLatitude());
	}
	
	/**
	 * @methodtype comparison
	 */
	private double getLongitudinalDisance(SphericCoordinate there) {
		if(there == null)
			throw new IllegalArgumentException("Input was Null!");
		
		return Math.abs(this.longitude - there.getLongitude());
	}
	
	/**
	 * @methodtype boolean query
	 */
	private boolean isValidLatitude(double degree) {
		if(Double.isNaN(degree) || degree > 90 || degree < -90) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @methodtype boolean query
	 */
	private boolean isValidLongitude(double degree) {
		if(Double.isNaN(degree) || degree > 180 || degree < -180) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @methodtype get
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
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
		if (!(obj instanceof SphericCoordinate))
			return false;
		
		SphericCoordinate other = (SphericCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	/**
	 * @methodtype conversion
	 */
	@Override
	public String toString() {
		return "Coordinate [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
}

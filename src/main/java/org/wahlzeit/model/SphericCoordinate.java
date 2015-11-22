package org.wahlzeit.model;

import java.awt.IllegalComponentStateException;

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
	 * Creates a SphericCoordinate with given Latitude and Longitude.
	 * @param Latitude has to be between -90 and 90
	 * @param Longitude has to be between -180 and 180
	 * @throws IllegalArgumentException when parameters are not in the specified range.
	 * @methodtype constructor
	 */
	public SphericCoordinate(double latitude, double longitude) {
		super();
		this.assertPrecondition(latitude, longitude);
		
		this.latitude = latitude;
		this.longitude = longitude;		
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
	 * Calculates the distance to another {@link SphericCoordinate} point.
	 * @param there is a second point in a {@link SphericCoordinate} representation.
	 * @throws IllegalArgumentException when there is null.
	 * @throws IllegalComponentStateException when the calculated distance is smaller than 0.
	 * @methodtype comparison
	 */
	@SuppressWarnings("unused")
	private double getDistance(SphericCoordinate there) {
		if(there == null)
			throw new IllegalArgumentException("Input was Null!");
		
		if (this.equals(there)) {
			return 0;
		} else {			
			double result = calculateDistance(there);
			this.assertPostcondition(result);
			return result; 
		}
	}
	
	/**
	 * Asserts, that the given position is a valid one.
	 * @param Latitude has to be between -90 and 90
	 * @param Longitude has to be between -180 and 180
	 * @throws IllegalArgumentException when parameters are not in the specified range.
	 * @methodtype assert
	 */
	private void assertPrecondition(double latitude, double longitude) {
		if (! this.isValidLatitude(latitude))
			throw new IllegalArgumentException("Latitude must be between -90 and 90.");
		
		if (! this.isValidLongitude(longitude)) {
			throw new IllegalArgumentException("Lonitude must be between -180 and 180.");
		}
	}
	
	/**
	 * Asserts, that the result of the getDistance method is a valid distance.
	 * @throws IllegalComponentStateException when the result is smaller than 0.
	 * @methodtype assert
	 */
	private void assertPostcondition(double distance) {
		if (distance < 0)
			throw new IllegalComponentStateException("Distance must not be smaller than 0.");
	}
	
	/**
	 * Asserts, that the class is in a valid state.
	 * @throws IllegalStateException when one of the internal fields is outside of the valid range.
	 * @methodtype assert
	 */
	private void assertInvariant() {
		if (this.isValidLatitude(this.getLatitude()) && this.isValidLongitude(this.getLongitude()))
			return;
		else {
			throw new IllegalStateException("Latitude be between -90 and 90 and Lonitude between -180 and 180.");
		}
	}
	
	/**
	 * @methodtype boolean query
	 */
	private boolean isValidLatitude(double degree) {
		if(Double.isNaN(latitude) || latitude > 90 || latitude < -90) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @methodtype boolean query
	 */
	private boolean isValidLongitude(double degree) {
		if(Double.isNaN(longitude) || longitude > 180 || longitude < -180) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * @methodtype helper
	 */
	private double calculateDistance(SphericCoordinate there) {
		double squaredLatitude = Math.pow(this.getLatitudinalDistance(there), 2);
		this.assertInvariant();
		
		double squaredLongitude = Math.pow(this.getLongitudinalDisance(there), 2);
		this.assertInvariant();
		
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

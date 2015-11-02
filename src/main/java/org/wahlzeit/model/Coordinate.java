package org.wahlzeit.model;

public class Coordinate {
	private double latitude;
	private double longitude;
	
	/**
	 * @methodtype constructor
	 */
	public Coordinate(double latitude, double longitude) {
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
	 * @methodtype comparison
	 */
	public double getDistance(Coordinate there) {
		if(there == null)
			throw new IllegalArgumentException("Input was Null!");
		
		return calculateDistance(there);
	}
	
	/**
	 * @methodtype comparison
	 */
	public double getLatitudinalDistance(Coordinate there) {
		if(there == null)
			throw new IllegalArgumentException("Input was Null!");
		
		return Math.abs(this.latitude - there.getLatitude());
	}
	
	/**
	 * @methodtype comparison
	 */
	public double getLongitudinalDisance(Coordinate there) {
		if(there == null)
			throw new IllegalArgumentException("Input was Null!");
		
		return Math.abs(this.longitude - there.getLongitude());
	}
	
	/**
	 * @methodtype helper
	 */
	private double calculateDistance(Coordinate there) {
		double squaredLatitude = Math.pow(this.getLatitudinalDistance(there), 2);
		double squaredLongitude = Math.pow(this.getLongitudinalDisance(there), 2);
		return Math.sqrt(squaredLatitude + squaredLongitude);
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
		if (!(obj instanceof Coordinate))
			return false;
		
		Coordinate other = (Coordinate) obj;
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

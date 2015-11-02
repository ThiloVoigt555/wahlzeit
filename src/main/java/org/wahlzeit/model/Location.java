package org.wahlzeit.model;

public class Location {
	private Coordinate coordinate;
	private String name;
	
	/**
	 * @methodtype constructor
	 */
	public Location(Coordinate coordinate, String name) {
		super();
		this.coordinate = coordinate;
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	/**
	 * @methodtype get
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @methodtype set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}

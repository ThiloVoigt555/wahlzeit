package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.ObjectManager;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

/**
 * Represents a location on earth.
 */
@Entity
public class Location extends DataObject {
	/**
	 * 
	 */
	@Id
	private static final long serialVersionUID = -2884389023841908956L;
	@Parent
	Key parent = ObjectManager.applicationRootKey;
	
	private SphericCoordinate coordinate;
	private String name = "unknown";
	
	/**
	 * @methodtype constructor
	 */
	public Location(SphericCoordinate coordinate, String name) {
		super();
		this.coordinate = coordinate;
		this.name = name;
	}
	
	/**
	 * @methodtype get
	 */
	public SphericCoordinate getCoordinate() {
		return coordinate;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCoordinate(SphericCoordinate coordinate) {
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

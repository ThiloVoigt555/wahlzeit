package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Set;

import javax.activity.InvalidActivityException;

import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.ObjectManager;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

/**
 * Manages the already created instances of Coordinates and makes sure, 
 * only one representation of a point in space is instantiated.
 */
@Entity
public class CoordinateManager extends DataObject {

	/**
	 * 
	 */
	@Id
	private static final long serialVersionUID = 3936005048678869566L;
	@Parent
	Key parent = ObjectManager.applicationRootKey;
	
	private static CoordinateManager instance = null;
	private Set<Coordinate> coordinateStoreage;
	
	private CoordinateManager() {
		this.coordinateStoreage = new HashSet<>();
	}
	
	public static CoordinateManager getInstance() {
		if (instance == null)
			instance = new CoordinateManager();
		
		return instance;
	}
	
	/**
	 * Returns an representation of the given spheric coordinates.
	 * @param latitude the latitude of the Coordinate
	 * @param longitude the latitude of the Coordinate
	 * @return A Coordinate instance to the given point in space.
	 */
	public Coordinate getCoordinate(double latitude, double longitude) {
		Coordinate freshCoordinate = new SphericCoordinate(latitude, longitude);
		
		return this.lookUpCoordinate(freshCoordinate);
	}
	
	/**
	 * Returns an representation of the given spheric coordinates.
	 * @param latitude the latitude of the Coordinate
	 * @param longitude the latitude of the Coordinate
	 * @return A Coordinate instance to the given point in space.
	 * @throws InvalidActivityException in case of an internal datastructure error.
	 */
	public Coordinate getCoordinate(double x, double y, double z) {
		Coordinate freshCoordinate = new CartesianCoordinate(x, y, z);
		
		return this.lookUpCoordinate(freshCoordinate);
	}
	
	private Coordinate lookUpCoordinate(Coordinate freshCoordinate) {
		if (this.coordinateStoreage.contains(freshCoordinate)) {
			for (Coordinate oldCoordinate : coordinateStoreage) {
				if (oldCoordinate.equals(freshCoordinate))
					return oldCoordinate;
			}
			return null;
			
		} else {
			this.coordinateStoreage.add(freshCoordinate);
			return freshCoordinate;
		}
	}
}

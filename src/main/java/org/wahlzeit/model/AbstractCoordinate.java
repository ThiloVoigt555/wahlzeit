package org.wahlzeit.model;

import java.awt.IllegalComponentStateException;

import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.ObjectManager;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;

@Entity
public abstract class AbstractCoordinate extends DataObject implements Coordinate {
	/**
	 * 
	 */
	@Id
	private static final long serialVersionUID = 7139759892066329592L;
	@Parent
	Key parent = ObjectManager.applicationRootKey;

	/**
	 * Calculates the distance to another {@link SphericCoordinate} point.
	 * @param there is a second point in a {@link SphericCoordinate} representation.
	 * @throws IllegalArgumentException when there is null.
	 * @throws IllegalStateException when the conversion to an SphericCoordinate could not be done.
	 * @throws IllegalComponentStateException when the calculated distance is smaller than 0.
	 * @methodtype comparison
	 */
	@Override
	public double getDistance(Coordinate there) {			
		return this.getDistance(there.asSphericCoordinate());
	}
	
	/**
	 * @methodtype boolean comparison
	 */
	@Override
	public boolean isEqual(Coordinate there) {
		return this.asSphericCoordinate().isEqual(there);
	}
}

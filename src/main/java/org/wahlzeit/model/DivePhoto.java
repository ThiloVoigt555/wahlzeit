package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Subclass;

/**
 * Represents a Photo of the Diving domain of this WahlZeit instance.
 */
@Subclass
public class DivePhoto extends Photo {
	/**
	 * 
	 */
	@Id
	private static final long serialVersionUID = 5271409141930682239L;
	private Dive dive;
	
	/**
	 * @methodtype constructor
	 */
	public DivePhoto() {
		super();
	}
	
	/**
	 * @methodtype constructor
	 */
	public DivePhoto(PhotoId id) {
		super(id);
	}
	
	/**
	 * @methodtype constructor
	 */
	public DivePhoto(PhotoId id, Location location) {
		super(id, location);
	}
	
	/**
	 * @param dive The dive the photo was taken in
	 * @methodtype constructor
	 */
	public DivePhoto(Location location, Dive dive) {
		super(location);
		this.dive = dive;
	}
	
	/**
	 * @methodtype get
	 */
	public Dive getDive() {
		return this.dive;
	}

	/**
	 * @methodtype set
	 */
	public void setDive(Dive dive) {
		this.dive = dive;
	}

	/**
	 * @methodtype conversion
	 */
	@Override
	public String toString() {
		return "DivePhoto [dive=" + dive + "]";
	}	
}

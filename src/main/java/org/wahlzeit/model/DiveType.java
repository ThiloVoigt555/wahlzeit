package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * The type-object of the Dive class.
 */
@Entity
public class DiveType extends DataObject {
	
	/**
	 * 
	 */
	@Id
	private static final long serialVersionUID = -8307394371592136448L;
	
	private boolean scuba;
	private boolean sportDive;
	private boolean blueWater;
	
	/**
	 * Creates a DiveType
	 * @param scooba True, if scuba gear was used
	 * @param sportDive True, if the dive was above 30 meters in depth
	 * @param blueWater True, if the open water was blue-water (like the ocean)
	 * @methodtype constructor
	 */
	public DiveType(boolean scuba, boolean sportDive, boolean blueWater) {
		super();
		this.scuba = scuba;
		this.sportDive = sportDive;
		this.blueWater = blueWater;
	}
	
	public boolean isScuba() {
		return scuba;
	}
	
	public boolean isSportDive() {
		return sportDive;
	}

	public boolean isBlueWater() {
		return blueWater;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (blueWater ? 1231 : 1237);
		result = prime * result + (scuba ? 1231 : 1237);
		result = prime * result + (sportDive ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DiveType))
			return false;
		DiveType other = (DiveType) obj;
		if (blueWater != other.blueWater)
			return false;
		if (scuba != other.scuba)
			return false;
		if (sportDive != other.sportDive)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiveType [scuba=" + scuba + ", sportDive=" + sportDive + ", blueWater=" + blueWater + "]";
	}
}

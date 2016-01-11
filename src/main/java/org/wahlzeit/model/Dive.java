package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import com.googlecode.objectify.annotation.Container;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * This object represents a dive during which photo was taken
 */
@Entity
public class Dive extends DataObject {

	/**
	 * 
	 */
	@Id
	private static final long serialVersionUID = -6602786019010968337L;
	
	@Container
	private DiveType type; 
	private int depth; 
	private int diveTime; 
	private String buddy; 
	
	/**
	 * Creates a dive class representing a actual dive of the given type
	 * @param type The type of the dive (abnoe, deep, sport, current, blue- or blackwater...)
	 * @param depth The diving-depth the photo was made
	 * @param diveTime The time under water on the dive
	 * @param buddy The name of the dive buddy
	 * @methodtype constructor
	 */
	public Dive(DiveType type, int depth, int diveTime, String buddy) {
		super();
		this.type = type;
		this.depth = depth;
		this.diveTime = diveTime;
		this.buddy = buddy;
	}

	public DiveType getType() {
		return type;
	}

	public void setType(DiveType type) {
		this.type = type;
	}

	public int getDepth() {
		return depth;
	}

	public int getDiveTime() {
		return diveTime;
	}

	public String getBuddy() {
		return buddy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buddy == null) ? 0 : buddy.hashCode());
		result = prime * result + depth;
		result = prime * result + diveTime;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Dive))
			return false;
		Dive other = (Dive) obj;
		if (buddy == null) {
			if (other.buddy != null)
				return false;
		} else if (!buddy.equals(other.buddy))
			return false;
		if (depth != other.depth)
			return false;
		if (diveTime != other.diveTime)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dive [type=" + type + ", depth=" + depth + ", diveTime=" + diveTime + ", buddy=" + buddy + "]";
	}
}

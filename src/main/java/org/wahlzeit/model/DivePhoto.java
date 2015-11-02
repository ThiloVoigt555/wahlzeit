package org.wahlzeit.model;

public class DivePhoto extends Photo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5271409141930682239L;
	
	private int depth; // The diving-depth the photo was made
	private int diveTime; // The time under water on the dive
	
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
	public DivePhoto(int depth, int diveTime) {
		super();
		this.depth = depth;
		this.diveTime = diveTime;
	}
	
	/**
	 * @methodtype get
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @methodtype set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @methodtype get
	 */
	public int getDiveTime() {
		return diveTime;
	}

	/**
	 * @methodtype set
	 */
	public void setDiveTime(int diveTime) {
		this.diveTime = diveTime;
	}

	/**
	 * @methodtype conversion
	 */
	@Override
	public String toString() {
		return "DivePhoto [depth=" + depth + ", diveTime=" + diveTime + "]";
	}	
}
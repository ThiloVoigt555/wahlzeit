package org.wahlzeit.model;

public class DivePhotoFactory extends PhotoFactory {

	/**
	 * @methodtype factory
	 */
	@Override
	public DivePhoto createPhoto() {
		return new DivePhoto();
	}

	/**
	 * Creates a new photo with the specified id 
	 * @methodtype factory
	 */
	@Override
	public DivePhoto createPhoto(PhotoId id) {
		return new DivePhoto(id);
	}
}

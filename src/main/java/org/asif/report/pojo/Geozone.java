package org.asif.report.pojo;

public class Geozone {

	private String geozone;

	public Geozone(String geozone) {
		super();
		this.geozone = geozone;
	}

	public String getGeozone() {
		return geozone;
	}

	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}

	@Override
	public String toString() {
		return "Geozone [geozone=" + geozone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geozone == null) ? 0 : geozone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geozone other = (Geozone) obj;
		if (geozone == null) {
			if (other.geozone != null)
				return false;
		} else if (!geozone.equals(other.geozone))
			return false;
		return true;
	}

}

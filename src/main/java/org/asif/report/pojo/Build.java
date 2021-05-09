package org.asif.report.pojo;

public class Build {

	private String buildtime;

	public Build(String buildtime) {
		super();
		String time = buildtime;
		if (buildtime.contains("s")) {
			time = buildtime.substring(0, buildtime.length() - 1);
		}
		this.buildtime = time;
	}

	public String getBuildtime() {
		return buildtime;
	}

	public void setBuildtime(String buildtime) {
		this.buildtime = buildtime;
	}

	@Override
	public String toString() {
		return "Build [buildtime=" + buildtime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildtime == null) ? 0 : buildtime.hashCode());
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
		Build other = (Build) obj;
		if (buildtime == null) {
			if (other.buildtime != null)
				return false;
		} else if (!buildtime.equals(other.buildtime))
			return false;
		return true;
	}

}

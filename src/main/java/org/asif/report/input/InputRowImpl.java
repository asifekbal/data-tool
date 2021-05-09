package org.asif.report.input;

import java.util.Arrays;

public class InputRowImpl implements InputRow {

	private final String customerID;
	private final String contractID;
	private final String geoZone;
	private final String teamCode;
	private final String projectCode;
	private final String buildDuration;
	private String[] values;

	public InputRowImpl(String customerID, String contractID, String geoZone, String teamCode, String projectCode,
			String buildDuration) {
		super();
		this.customerID = customerID;
		this.contractID = contractID;
		this.geoZone = geoZone;
		this.teamCode = teamCode;
		this.projectCode = projectCode;
		this.buildDuration = buildDuration;
		this.values = new String[6];

		values[0] = customerID;
		values[1] = contractID;
		values[2] = geoZone;
		values[3] = teamCode;
		values[4] = projectCode;
		values[5] = buildDuration;
	}
	
	@Override
	public String toString() {
		return "InputRowImpl [customerID=" + customerID + ", contractID=" + contractID + ", geoZone=" + geoZone
				+ ", teamCode=" + teamCode + ", projectCode=" + projectCode + ", buildDuration=" + buildDuration + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(values);
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
		InputRowImpl other = (InputRowImpl) obj;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}

	@Override
	public String getCustomerID() {
		return customerID;
	}

	@Override
	public String getContractID() {
		return contractID;
	}

	@Override
	public String getGeoZone() {
		return geoZone;
	}

	@Override
	public String getTeamCode() {
		return teamCode;
	}

	@Override
	public String getProjectCode() {
		return projectCode;
	}

	@Override
	public String getBuildDuration() {
		return buildDuration;
	}

	@Override
	public String[] getValues() {
		return values;
	}

}

package org.asif.report.output;

import java.util.Arrays;

public class ReportDResultRowImpl implements ResultRow {

	private final String geoZone;
	private final String customerIDs;
	private String[] values;

	private static final String[] header = { "Geo Zone", "Customers IDs List" };

	public ReportDResultRowImpl(String geoZone, String customerIDs) {
		super();
		this.geoZone = geoZone;
		this.customerIDs = customerIDs;

		this.values = new String[2];
		values[0] = geoZone;
		values[1] = customerIDs;

	}

	@Override
	public String[] getValues() {
		return values;
	}

	@Override
	public String[] getHeaders() {
		return header;
	}

	@Override
	public String toString() {
		return "ReportAResultRowImpl [geoZone=" + geoZone + ", customerIDs=" + customerIDs + ", values="
				+ Arrays.toString(values) + "]";
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
		ReportDResultRowImpl other = (ReportDResultRowImpl) obj;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}

}

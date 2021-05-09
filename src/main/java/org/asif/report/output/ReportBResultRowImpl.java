package org.asif.report.output;

import java.util.Arrays;

public class ReportBResultRowImpl implements ResultRow {

	private final String geoZone;
	private final String numberOfCustomer;
	private String[] values;

	private static final String[] header = {"Geo Zone", "No of Unique Customers"};

	public ReportBResultRowImpl(String geoZone, String numberOfCustomer) {
		super();
		this.geoZone = geoZone;
		this.numberOfCustomer = numberOfCustomer;

		this.values = new String[2];
		values[0] = geoZone;
		values[1] = numberOfCustomer;

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
		return "ReportAResultRowImpl [geoZone=" + geoZone + ", numberOfCustomer=" + numberOfCustomer + ", values="
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
		ReportBResultRowImpl other = (ReportBResultRowImpl) obj;
		if (!Arrays.equals(values, other.values))
			return false;
		return true;
	}

}

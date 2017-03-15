package com.java.iq.core.dp;

public class Range {
	int start;
	int end;

	public Range(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {

		return this.start + "," + this.end;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;

		Range range = (Range) o;

		if (Integer.compare(this.start, range.start) != 0)
			return false;

		if (Integer.compare(this.end, range.end) != 0)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return start + end;
	}
}

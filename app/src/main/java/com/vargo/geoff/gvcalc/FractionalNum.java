package com.vargo.geoff.gvcalc;

/**
 * Created by geoff on 10/7/2017.
 */

public class FractionalNum {
	protected Double numVal = 0.0;
	protected Boolean hasFraction = Boolean.FALSE;
	protected int fraction = 0;

	public FractionalNum(Double numVal) {
		this.numVal = numVal;
	}

	public int getFraction() {
		return fraction;
	}

	public void setFraction(int fraction) {
		this.fraction = fraction;
	}

	public Double getNumVal() {
		return numVal;
	}

	public void setNumVal(Double numVal) {
		this.numVal = numVal;
	}

	public Boolean getHasFraction() {
		return hasFraction;
	}

	public void setHasFraction(Boolean hasFraction) {
		this.hasFraction = hasFraction;
	}
}

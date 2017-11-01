package com.vargo.geoff.gvcalc;

import static com.vargo.geoff.gvcalc.Type.EMPTY;

/**
 * Created by geoff on 8/22/2017.
 */

public class TokenBuilder {
	private Type type = EMPTY;
	private String value = "";
	private int length = 0;
	Boolean neg = false;

	public TokenBuilder setType(Type type) {
		this.type = type;
		return this;
	}

	public TokenBuilder setValue(String value) {
		this.value = value;
		return this;
	}

	public TokenBuilder setLength(int length) {
		this.length = length;
		return this;
	}

	public TokenBuilder setNegative(Boolean value) {
		this.neg = value;
		return this;
	}

	public Token createToken() {
		return new Token(value, type, length, neg);
	}
}
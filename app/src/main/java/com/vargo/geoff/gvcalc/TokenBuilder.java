package com.vargo.geoff.gvcalc;

import com.vargo.geoff.gvcalc.MainActivity.*;
/**
 * Created by geoff on 8/22/2017.
 */

public class TokenBuilder {
	private Type type;
	private String value;

	public TokenBuilder setType(Type type) {
		this.type = type;
		return this;
	}

	public TokenBuilder setValue(String value) {
		this.value = value;
		return this;
	}

	public Token createToken() {
		return new Token(value, type);
	}
}
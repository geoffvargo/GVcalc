package com.vargo.geoff.gvcalc;

import static com.vargo.geoff.gvcalc.Type.EMPTY;
import static com.vargo.geoff.gvcalc.Type.LEFT_PAREN;
import static com.vargo.geoff.gvcalc.Type.NUM;
import static com.vargo.geoff.gvcalc.Type.OP;
import static com.vargo.geoff.gvcalc.Type.RIGHT_PAREN;
import static com.vargo.geoff.gvcalc.Type.VAR;


public class Token {
	private String value = "";
	private Type type = EMPTY;

	public Token() {
	}

	public Token(Type type) {
		this.type = type;
	}

	public Token(String value, Type type) {
		this.value = value;
		this.type = type;
	}

	public void concat(String str) {
		this.value = this.value.concat(str);
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isNum() {
		if (this.type == NUM) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isVar() {
		if (this.type == VAR) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLeftParen() {
		if (this.type == LEFT_PAREN) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRightParen() {
		if (this.type == RIGHT_PAREN) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOperator() {
		if (this.type == OP) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (this.type == EMPTY) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Token{" +
				"value='" + value + '\'' +
				", type=" + type +
				'}';
	}
}

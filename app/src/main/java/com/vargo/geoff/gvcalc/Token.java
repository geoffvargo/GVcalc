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
	private int length = 0;
	private Double numVal = null;
	private String latex = "";
	private int ordinal = -1;

	public Token(Type type) {
		this.type = type;
	}

	public Token(String value, Type type) {
		this.value = value;
		this.type = type;
	}

	public Token(String value, Type type, int length) {
		this.value = value;
		this.type = type;
		this.length = length;

		if (this.type == NUM) {
			if (!this.value.isEmpty()) {
				this.numVal = Double.parseDouble(this.value);
				this.latex = this.value;
			} else {
				this.numVal = 0.0;
			}
		}

	}

	public void setLatex(String latex) {
		this.latex = latex;
	}

	public void concat(String str) {
		if (this.type == NUM) {
			this.value = this.value.concat(str);
			this.length++;

			this.numVal = Double.parseDouble(this.value);
		}
	}

	public void prepend(String str) {
		if (this.type == NUM) {
			this.value = new String(str + this.value);
			this.length++;

			this.numVal = Double.parseDouble(this.value);
		}
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

		if (!this.value.isEmpty() && this.type == NUM) {
			this.numVal = Double.parseDouble(this.value);
		}
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Double getNumVal() {
		return numVal;
	}

	public void setNumVal(Double numVal) {
		this.numVal = numVal;
	}

	public void negate() {
		if (type == NUM && numVal != null) {
			numVal *= -1;
			value = String.valueOf(numVal);
		}
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public String getLatex() {
		return latex;
	}
}

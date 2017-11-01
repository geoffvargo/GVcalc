package com.vargo.geoff.gvcalc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;

import static com.vargo.geoff.gvcalc.Type.NUM;
import static com.vargo.geoff.gvcalc.Type.OP;
import static org.junit.Assert.assertEquals;

/**
 * Created by geoff on 10/9/2017.
 */

public class AdditionalCalcTests {

	private static final String DIV = "÷";
	private static final String MULT = "×";
	private static final String LPAREN = "(";
	private static final String RPARN = ")";
	protected ArrayDeque<Token> tokens = new ArrayDeque<>();
	protected TokenBuilder tbuild = new TokenBuilder();
	protected MainActivity activity = new MainActivity();

	protected boolean addToken(Type type, String value) {
		Token ans = tbuild.setType(type).setValue(value).createToken();
		return activity.tokens.add(ans);
	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void decimalTestONE() throws Exception {
		addToken(NUM, "3.25");
		addToken(OP, "+");
		addToken(NUM, "1.375");

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 4.625;
//		System.out.printf("value: %s\n", ans.getValue());
//		System.out.printf("latex: %s\n", ans.getLatex());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void negateTestONE() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}
}

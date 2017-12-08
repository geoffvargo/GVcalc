package com.vargo.geoff.gvcalc;

/**
 * Created by geoff on 11/12/2017.
 */

import org.junit.Rule;
import org.junit.Test;

import static com.vargo.geoff.gvcalc.Type.NUM;
import static com.vargo.geoff.gvcalc.Type.OP;
import static org.junit.Assert.assertEquals;

//@RunWith(AndroidJUnit4.class)
public class MoreCalcTests {

	public MainActivity activity = new MainActivity();

	private static final String DIV = "÷";
	private static final String MULT = "×";
	private static final String LPAREN = "(";
	private static final String RPAREN = ")";
	private static final String MINUS = "-";
	private static final String PLUS = "+";


	public boolean addNumToken(Double value) throws Exception {
		Token ans = activity.tokenBuilder.setType(NUM).setValue(value.toString()).createToken();
		return activity.tokens.add(ans);
	}

	public boolean addOpToken(String value) throws Exception {
		Token ans = activity.tokenBuilder.setType(OP).setValue(value).createToken();
		return activity.tokens.add(ans);
	}

	@Test
	public void testONE() throws Exception {
		addOpToken(LPAREN);
		addNumToken(1.0);
		addOpToken("+");
		addNumToken(2.0);
		addOpToken(RPAREN);

		System.out.printf("TOKENS: %s\n", activity.tokens.toString());

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 3.0;

		assertEquals("expec", rightAns, ans.getNumVal());
		System.out.printf("RESULT: %f\n", ans.getNumVal().doubleValue());
	}
	@Test
	public void testTWO() throws Exception {
		addOpToken(LPAREN);
		addNumToken(1234.0);
		addOpToken("-");
		addNumToken(51234.0);
		addOpToken(RPAREN);

		System.out.printf("TOKENS: %s\n", activity.tokens.toString());

		Double rightAns = -50000.0;
		Token ans = activity.calc(activity.tokens);

		System.out.printf("EXPECTED: %f\n", rightAns);
		System.out.printf("RESULT: %f\n", ans.getNumVal());
		assertEquals(String.format("Expected %f, but got %f.\n", rightAns, ans.getNumVal()), rightAns, ans.getNumVal());
	}

	@Test
	public void testTHREE() throws Exception {
		addOpToken(LPAREN);
		addNumToken(1.0);
		addOpToken("+");
		addNumToken(2.0);
		addOpToken(RPAREN);
		activity.currTok.setNegative(true);

		System.out.printf("TOKENS: %s\n", activity.tokens.toString());

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 3.0;

		assertEquals("expec", rightAns, ans.getNumVal());
		System.out.printf("RESULT: %f\n", ans.getNumVal().doubleValue());
	}
}

package com.vargo.geoff.gvcalc;

import org.junit.Test;

import java.util.ArrayDeque;

import static com.vargo.geoff.gvcalc.Type.LEFT_PAREN;
import static com.vargo.geoff.gvcalc.Type.NUM;
import static com.vargo.geoff.gvcalc.Type.OP;
import static com.vargo.geoff.gvcalc.Type.RIGHT_PAREN;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

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

	@Test
	public void subtract_isCorrect1() {
		addToken(NUM, "3");
		addToken(OP, "-");
		addToken(NUM, "1");

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 2.0;
		System.out.printf("value: %s\n", ans.getValue());
		System.out.printf("latex: %s\n", ans.getLatex());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void ternaryOp_isCorrect() {
		addToken(NUM, "1");
		addToken(OP, "+");
		addToken(NUM, "3");
		addToken(OP, "-");
		addToken(NUM, "2");

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 2.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void mult_isCorrect1() throws Exception {
		setupTokensMULT_1();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 27.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	public void setupTokensMULT_1() {
		addToken(NUM, "3");
		addToken(OP, MULT);
		addToken(NUM, "3");
		addToken(OP, MULT);
		addToken(NUM, "3");
	}

	@Test
	public void mult_isCorrect2() throws Exception {
		setupTokensMULT_2();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 120.0;
		System.out.printf("value: %s\n", ans.getValue());
		System.out.printf("latex: %s\n", ans.getLatex());
		;
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	public void setupTokensMULT_2() {
		addToken(NUM, "2");
		addToken(OP, MULT);
		addToken(NUM, "3");
		addToken(OP, MULT);
		addToken(NUM, "4");
		addToken(OP, MULT);
		addToken(NUM, "5");
	}

	@Test
	public void div_isCorrect1() throws Exception {
		setupTokensDIV_1();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 2.0;
		System.out.printf("value: %s\n", ans.getValue());
		System.out.printf("latex: %s\n", ans.getLatex());
		;
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	public void setupTokensDIV_1() {
		addToken(NUM, "4");
		addToken(OP, DIV);
		addToken(NUM, "2");
	}

	@Test
	public void parens1_isCorrect() throws Exception {
		setupTokensMULT_3();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 120.0;
		System.out.printf("value: %s\n", ans.getValue());
		System.out.printf("latex: %s\n", ans.getLatex());
		;
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	public void setupTokensMULT_3() {
		addToken(NUM, "2");
		addToken(LEFT_PAREN, LPAREN);
		addToken(NUM, "3");
		addToken(OP, MULT);
		addToken(NUM, "4");
		addToken(OP, MULT);
		addToken(NUM, "5");
		addToken(RIGHT_PAREN, RPARN);
	}

	@Test
	public void parens2_isCorrect() throws Exception {
		setupTokensDIV_3();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 2.0;
		System.out.printf("value: %s\n", ans.getValue());
		System.out.printf("latex: %s\n", ans.getLatex());

		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	public void setupTokensDIV_3() {
		addToken(LEFT_PAREN, LPAREN);
		addToken(NUM, "1");
		addToken(OP, "+");
		addToken(NUM, "3");
		addToken(RIGHT_PAREN, RPARN);
		addToken(OP, DIV);
		addToken(NUM, "2");
	}

	@Test
	public void parens3_isCorrect() throws Exception {
		setupTokensDIV_4();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 4.0;
		System.out.printf("value: %s\n", ans.getValue());
		System.out.printf("latex: %s\n", ans.getLatex());

		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	public void setupTokensDIV_4() {
		addToken(NUM, "24");
		addToken(OP, DIV);
		addToken(LEFT_PAREN, LPAREN);
		addToken(NUM, "2");
		addToken(OP, MULT);
		addToken(NUM, "3");
		addToken(RIGHT_PAREN, RPARN);
	}

	@Test
	public void parens4_isCorrect() throws Exception {
		addToken(NUM, "55");
		addToken(OP, MULT);
		addToken(NUM, "3");
		addToken(LEFT_PAREN, LPAREN);
		addToken(NUM, "1");
		addToken(OP, "+");
		addToken(NUM, "3");
		addToken(RIGHT_PAREN, RPARN);
		// 55*3(1+3) = 660

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 660.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void opPrec_test1() {
		addToken(NUM, "22");
		addToken(OP, MULT);
		addToken(NUM, "2");
		addToken(OP, "+");
		addToken(NUM, "3");
		// CORRECT ANS: 22 * 2 + 3 = 47
		// WRONG ANS: 22 * 2 + 3 = 110

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 47.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void opPrec_test2() {
		addToken(NUM, "3");
		addToken(OP, "+");
		addToken(NUM, "22");
		addToken(OP, DIV);
		addToken(NUM, "2");
		// CORRECT ANS: 3 + 22 / 2 = 14

		Token ans = activity.calc(activity.tokens);
		Double rightAns = 14.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}
}
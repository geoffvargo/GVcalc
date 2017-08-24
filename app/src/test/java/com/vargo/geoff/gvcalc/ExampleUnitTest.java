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

	protected ArrayDeque<Token> tokens = new ArrayDeque<>();
	protected TokenBuilder tbuild = new TokenBuilder();
	protected MainActivity activity = new MainActivity();

	private static final String DIV = "÷";
	private static final String MULT = "×";
	private static final String LPAREN = "(";
	private static final String RPARN = ")";


	public void setupTokensDIV_1() {
		addToken(NUM, "3");
		addToken(OP, DIV);
		addToken(NUM, "3");
	}

	public void setupTokensMULT_1() {
		addToken(NUM, "3");
		addToken(OP, MULT);
		addToken(NUM, "3");
		addToken(OP, MULT);
		addToken(NUM, "3");
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

	public void setupTokensDIV_3() {
		addToken(LEFT_PAREN, LPAREN);
		addToken(NUM, "1");
		addToken(OP, "+");
		addToken(NUM, "3");
		addToken(RIGHT_PAREN, RPARN);
		addToken(OP, DIV);
		addToken(NUM, "2");
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

	protected boolean addToken(Type type, String value) {
		return activity.tokens.add(tbuild.setType(type).setValue(value).createToken());
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

	@Test
	public void mult_isCorrect2() throws Exception {
		setupTokensMULT_2();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 120.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void div_isCorrect1() throws Exception {
		setupTokensDIV_1();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 1.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void parens1_isCorrect() throws Exception {
		setupTokensMULT_3();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 120.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void parens2_isCorrect() throws Exception {
		setupTokensDIV_3();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 2.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}

	@Test
	public void parens3_isCorrect() throws Exception {
		setupTokensDIV_4();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 4.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}
}
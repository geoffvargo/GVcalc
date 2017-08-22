package com.vargo.geoff.gvcalc;

import org.junit.Test;

import java.util.ArrayDeque;

import static com.vargo.geoff.gvcalc.Type.NUM;
import static com.vargo.geoff.gvcalc.Type.OP;

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

	public void setupTokensDIV_1() {
		activity.tokens.add(tbuild.setType(NUM).setValue("3").createToken());
		activity.tokens.add(tbuild.setType(OP).setValue("÷").createToken());
		activity.tokens.add(tbuild.setType(NUM).setValue("3").createToken());
	}

	public void setupTokensMULT_1() {
		activity.tokens.add(tbuild.setType(NUM).setValue("3").createToken());
		activity.tokens.add(tbuild.setType(OP).setValue("×").createToken());
		activity.tokens.add(tbuild.setType(NUM).setValue("3").createToken());
		activity.tokens.add(tbuild.setType(OP).setValue("×").createToken());
		activity.tokens.add(tbuild.setType(NUM).setValue("3").createToken());
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
	public void div_isCorrect1() throws Exception {
		setupTokensDIV_1();
		Token ans = activity.calc(activity.tokens);
		Double rightAns = 1.0;
		System.out.println(ans.getValue());
		Double actual = Double.parseDouble(ans.getValue());
		assertEquals(rightAns, actual);
	}
}
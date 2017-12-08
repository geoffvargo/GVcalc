package com.vargo.geoff.gvcalc;

import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

import static com.vargo.geoff.gvcalc.ButtonENUM.*;

public class ExampleInstrumentedTest {

	/**
	 * Instrumentation test, which will execute on an Android device.
	 *
	 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
	 */
//@RunWith(AndroidJUnit4.class)
	private static final String DIV = "÷";
	private static final String MULT = "×";
	private static final String LPAREN = "(";
	private static final String RPARN = ")";

	@Rule
	public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

	@Test
	public void pressButtonONE() throws Exception {
		onView(withId(R.id.oneBTN)).perform(click());
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.divBTN)).perform(click());
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
//		System.out.print(activityTestRule.getActivity().currTok.toString());
		Log.i("pressButtonONE", activityTestRule.getActivity().currTok.toString());
		Double ans = 6.0;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	@Test
	public void pressButtonTWO() throws Exception {
		onView(withId(R.id.oneBTN)).perform(click());
		onView(withId(R.id.threeBTN)).perform(click());
		onView(withId(R.id.divBTN)).perform(click());
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
//		System.out.print(activityTestRule.getActivity().currTok.toString());
		Log.i("pressButtonTWO", activityTestRule.getActivity().currTok.toString());
		Double ans = 6.5;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	@Test
	public void pressButtonTHREE() throws Exception {
		onView(withId(R.id.oneBTN)).perform(click());
		onView(withId(R.id.threeBTN)).perform(click());
		onView(withId(R.id.divBTN)).perform(click());
		onView(withId(R.id.fourBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
//		System.out.print(activityTestRule.getActivity().currTok.toString());
		Log.i("pressButtonTHREE", activityTestRule.getActivity().currTok.toString());
		Double ans = 3.25;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	@Test
	public void pressButtonFOUR() throws Exception {
		onView(withId(R.id.oneBTN)).perform(click());
		onView(withId(R.id.threeBTN)).perform(click());
		onView(withId(R.id.divBTN)).perform(click());
		onView(withId(R.id.fiveBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
//		System.out.print(activityTestRule.getActivity().currTok.toString());
		Log.i("pressButtonFOUR", activityTestRule.getActivity().currTok.toString());
		Double ans = 2.6;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	@Test
	public void pressButtonFIVE() throws Exception {
		onView(withId(R.id.oneBTN)).perform(click());
		onView(withId(R.id.threeBTN)).perform(click());
		onView(withId(R.id.divBTN)).perform(click());
		onView(withId(R.id.fiveBTN)).perform(click());
		onView(withId(R.id.multiplyBTN)).perform(click());
		onView(withId(R.id.fourBTN)).perform(click());
		onView(withId(R.id.pointBTN)).perform(click());
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
//		System.out.print(activityTestRule.getActivity().currTok.toString());
		Log.i("pressButtonFOUR", activityTestRule.getActivity().currTok.toString());
		Double ans = 10.92;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	@Test
	public void negateButtonONE() throws Exception {
		onView(withId(R.id.oneBTN)).perform(click());
		onView(withId(R.id.negBTN)).perform(click());
		onView(withId(R.id.plusBTN)).perform(click());
		onView(withId(R.id.zeroBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
		Double ans = -1.0;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	@Test
	public void negateButtonTWO() throws Exception {
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.negBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
		Double ans = -22.0;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	@Test
	public void negateButtonTHREE() throws Exception {
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.twoBTN)).perform(click());
		onView(withId(R.id.negBTN)).perform(click());
		onView(withId(R.id.plusBTN)).perform(click());
		onView(withId(R.id.oneBTN)).perform(click());
		onView(withId(R.id.evalBTN)).perform(click());
		Double ans = -21.0;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}

	public void onViewChain(ButtonENUM... buttons) {
		for (ButtonENUM button : buttons) {
			switch (button) {
				case ZERO:
					onView(withId(R.id.zeroBTN)).perform(click());
					break;
				case ONE:
					onView(withId(R.id.oneBTN)).perform(click());
					break;
				case TWO:
					onView(withId(R.id.twoBTN)).perform(click());
					break;
				case THREE:
					onView(withId(R.id.threeBTN)).perform(click());
					break;
				case FOUR:
					onView(withId(R.id.fourBTN)).perform(click());
					break;
				case FIVE:
					onView(withId(R.id.fiveBTN)).perform(click());
					break;
				case SIX:
					onView(withId(R.id.sixBTN)).perform(click());
					break;
				case SEVEN:
					onView(withId(R.id.sevenBTN)).perform(click());
					break;
				case EIGHT:
					onView(withId(R.id.eightBTN)).perform(click());
					break;
				case NINE:
					onView(withId(R.id.nineBTN)).perform(click());
					break;
				case PLUS:
					onView(withId(R.id.plusBTN)).perform(click());
					break;
				case MINUS:
					onView(withId(R.id.minusBTN)).perform(click());
					break;
				case TIMES:
					onView(withId(R.id.multiplyBTN)).perform(click());
					break;
				case DIVIDE:
					onView(withId(R.id.divBTN)).perform(click());
					break;
				case NEG:
					onView(withId(R.id.negBTN)).perform(click());
					break;
				case EQUALS:
					onView(withId(R.id.evalBTN)).perform(click());
					break;
				case LEFTPAR:
					onView(withId(R.id.openParenBTN)).perform(click());
					break;
				case RIGHTPAR:
					onView(withId(R.id.closeParenBTN)).perform(click());
					break;
				case CLEAR:
					onView(withId(R.id.clearBTN)).perform(click());
					break;
			}
		}
	}

	@Test
	public void negateButtonFOUR() throws Exception {
		onViewChain(LEFTPAR, ONE, PLUS, TWO, RIGHTPAR, NEG, EQUALS);
		Double ans = -3.0;
		assertEquals(ans, activityTestRule.getActivity().currTok.getNumVal());
	}
}

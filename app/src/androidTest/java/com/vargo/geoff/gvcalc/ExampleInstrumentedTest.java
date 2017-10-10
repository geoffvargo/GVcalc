package com.vargo.geoff.gvcalc;

import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

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
}

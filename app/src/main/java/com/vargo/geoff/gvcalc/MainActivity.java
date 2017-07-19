package com.vargo.geoff.gvcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends Activity implements View.OnClickListener {

	protected static Stack<Double> numStack = new Stack<>();
	protected static Stack<Character> opStack = new Stack<>();

	protected String tempStr = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
	}

	public void numBtnHandler(View v, char num) {

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.zeroBTN:
				tempStr = tempStr.concat("0");
				((TextView)findViewById(R.id.dispTXT)).setText(tempStr);
				break;
			case R.id.oneBTN:
				tempStr = tempStr.concat("1");
				break;
			case R.id.twoBTN:
				tempStr = tempStr.concat("2");
				break;
			case R.id.threeBTN:
				tempStr = tempStr.concat("3");
				break;
			case R.id.fourBTN:
				tempStr = tempStr.concat("4");
				break;
			case R.id.fiveBTN:
				tempStr = tempStr.concat("5");
				break;
			case R.id.sixBTN:
				tempStr = tempStr.concat("6");
				break;
			case R.id.sevenBTN:
				tempStr = tempStr.concat("7");
				break;
			case R.id.eightBTN:
				tempStr = tempStr.concat("8");
				break;
			case R.id.nineBTN:
				tempStr = tempStr.concat("9");
				break;
		}
	}
}

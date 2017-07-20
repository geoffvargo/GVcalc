package com.vargo.geoff.gvcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends Activity {

	protected static Stack<Double> numStack = new Stack<>();
	protected static Stack<Character> opStack = new Stack<>();

	protected String tempStr = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
	}

	public void onNumClick(View view) {
		switch (view.getId()) {
			case R.id.zeroBTN:
				tempStr = tempStr.concat("0");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length())));
				break;
			case R.id.oneBTN:
				tempStr = tempStr.concat("1");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.twoBTN:
				tempStr = tempStr.concat("2");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.threeBTN:
				tempStr = tempStr.concat("3");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.fourBTN:
				tempStr = tempStr.concat("4");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.fiveBTN:
				tempStr = tempStr.concat("5");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.sixBTN:
				tempStr = tempStr.concat("6");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.sevenBTN:
				tempStr = tempStr.concat("7");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.eightBTN:
				tempStr = tempStr.concat("8");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.nineBTN:
				tempStr = tempStr.concat("9");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
		}
	}

	public void onOprClick(View v) {
		if (!tempStr.isEmpty()) {
			numStack.push(Double.valueOf(tempStr));
			tempStr = "";
			switch (v.getId()) {
				case R.id.divBTN:
					((TextView) findViewById(R.id.dispTXT)).append(((Button)findViewById(R.id.divBTN)).getText());
					break;
			}
		}
	}
}


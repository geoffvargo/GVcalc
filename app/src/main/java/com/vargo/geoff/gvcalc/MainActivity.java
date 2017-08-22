package com.vargo.geoff.gvcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Stack;

import static com.vargo.geoff.gvcalc.Type.LEFT_PAREN;
import static com.vargo.geoff.gvcalc.Type.NUM;
import static com.vargo.geoff.gvcalc.Type.OP;
import static com.vargo.geoff.gvcalc.Type.RIGHT_PAREN;


public class MainActivity extends Activity {

	protected static Stack<Token> numStack = new Stack<>();
	protected static Stack<Token> opStack = new Stack<>();

	public ArrayDeque<Token> tokens = new ArrayDeque<>();

	protected String tempStr = "";
	protected Token currTok = new TokenBuilder().createToken();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
	}

	public void onNumClick(View view) {
		if (!currTok.isNum() && !currTok.isEmpty()) {
			tokens.push(currTok);
			currTok = new TokenBuilder().setType(NUM).createToken();
		} else if (currTok.isEmpty()) {
			currTok.setType(NUM);
		}
		switch (view.getId()) {
			case R.id.zeroBTN:
				tempStr = tempStr.concat("0");
				currTok.concat("0");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length())));
				break;
			case R.id.oneBTN:
				tempStr = tempStr.concat("1");
				currTok.concat("1");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.twoBTN:
				tempStr = tempStr.concat("2");
				currTok.concat("2");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.threeBTN:
				tempStr = tempStr.concat("3");
				currTok.concat("3");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.fourBTN:
				tempStr = tempStr.concat("4");
				currTok.concat("4");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.fiveBTN:
				tempStr = tempStr.concat("5");
				currTok.concat("5");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.sixBTN:
				tempStr = tempStr.concat("6");
				currTok.concat("6");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.sevenBTN:
				tempStr = tempStr.concat("7");
				currTok.concat("7");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.eightBTN:
				tempStr = tempStr.concat("8");
				currTok.concat("8");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
			case R.id.nineBTN:
				tempStr = tempStr.concat("9");
				currTok.concat("9");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
				break;
		}
	}

	public void onOprClick(View v) {
		if (!tempStr.isEmpty()) {
			tempStr = "";
			Button curr = findViewById(v.getId());
			if (!currTok.isOperator() && !currTok.isEmpty()) {
				tokens.push(currTok);
				currTok = new TokenBuilder().setType(OP).createToken();
			} else if (currTok.isEmpty()) {
				currTok.setType(OP);
			}
			switch (v.getId()) {
				case R.id.plusBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
					break;
				case R.id.minusBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
					break;
				case R.id.multiplyBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
					break;
				case R.id.divBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
					break;
			}
		}
	}

	public void onLeftParenClick(View v) {
		if (!currTok.isLeftParen() && !currTok.isEmpty()) {
			tokens.push(currTok);
			currTok = new TokenBuilder().setType(LEFT_PAREN).createToken();
		} else if (currTok.isEmpty()) {
			currTok.setType(LEFT_PAREN);
		}
		tempStr = tempStr.concat("(");
		((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
		currTok.setValue("(");
	}

	public void onRightParenClick(View v) {
		if (!currTok.isRightParen() && !currTok.isEmpty()) {
			tokens.push(currTok);
			currTok = new TokenBuilder().setType(RIGHT_PAREN).createToken();
		} else if (currTok.isEmpty()) {
			currTok.setType(RIGHT_PAREN);
		}
		tempStr = tempStr.concat(")");
		((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
		currTok.setValue(")");
	}

	public void onEvalClick(View v) {

	}

	public boolean opPrec(Token op1, Token op2) throws Exception {
		if (!op1.isOperator() || !op2.isOperator()) {
			throw new Exception("invalid input");
		}

		if (op1.getValue().matches("\\(") || op2.getValue().matches("\\)")) {
			return false;
		} else if ((op1.getValue().matches("\\\\") || op1.getValue().matches("\\*")) && (op2.getValue().matches("\\+") || op2.getValue().matches("-"))) {
			return false;
		} else {
			return true;
		}
	}

	public Token calc(ArrayDeque<Token> tokenList) {
		Token ans = new TokenBuilder().createToken();

		while (!tokenList.isEmpty()) {
			Token token = tokenList.removeLast();
			switch (token.getType()) {
				case NUM:
					numStack.push(token);
					break;
				case VAR:
					break;
				case OP:
					opStack.push(token);
					break;
				case LEFT_PAREN:
					opStack.push(token);
					break;
				case RIGHT_PAREN:
					while (!opStack.peek().isLeftParen()) {
						Token op = opStack.pop();
						Token num1 = numStack.pop();
						Token num2 = numStack.pop();
						Token result = eval(op, num1, num2);
						numStack.push(result);
					}
					opStack.pop();
					break;
				case EMPTY:
					break;
			}
		}
		while (!opStack.isEmpty()) {
			Token op = opStack.pop();
			Token num1 = numStack.pop();
			Token num2 = numStack.pop();
			Token result = eval(op, num1, num2);
			numStack.push(result);
		}
		ans = numStack.pop();
		return ans;
	}

	public Token eval(Token op, Token num1, Token num2) throws IllegalArgumentException {
		Token ans = new TokenBuilder().setType(NUM).createToken();
		double val1 = Double.valueOf(num1.getValue());
		double val2 = Double.valueOf(num2.getValue());

		String opVal = op.getValue();
		switch (opVal) {
			case "-":
				ans.setValue(String.valueOf(val1 - val2));
				return ans;
			case "+":
				ans.setValue(String.valueOf(val1 + val2));
				return ans;
			case "÷":
				if (val2 == 0.0) {
					throw new IllegalArgumentException();
				}
				ans.setValue(String.valueOf(val1 / val2));
				return ans;
			case "×":
				ans.setValue(String.valueOf(val1 * val2));
				return ans;

		}

		return ans;
	}


}


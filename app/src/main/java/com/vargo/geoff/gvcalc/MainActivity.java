package com.vargo.geoff.gvcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.vargo.geoff.gvcalc.view.MathJaxWebView;

import java.math.BigDecimal;
import java.util.ArrayDeque;

import static com.vargo.geoff.gvcalc.R.id.formula_one;
import static com.vargo.geoff.gvcalc.Type.EMPTY;
import static com.vargo.geoff.gvcalc.Type.LEFT_PAREN;
import static com.vargo.geoff.gvcalc.Type.NUM;
import static com.vargo.geoff.gvcalc.Type.OP;
import static com.vargo.geoff.gvcalc.Type.RIGHT_PAREN;

public class MainActivity extends Activity {

	private static final String DIV = "÷";
	private static final String MULT = "×";
	private static final String LPAREN = "(";
	private static final String RPARN = ")";
	protected static ArrayDeque<Token> numStack = new ArrayDeque<>();
	protected static ArrayDeque<Token> opStack = new ArrayDeque<>();
	public ArrayDeque<Token> tokens = new ArrayDeque<>();
	public TokenBuilder tokenBuilder = new TokenBuilder();
	protected int currIndex = 0;
	protected String tempStr = "";
	protected String latexStr = "";
	protected Token currTok = new TokenBuilder().setType(EMPTY).setValue("").createToken();
	MathJaxWebView renderDisp;
	String tex = " \\(ax^2 + bx + c = 0\\) " +
				 "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		renderDisp = findViewById(R.id.formula_one);
		renderDisp.getSettings().setJavaScriptEnabled(true);
		renderDisp.setText(tex);
/*		renderDisp = findViewById(R.id.formula_one);
		renderDisp.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent m) {
//				m.get
//				formula_one.evaluateJavascript("(function(){return window.getSelection().toString()})()",
//											   new ValueCallback<String>()
//											   {
//												   @Override
//												   public void onReceiveValue(String value)
//												   {
//													   Log.v(TAG, "SELECTION:" + value);
//												   }
//											   });

				return false;
			}
		});*/
	}

	public void onNumClick(View view) {
		renderDisp = findViewById(formula_one);
		renderDisp.setText(tex);
		if (!currTok.isNum() && !currTok.isEmpty()) {
			tokens.add(currTok);
			currTok = new TokenBuilder().setType(NUM).createToken();
		} else if (currTok.isEmpty()) {
			currTok.setType(NUM);
		}
		TextView display = (TextView) findViewById(R.id.dispTXT);
		switch (view.getId()) {
			case R.id.zeroBTN:
				tempStr = tempStr.concat("0");
				currTok.concat("0");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.oneBTN:
				tempStr = tempStr.concat("1");
				currTok.concat("1");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.twoBTN:
				tempStr = tempStr.concat("2");
				currTok.concat("2");
				((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();

				break;
			case R.id.threeBTN:
				tempStr = tempStr.concat("3");
				currTok.concat("3");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.fourBTN:
				tempStr = tempStr.concat("4");
				currTok.concat("4");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.fiveBTN:
				tempStr = tempStr.concat("5");
				currTok.concat("5");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.sixBTN:
				tempStr = tempStr.concat("6");
				currTok.concat("6");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.sevenBTN:
				tempStr = tempStr.concat("7");
				currTok.concat("7");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.eightBTN:
				tempStr = tempStr.concat("8");
				currTok.concat("8");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
			case R.id.nineBTN:
				tempStr = tempStr.concat("9");
				currTok.concat("9");
				display.append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//				updateDisplay();
				break;
		}
	}

	public void updateDisplay() {
//		WebView w = (WebView) findViewById(R.id.mathDISP);
//
//		for (Iterator<Token> iterator = tokens.iterator(); iterator.hasNext(); ) {
//			Token t = iterator.next();
//			latexStr.concat(t.getLatex() + " ");
//		}
//
//		w.loadUrl("javascript:document.getElementById('math').innerHTML='<math xmlns=\"http://www.w3.org/1998/Math/MathML\">"
//				  + "<mstyle displaystyle=\"true\">"
//				  + latexStr
//				  + "</mstyle></math>';");
//		w.loadUrl("javascript:MathJax.Hub.Queue(['Typeset',MathJax.Hub]);");
		renderDisp = findViewById(formula_one);
//		formula_one.config(
//				"MathJax.Hub.Config({\n"+
//				"  CommonHTML: { linebreaks: { automatic: true } },\n"+
//				"  \"HTML-CSS\": { linebreaks: { automatic: true } },\n"+
//				"         SVG: { linebreaks: { automatic: true } }\n"+
//				"});");
		renderDisp.setText(tex);
	}

	public void onRenderClick(View v) {
		int x = 1;
		x += 1;
	}

	public void onOprClick(View v) {
		if (!tempStr.isEmpty()) {
			tempStr = "";
			Button curr = findViewById(v.getId());
			if (!currTok.isOperator() && !currTok.isEmpty()) {
				currTok.setOrdinal(currIndex);
				currIndex++;
				if (tokens.isEmpty() || tokens.peekLast().isOperator()) {
					tokens.add(currTok);
				}
				currTok = new TokenBuilder().setType(OP).setValue("").createToken();
			} else if (currTok.isEmpty()) {
				currTok.setType(OP);
			}
			switch (v.getId()) {
				case R.id.plusBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
//					updateDisplay();
					break;
				case R.id.minusBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
//					updateDisplay();
					break;
				case R.id.multiplyBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
//					updateDisplay();
					break;
				case R.id.divBTN:
					((TextView) findViewById(R.id.dispTXT)).append(curr.getText());
					currTok.concat(String.valueOf(curr.getText()));
//					updateDisplay();
					break;
			}
		}
	}

	public void onLeftParenClick(View v) {
		if (!currTok.isLeftParen() && !currTok.isEmpty()) {
			tokens.add(currTok);
			currTok = new TokenBuilder().setType(LEFT_PAREN).createToken();
		} else if (currTok.isEmpty()) {
			currTok.setType(LEFT_PAREN);
		}
		tempStr = tempStr.concat("(");
		((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
		currTok.setValue("(");
//		updateDisplay();
	}

	public void onRightParenClick(View v) {
		if (!currTok.isRightParen() && !currTok.isEmpty()) {
			tokens.add(currTok);
			currTok = new TokenBuilder().setType(RIGHT_PAREN).createToken();
		} else if (currTok.isEmpty()) {
			currTok.setType(RIGHT_PAREN);
		}
		tempStr = tempStr.concat(")");
		((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//		updateDisplay();
		currTok.setValue(")");
	}

	public void onEvalClick(View v) {
		if (!currTok.isEmpty() && !tokens.isEmpty()) {
			tokens.add(currTok);
			currTok = calc(tokens);
			((TextView) findViewById(R.id.dispTXT)).setText(String.valueOf(currTok.getValue()));
			tokens.clear();
			tokens.add(currTok);
		}
		else if (!currTok.isEmpty()) {
			currTok = parseNeg(currTok);
		}
	}

	private Token parseNeg(Token token) {
		if (token.getNegative()) {
			BigDecimal val = BigDecimal.valueOf(Double.valueOf(token.getValue()));
			val = val.negate();
			token.setNegative(false);
			token.setNumVal(val.doubleValue());
		}

		return token;
	}

	public Token calc(ArrayDeque<Token> tokenList) {
		Token ans = new TokenBuilder().createToken();

		while (!tokenList.isEmpty()) {
			Token token = tokenList.remove();
			switch (token.getType()) {
				case NUM:
					numStack.push(token);
					break;
				case VAR:
					break;
				case LEFT_PAREN:
					if (!numStack.isEmpty() && tokenList.peek().isNum() && (opStack.size() < numStack.size())) {
						opStack.push(tokenBuilder.setType(OP).setValue(MULT).createToken());
						opStack.push(token);
						break;
					} else {
						opStack.push(token);
						break;
					}
				case OP:
					try {
						while (!opStack.isEmpty() && opPrec(token, opStack.peek())) {
							Token op = opStack.pop();
							Token num2 = numStack.pop();
							Token num1 = numStack.pop();
							Token result = eval(op, num1, num2);
							numStack.push(result);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					opStack.push(token);
					break;
				case RIGHT_PAREN:
					while ((opStack.isEmpty() || !opStack.peek().isLeftParen()) && numStack.size() >= 2) {
						Token op = opStack.pop();
						Token num2 = numStack.pop();
						Token num1 = numStack.pop();
						Token result = eval(op, num1, num2);
						numStack.push(result);
					}
					opStack.pop();
					break;
				case EMPTY:
					break;
			}
		}
		while (!opStack.isEmpty() && numStack.size() >= 2) {
			Token op = opStack.pop();
			Token num2 = numStack.pop();
			Token num1 = numStack.pop();
			Token result = eval(op, num1, num2);
			numStack.push(result);
		}
		ans = numStack.pop();
		return ans;
	}

	public boolean opPrec(Token op1, Token op2) {
		if (!op1.isOperator() || !op2.isOperator()) {
			return false;
		} else if (op2.getValue().matches("\\(") || op2.getValue().matches("\\)")) {
			return false;
		} else if ((op1.getValue().matches(DIV) || op1.getValue().matches(MULT)) && (op2.getValue().matches("\\+") || op2.getValue().matches("-"))) {
			return false;
		} else {
			return true;
		}
	}

	public Token eval(Token op, Token num1, Token num2) throws IllegalArgumentException {
		Token ans = new TokenBuilder().setType(NUM).createToken();

		BigDecimal val1;
		if (!num1.getNegative()) {
			val1 = BigDecimal.valueOf(Double.valueOf(num1.getValue()));
		} else {
			val1 = BigDecimal.valueOf(Double.valueOf(num1.getValue()));
			val1 = val1.negate();
		}

		BigDecimal val2;
		if (!num2.getNegative()) {
			val2 = BigDecimal.valueOf(Double.valueOf(num2.getValue()));
		} else {
			val2 = BigDecimal.valueOf(Double.valueOf(num2.getValue()));
			val2.negate();
		}

		String opVal = op.getValue();
		switch (opVal) {
			case "-":
				ans.setValue(val1.subtract(val2).toPlainString());
				return ans;
			case "+":
				ans.setValue(val1.add(val2).toPlainString());
				return ans;
			case "÷":
				if (val2.doubleValue() == 0.0) {
					throw new IllegalArgumentException();
				}
				ans.setValue(val1.divide(val2).toPlainString());
				return ans;
			case "×":
				ans.setValue(val1.multiply(val2).toPlainString());
				return ans;

		}

		return ans;
	}

	public void onClearClick(View v) {
		tokens.clear();
		currTok = new TokenBuilder().createToken();
		((TextView) findViewById(R.id.dispTXT)).setText("");
//		updateDisplay();
	}

	public void onPointClick(View v) {
		if (tempStr.isEmpty() || currTok.isEmpty()) {
			if (tempStr.isEmpty()) {
				tempStr = tempStr.concat("0.");
				if (currTok.isEmpty()) {
					currTok.setType(NUM);
				}
				currTok.setValue("0");
				currTok.setIsFractional(true);

			} else if (currTok.isEmpty()) {
				currTok.setType(NUM);
				currTok.setValue("0.");
			}
			((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//			updateDisplay();
		} else {
			tempStr = tempStr.concat(".");
			currTok.setIsFractional(true);
//			currTok.concat(".0");
			((TextView) findViewById(R.id.dispTXT)).append(String.valueOf(tempStr.charAt(tempStr.length() - 1)));
//			updateDisplay();
		}
	}

	public void onNegClick(View v) {
		if (!tempStr.isEmpty() && !currTok.isEmpty() && currTok.isNum()) {
			tempStr = "-" + tempStr;
			if (!currTok.getNegative()) {
				currTok.setNegative(true);
			} else {
				currTok.setNegative(false);
			}
		}
	}

}


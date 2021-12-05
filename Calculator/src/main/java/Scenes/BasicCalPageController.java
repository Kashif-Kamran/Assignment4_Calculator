package Scenes;

import Code.Calculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BasicCalPageController
{
	@FXML
	private Label lebalNum1;
	@FXML
	private Label lebalNum2;
	@FXML
	private Label lebalOperator;
	@FXML
	private Label lebalResult;

	//
	private String operator = "";
	private String strNum1 = "0";
	private String strNum2 = "0";
	private boolean operatorPressed = false;

	// For Getting Numbers from FXML
	public void getNumbers(ActionEvent event)
	{
		String value = ((Button) event.getSource()).getText(); // reading text from button
		System.out.println(value);
		if (!operatorPressed)
		{
			lebalOperator.setText("");
			lebalResult.setText("");
			strNum1 = lebalNum1.getText() + value;
			lebalNum1.setText(strNum1);
		} else
		{
			strNum2 = lebalNum2.getText() + value;
			lebalNum2.setText(strNum2);
		}
	}

	public void allClear(ActionEvent event)
	{
		operatorPressed = false;
		strNum1 = "0";
		strNum2 = "0";
		lebalNum1.setText("0");
		lebalNum2.setText("0");
		lebalResult.setText("0");
	}

	public String removeLastChar(String str)
	{
		if (str != null && str.length() > 0)
		{
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public void getBackspace(ActionEvent event)
	{
		if (!operatorPressed)
		{
			strNum1 = this.removeLastChar(strNum1);
			lebalNum1.setText(strNum1);
		} else
		{
			strNum2 = this.removeLastChar(strNum2);
			lebalNum2.setText(strNum2);
		}
	}

	// For Getting Operators From FXML
	public void getEqualOperator(ActionEvent event) throws Exception
	{
		Calculator cal = new Calculator();
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		System.out.println(num1 + "\t " + num2);
		double result = cal.Calculation(num1, operator, num2);
		lebalResult.setText(String.valueOf(result));
		operatorPressed = false;
		strNum1 = "0";
		strNum2 = "0";
		lebalNum1.setText("0");
		lebalNum2.setText("0");
	}

	public void getCalculationOperator(ActionEvent event)
	{
		if (operatorPressed)
			return;
		else
		{
			String value = ((Button) event.getSource()).getText();
			operator = value;
			lebalOperator.setText(operator);
			System.out.println(value);
			operatorPressed = true;
		}
	}
}

package Scenes;

import Code.Calculator;
import Code.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DiscountController
{
	Calculator cal = new Calculator();
	@FXML
	private Label lebalTotalPrice;
	@FXML
	private Label lebalDiscount;
	@FXML
	private Label lebalFinalPrice;

	int pressedState = 0;
	String totalPrice;
	String discount;

	public void allClear(ActionEvent event)
	{
		lebalTotalPrice.setText("");
		lebalFinalPrice.setText("");
		lebalDiscount.setText("");
		pressedState = 0;
	}

	public void getNumbers(ActionEvent event)
	{
		String value;
		value = ((Button) event.getSource()).getText(); // reading text from button

		System.out.println(value);
		if (pressedState == 0)
		{
			lebalDiscount.setText("");
			lebalFinalPrice.setText("");
			totalPrice = lebalTotalPrice.getText() + value;
			lebalTotalPrice.setText(totalPrice);
		} else if (pressedState == 1)
		{
			discount = lebalDiscount.getText() + value;
			lebalDiscount.setText(discount);
		}
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
		if (pressedState == 0)
		{
			totalPrice = this.removeLastChar(totalPrice);
			lebalTotalPrice.setText(totalPrice);
		} else if (pressedState == 1)
		{
			discount = this.removeLastChar(discount);
			lebalDiscount.setText(discount);
		}
	}

	public void getEqualOperator()
	{
		if (pressedState == 0)
		{
			pressedState++;
		} else if (pressedState == 1)
		{
			System.out.println("Calculate");
			double resultValue = cal.getRemainingPriceDiscount(Double.parseDouble(totalPrice),
					Double.parseDouble(discount));
			lebalFinalPrice.setText(Double.toString(resultValue));
			pressedState = 3;
		}
	}

	public void backButton()
	{

		Main main = new Main();
		try
		{
			main.changeScene("/Scenes/ManuPage.fxml");
		} catch (Exception exc)
		{
			System.out.println("Page Not Found");
		}
	}
}

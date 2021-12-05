package Scenes;

import java.net.URL;
import java.util.ResourceBundle;

import Code.Calculator;
import Code.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InvestmentPageController implements Initializable
{
	@FXML
	private TextField totalInvestment;
	@FXML
	private TextField interestPercentage;
	@FXML
	private ComboBox duration;
	@FXML
	private Label totalInvestmentError;
	@FXML
	private Label interestPercentageError;
	@FXML
	private Label durationError;
	@FXML
	private Label totalValue;
	@FXML
	private Label totalInterest;

	Calculator cal = new Calculator();

	public void initialize(URL url, ResourceBundle rb)
	{
		ObservableList list = FXCollections.observableList(cal.getInvestmentDurationList());
		duration.getItems().clear();
		duration.setItems(list);
	}

	public boolean invalidInput(String data) throws Exception
	{
		if (data == null)
		{
			throw new NullPointerException("This feild Cannot Be Empty");
		} else if (data.isEmpty())
		{
			throw new IllegalArgumentException("This Feild Cannot Be Empty");
		} else if (data.matches("[0-9]+"))
		{
			return true;
		} else
		{
			throw new IllegalArgumentException("Please Enter Numeric Values");
		}
	}

	public boolean CheckInputValidation(String invest, String percent, String option)
	{
		boolean check = true;
		try
		{
			invalidInput(invest);
			totalInvestmentError.setText("");
			check = true;
		} catch (Exception exc)
		{
			System.out.println("This should be called A");
			totalInvestmentError.setText(exc.getMessage());
			check = false;
		}

		try
		{
			invalidInput(percent);
			interestPercentageError.setText("");
			check = true;
		} catch (Exception exc)
		{
			System.out.println("This should be called B");
			interestPercentageError.setText(exc.getMessage());
			check = false;
		}
		if (option == null || option.isEmpty())
		{
			durationError.setText("This feild cannot be Empty");
			check = false;

		} else
		{
			durationError.setText("");
			check = true;
		}
		return check;

	}

	public void getInvestmentData(ActionEvent event)
	{
		String invest = totalInvestment.getText();
		String percent = interestPercentage.getText();
		String durationOption = (String) duration.getValue();
		if (CheckInputValidation(invest, percent, durationOption))
		{
			double inv = Double.parseDouble(invest);
			double perc = Double.parseDouble(percent);
			String tInv = Double.toString(cal.CalculateInvestment(inv, perc, durationOption));
			String tInt = Double.toString(cal.CalculateInterest(inv, perc, durationOption));
			totalValue.setText(tInv);
			totalInterest.setText(tInt);
		}
	}

	public void BackToCurrency(ActionEvent event)
	{
		Main main = new Main();
		try
		{
			main.changeScene("/Scenes/CurrencyPage.fxml");
		} catch (Exception exc)
		{
			System.out.println("Page Not Found");
		}
	}
}

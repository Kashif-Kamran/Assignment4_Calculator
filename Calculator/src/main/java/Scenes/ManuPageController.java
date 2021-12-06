package Scenes;

import Code.Main;
import javafx.event.ActionEvent;

public class ManuPageController
{
	// Functions for switching scenes
	public void SwitchToCurrency(ActionEvent event)
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

	public void SwitchToCalculator(ActionEvent event)
	{
		Main main = new Main();
		try
		{
			main.changeScene("/Scenes/BasicCalPage.fxml");
		} catch (Exception exc)
		{
			System.out.println("Page Not Found");
		}
	}

	public void SwitchToDiscount(ActionEvent event)
	{
		Main main = new Main();
		try
		{
			main.changeScene("/Scenes/DiscountPage.fxml");
		} catch (Exception exc)
		{
			System.out.println("Page Not Found " + exc);
		}
	}
}

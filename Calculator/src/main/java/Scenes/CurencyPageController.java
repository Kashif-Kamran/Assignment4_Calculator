package Scenes;

import Code.Main;
import javafx.event.ActionEvent;

public class CurencyPageController
{

	public void SwitchToManu(ActionEvent event)
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

	public void SwitchToInvestment(ActionEvent event)
	{
		Main main = new Main();
		try
		{
			main.changeScene("/Scenes/InvestPage.fxml");
		} catch (Exception exc)
		{
			System.out.println("Page Not Found" + exc);
		}
	}
}

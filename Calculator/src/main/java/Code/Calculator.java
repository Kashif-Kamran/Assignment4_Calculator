package Code;

import java.util.LinkedList;

public class Calculator
{
	private LinkedList<String> investDurationOptions;

	public Calculator()
	{
		investDurationOptions = new LinkedList<String>();
		investDurationOptions.add("1 Year");
		investDurationOptions.add("2 Year");
		investDurationOptions.add("3 Year");
		investDurationOptions.add("4 Year");
	}

	public double Calculation(double num1, String operator, double num2) throws Exception
	{
		double result = 0;
		if (operator.compareTo("+") == 0)
		{
			result = num1 + num2;
		} else if (operator.compareTo("-") == 0)
		{
			result = num1 - num2;

		} else if (operator.compareTo("*") == 0)
		{
			result = num1 * num2;
		} else if (operator.compareTo("/") == 0)
		{
			result = num1 / num2;
		} else if (operator.compareTo("%") == 0)
		{
			result = num1 % num2;
		}
		return result;
	}

	public LinkedList getInvestmentDurationList()
	{
		return investDurationOptions;
	}

	public int checkDuration(String str)
	{
		if (str.compareTo("1 Year") == 0)
		{
			return 1;
		} else if (str.compareTo("2 Year") == 0)
		{
			return 2;
		} else if (str.compareTo("3 Year") == 0)
		{
			return 3;
		} else if (str.compareTo("4 Year") == 0)
		{
			return 4;
		}
		return 1;
	}

	public double CalculateInterest(double invest, double percentage, String duration)
	{
		int dur = checkDuration(duration);
		double result = invest / 100;
		result = result * percentage;
		result = result * dur;
		return result;
	}

	public double CalculateInvestment(double invest, double percentage, String duration)
	{
		double result = 0;
		double dur = checkDuration(duration);
		double interest = CalculateInterest(invest, percentage, duration);
		result = (invest * dur) + interest;
		return result;
	}

}

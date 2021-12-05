package Code;

public class Calculator
{
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

	public static void main(String arg[])
	{

	}
}

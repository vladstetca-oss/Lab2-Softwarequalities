package com.ontariotechu.sofe3980U;

public class Binary
{
	private String number="0";
	
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0";
			return;
		}
	
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0";
				return;
			}
		}
	
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}
	
	public String getValue()
	{
		return this.number;
	}
	
	public static Binary or(Binary num1, Binary num2)
	{
	    int i = num1.number.length() - 1;
	    int j = num2.number.length() - 1;
	    String result = "";
	    while (i >= 0 || j >= 0)
	    {
	        char b1 = (i >= 0) ? num1.number.charAt(i) : '0';
	        char b2 = (j >= 0) ? num2.number.charAt(j) : '0';
	        result = ((b1 == '1' || b2 == '1') ? "1" : "0") + result;
	        i--;
	        j--;
	    }
	    return new Binary(result);
	}
	
	public static Binary multiply(Binary num1, Binary num2)
	{
	    Binary result = new Binary("0");
	    int shift = 0;
	    for (int i = num2.number.length() - 1; i >= 0; i--)
	    {
	        if (num2.number.charAt(i) == '1')
	        {
	            String shiftedValue = num1.number;
	            for (int k = 0; k < shift; k++)
	            {
	                shiftedValue += "0";
	            }
	            result = add(result, new Binary(shiftedValue));
	        }
	        shift++;
	    }
	    return result;
	}
	
	public static Binary and(Binary num1, Binary num2)
	{
	    int i = num1.number.length() - 1;
	    int j = num2.number.length() - 1;
	    String result = "";
	    while (i >= 0 || j >= 0)
	    {
	        char b1 = (i >= 0) ? num1.number.charAt(i) : '0';
	        char b2 = (j >= 0) ? num2.number.charAt(j) : '0';
	        result = ((b1 == '1' && b2 == '1') ? "1" : "0") + result;
	        i--;
	        j--;
	    }
	    return new Binary(result);
	}
	
	public static Binary add(Binary num1,Binary num2)
	{
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		int carry=0;
		String num3="";
		while(ind1>=0 ||  ind2>=0 || carry!=0)
		{
			int sum=carry;
			if(ind1>=0){
				sum += (num1.number.charAt(ind1)=='1')? 1:0;
				ind1--;
			}
			if(ind2>=0){
				sum += (num2.number.charAt(ind2)=='1')? 1:0;
				ind2--;
			}
			carry=sum/2;
			sum=sum%2;
			num3 =( (sum==0)? "0":"1")+num3;
		}
		Binary result=new Binary(num3);
		return result;
	}
}


public class CP_5 {
	
	//5.2
	public static String toBinary (String num)
	{
		StringBuffer holder = new StringBuffer(num);
		
		String intPart = holder.substring(0, holder.indexOf("."));
		String decPart = holder.substring(holder.indexOf("."), holder.length()); 
		
		int intNum = Integer.parseInt(intPart);
		double decNum = Double.parseDouble(decPart);
		
		String intResult = "";
		
		while(intNum > 0 )
		{
			int digit = intNum % 2;
			intNum /= 2;
			intResult = digit + intResult;
		}
		
		StringBuffer decResult = new StringBuffer(".");
		
		while(decNum > 0)
		{
			if(decNum == 1)
			{
				decResult.append("1");
				break;
			}
			
			double temp = decNum * 2;//shift the first of binary after the decimal
			if(temp > 1)
			{
				decResult.append("1");
				temp -= 1;
			}else
			{
				decResult.append("0");
			}
			
			decNum = temp;
		}
		
		return intResult + decResult;
	}

	public static void main(String[] args) {
		
		String result = toBinary("2.33");
		System.out.print(result);
	}

}

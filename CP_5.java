
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
		
		//String result = toBinary("2.33");
		//System.out.print(result);
		
		//5.3 brute force
		int num = 5;
		int target = countOnes(num);
		int above = num + 1;
		while(target != countOnes(above))
		{
			above++;
		}
		System.out.print(above);
	}
	
	public static int countOnes(int num)
	{
		int count = 0;
		int marsk = 1;
		
		for(int i = 0; i < 32; i++)
		{
			if(!((num & marsk) == 0))
			{
				count++;
			}
			
			marsk = marsk << 1;
		}
		
		return count;
	}

}

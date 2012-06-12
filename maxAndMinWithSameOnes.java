//5.3

//////////////////////////////////////////////////////////////////////////////////
// GET_NEXT
//         from the least significant digit find the first bit-1 (pos: i), and then 
//        the bit-0 (pos: j), exchange w(j) and w(j-1), finally right shifting the 
//        bit-1 to the rightmost positions
//
// GET_PREV
//        similar to GET_NEXT, return the "next smallest number that have the same
//        number of 1 bits in binary expression"
//
// PROOF-OF-NEXT-SMALLEST
// 1.        once we find the 'first bit-0 (pos: j)', and the modified number is 
//        2^j - 2^(j-1) bigger than the original one
// 2.        restricted to the rule -- the next largest number have the same number of
//        1 bits in their binary representation, right shifting all the bit-1 to the
//        corner helps remain the "smallest" attribute
// 3.        finally, the result is up to 2^j - 2^(j-1) bigger than the original number
//////////////////////////////////////////////////////////////////////////////////

public class maxAndMinWithSameOnes {
	private int num;
	
	public maxAndMinWithSameOnes (int x)
	{
		//initialize
		num = x;
	}
	
	//start from the rightmost with 0, and get the nth digit of
	//the binary representation of the number
	private int getNthDigit(int n ,int index)
	{
		int marsk = 1 << index;//move the 1 to the position
		return n & marsk;
	}
	
	private void setTheDigit (int n, int index, boolean isOn)
	{
		int marsk = 1 << index;
		
		if(isOn)
		{
			n = n | marsk;
		}
		else
		{
			n = n & (~marsk);
		}
	}
	
	public int NP_Max()
	{
		int temp = num;
		int index = 0;
		int countOne = 0;
		//reach the fist 1;
		while(getNthDigit(temp, index) != 1) index++;
		//reach the last 1 before there is a 0;
		while(getNthDigit(temp, index) == 1)
		{
			index++;
			countOne++; 
		}
		//now the point it point to the first 0 after 1;
		//set the 0 to 1;
		setTheDigit(temp, index, true);
		
		//turn off the previous 1;
		index--;
		setTheDigit(temp, index, false);
		
		//then we shift all the 1 on the right side of index
		//to the right, to make the number as small as possible
		
		//set all the previous digit 0
		for (int i = index - 1; i >= 0; i--)
		{
			setTheDigit(temp, index, false);
		}
		
		//set the last digits to 1
		for (int i = countOne; i >= 0; i--)
		{
			setTheDigit(temp, index, true);
		} 
		
		return num;
	}
	
	public int NP_Min()
	{
		int temp = num;
		int index = 0;
		int countZeroes = 0;
		
		//get to the first 0
		while(getNthDigit(temp, index) != 0) index++;
		//reach the last 0 before there is a 1;
		while(getNthDigit(temp, index) == 0)
		{
			index++;
			countZeroes++; 
		}
		
		//now the point it point to the first 1 after 0;
		//set the 1 to 0;
		setTheDigit(temp, index, false);
		
		//turn on the previous 0;
		index--;
		setTheDigit(temp, index, true);
		
		
		//shift all the 1 to the left to make the the number as
		//big as possible
		
		//set all the previous digit 0
		for (int i = index - 1; i >= 0; i--)
		{
			setTheDigit(temp, index, false);
		}
		
		//set number of digits, which is equal to the count of 1, 
		//after the index     
		int numberOfOnes = index - countZeroes;
		
		index--;
		while(numberOfOnes != 0)
		{
			setTheDigit(temp, index,true);
			index--;
			numberOfOnes--;
		}
		//set the 
		return num;
	}
	

}

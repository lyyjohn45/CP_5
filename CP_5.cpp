#include "CP_5.h"
#include <stdio.h>
#include <iostream>
#include <limits>

using namespace std;

void printBinary(const int x)
{
	static char buff[sizeof(int) * CHAR_BIT];//CHAR_BIT = 8
	int bufferIndex = sizeof(int) * CHAR_BIT - 1;//the buffer postion

	//buff[bufferIndex] = 0;//this is the end of the buffer

	for(int i = 0; i < sizeof(int) * CHAR_BIT; i++)
	{
		if ( x & (1<<i))
		{
			buff[bufferIndex] = '1';	
		}else
		{
			buff[bufferIndex] = '0';	
		}

		bufferIndex--;
	}
	
	printf("%s", buff);
	cout<< "" <<endl;
	
}

//5.1
int updateBits (int target, int sub, int leftIndex, int rightIndex)
{
int max = ~0;

//all 1 after right index. ex 0010 => 0001 (index 1)
int right = ((1<<rightIndex) - 1);
//all 1 until left index. ex 0100 =>  1100 (index 2)
int left = max = ((1<<leftIndex) - 1);

int mask = right | left;//left 0 between i and j, others are 1

int shiftedN = sub << leftIndex;//shift n to the postion

return (target & mask) | shiftedN;
}

int main()
{
	cout<< "5.1 bit manipunation" <<endl;
	printBinary(382);
	printBinary(8);

	int result = updateBits(382,8,6,2);
	printBinary(result);
	cin.get();
}
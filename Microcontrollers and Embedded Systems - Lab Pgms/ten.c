#include<LPC21xx.h>
int main()
{
	unsigned long temp=0x00000000;
	unsigned int i;
	IO0DIR=0XFFFFFFFF; //P0.0-P0.31 CONFIGURED AS OUTPUT
	while(1)
		{
			for(i=0;i!=0xFF;i++)
			{
				temp=i;
				temp=temp<<16;
				IO0PIN=temp;
			}
			for(i=0xFF;i!=0;i--)
		{
			temp=i;
			temp=temp<<16;
			IO0PIN=temp;
		}
	}
}
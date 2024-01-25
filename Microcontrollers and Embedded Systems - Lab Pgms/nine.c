#include<LPC21xx.h>
void delay(void);
int main()
{
	PINSEL0=0X00000000; //P0.0-P0.15 AS GPIO
	PINSEL1=0X00000000; //P0.16-P0.31 AS GPIO
	IO0DIR=0XFFFFFFFF; //P0.0-P0.31 CONFIGURED AS OUTPUT
	while(1)
		{
			IO0PIN=0x00000000;//IO0PIN IS USED TO OBTAIN STATUS OF PINS
			delay();
			IO0PIN=0XFFFFFFFF;
			delay();
		}
	}
void delay(void)
{
	unsigned int i;
	for(i=0;i<500;i++);
}
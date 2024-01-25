#include<LPC21xx.h>
void delay(void);
unsigned int count;//this is 16 bit data, but v need only 8 bit data
int main()
{
	unsigned int comp=0;
	PINSEL1=0x00000000;//configure port 0(16-31) as GPIO
	IO0DIR=0xFFFFFFFF;//configure P0.16 to P0.31 as OUTPUT
	while(1)
	{
		for(count=0;count<=0xFF;count++)//since interested in only 8 bit data,only till 255 v need
		{
			comp=(~count);//ensure that after 255, 0 should come...v don't want 256 and so on
			comp=comp & 0x000000FF;//to fetch lower 8 bit data...v don't need upper 8 bits, so they are anded with 0
			IO0PIN=(comp <<16);
			delay();
		}
	}
}
void delay(void)
{
	unsigned int i;
	for(i=0;i<650;i++);
}
	
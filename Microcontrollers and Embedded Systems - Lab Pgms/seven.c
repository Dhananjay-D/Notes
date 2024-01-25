#include<LPC21xx.h>
unsigned int delay;
int main()
{
	PINSEL1=0x00000000; //configure P0.16 to P0.23 as GPIO
	IO0DIR=0xFFFFFFFF; //configure P0.16 to P0.23 as OUTPUT....can also give 0x00FF0000, bcoz we r using only 16-23 pins, make only those high(1/F)
	while(1)
	{
		IO0SET=0x00FF0000; //set pins 16-23 of port 0(P0)
		for(delay=0;delay<100000;delay++);//creates delay for 10000 msec
		IO0CLR=0x00FF0000; //clears pins 16-23 of port 0(P0)
		for(delay=0;delay<100000;delay++);
	}
}
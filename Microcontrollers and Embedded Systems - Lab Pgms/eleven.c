#include <LPC21xx.h>
unsigned int i;
int main()
{
	IO0DIR=0x00000600; //set P0.10 as output
	IO0SET=0x00000600; //P0.10-for relay and P0.09 for buzzer is set to HIGH...turning on the relay
	while(1)
	{
		for(i=0;i<1000000;i++);
		IO0SET=0x00000600; //relay on
		for(i=0;i<1000000;i++);
		IO0CLR=0x00000600; //relay off
	}
}
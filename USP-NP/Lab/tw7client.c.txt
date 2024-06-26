#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 4444

int main() {
	int sockfd;
	struct sockaddr_in servAddr;
	char buffer[1024];

	sockfd = socket(AF_INET, SOCK_STREAM, 0);
	printf("[+] Client socket created successfully!\n");

	bzero(&servAddr, sizeof(servAddr));
	servAddr.sin_family = AF_INET;
	servAddr.sin_port = htons(PORT);
	servAddr.sin_addr.s_addr = inet_addr("127.0.0.1");

	connect(sockfd, (struct sockaddr*) &servAddr, sizeof(servAddr));
	printf("[+] Connected to server! \n");

	recv(sockfd, buffer, 1024, 0);
	printf("[+] Data received from server: %s\n", buffer);
	printf("[-] Closing the connection \n");
	
	return 0;
}

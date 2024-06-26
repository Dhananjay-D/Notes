#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 4444

int main() {
	int listenfd, connfd;
	struct sockaddr_in servAddr, cliAddr;
	socklen_t clilen;
	char buffer[1024];

	listenfd = socket(AF_INET, SOCK_STREAM, 0);
	printf("[+] Server socket created successfully!\n");

	bzero(&servAddr, sizeof(servAddr));
	servAddr.sin_family = AF_INET;
	servAddr.sin_port = htons(PORT);
	servAddr.sin_addr.s_addr = inet_addr("127.0.0.1");

	bind(listenfd, (struct sockaddr*) &servAddr, sizeof(servAddr));
	printf("[+] Listening.. \n");

	connfd = accept(listenfd, (struct sockaddr*) &cliAddr, &clilen);

	strcpy(buffer, "Hello world!");

	send(connfd, buffer, strlen(buffer), 0);
	printf("[+] Data sent to client: %s\n", buffer);

	printf("[-] Closing the connection\n");
	return 0;
}


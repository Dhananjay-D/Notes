# UDP Client side Code

import socket
# Create a UDP socket
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
# Server address and port
server_address = ('localhost', 12345)
while True:
    message = input('Enter a message: ')
    # Send data to the server
    client_socket.sendto(message.encode(), server_address)
# Close the socket (this will never be reached in this example)
client_socket.close()

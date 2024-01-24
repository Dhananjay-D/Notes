# UDP - server side CODE

import socket
# Create a UDP socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
# Bind the socket to an address and port
server_address = ('localhost', 12345)
server_socket.bind(server_address)
print('UDP server is waiting for messages...')
while True:
    # Receive data from the client
    data, client_address = server_socket.recvfrom(1024)
    print(f'Received message from {client_address}: {data.decode()}')
# Close the socket (this will never be reached in this example)
server_socket.close()

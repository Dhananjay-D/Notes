# TCP Server Code
import socket
# Define the server address and port
server_address = ('127.0.0.1', 12345) 
# Create a socket object
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# Bind the socket to the server address and port
server_socket.bind(server_address)
# Listen for incoming connections
server_socket.listen(4)
print("Server is listening for incoming connections...")
# Accept a connection
client_socket, client_address = server_socket.accept()
print(f"Connected to {client_address}")
# Receive data from the client
data = client_socket.recv(1024)
print(f"Received data from client: {data.decode('utf-8')}")
# Send a response to the client
response = "Hello, client!"
client_socket.send(response.encode('utf-8'))
# Close the sockets
client_socket.close()
server_socket.close()
# TCP CLIENT - SERVER

# TCP Client Code 
import socket
# Define the server address and port
server_address = ('127.0.0.1', 12345)
# Create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# Connect to the server
client_socket.connect(server_address)
# Send a message to the server
message = "Hello, server!"
client_socket.send(message.encode('utf-8'))
# Receive a response from the server
data = client_socket.recv(1024)
# print(f"Received response from server: {data.decode('utf-8')}")
print("Recieved response from server: ",data.decode('utf-8'))
# Close the socket
client_socket.close()

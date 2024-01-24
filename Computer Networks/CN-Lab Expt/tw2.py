# RSA Algorithm- for encryption and decrption of message

import random
import math

# 7 functions in total

# Function to check if a number is prime
def is_prime(num):
    if num <= 1:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True


# Function to generate random prime numbers
def generate_prime(bits):
    while True:
        num = random.getrandbits(bits)
        if is_prime(num):
            return num


# Function to compute the greatest common divisor (GCD)
def gcd(a, b):
    while b:
        a, b = b, a % b
    return a


# Function to find the modular multiplicative inverse
def mod_inverse(a, m):
    m0, x0, x1 = m, 0, 1
    while a > 1:
        q = a // m
        m, a = a % m, m
        x0, x1 = x1 - q * x0, x0
    return x1 + m0 if x1 < 0 else x1


# Function to generate RSA key pairs
def generate_key_pair(bits):
    p = generate_prime(bits)
    q = generate_prime(bits)
    n = p * q
    phi = (p - 1) * (q - 1)
    while True:
        e = random.randint(2, phi - 1)
        if gcd(e, phi) == 1:
            break
    d = mod_inverse(e, phi)
    public_key = (n, e)
    private_key = (n, d)
    return public_key, private_key


# Function to encrypt a message
def encrypt(public_key, message):
    n, e = public_key
    cipher_text = [pow(ord(char), e, n) for char in message]
    return cipher_text


# Function to decrypt a message
def decrypt(private_key, cipher_text):
    n, d = private_key
    decrypted_message = ''.join([chr(pow(char, d, n)) for char in cipher_text])
    return decrypted_message


# Main program
if __name__ == "__main__":
    bits = 8  # Adjust the number of bits for your desired security level
    public_key, private_key = generate_key_pair(bits)
    print(
        f" Generated Public Key : {public_key} \n Generated Private Key : {private_key}")
    message = eval(input(" Enter the Message to be Encrypted : "))
    print(" Original message:", message)
    encrypted_message = encrypt(public_key, message)
    print(" Encrypted message:", encrypted_message)
    decrypted_message = decrypt(private_key, encrypted_message)
    print(" Decrypted message:", decrypted_message)

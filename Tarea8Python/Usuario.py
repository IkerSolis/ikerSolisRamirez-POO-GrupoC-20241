import random

class Usuario:
    def __init__(self, nombre=None, edad=None, id=None):
        self.id = id
        self.nombre = nombre
        self.edad = edad

    def get_nombre(self):
        return self.nombre

    def set_nombre(self):
        self.nombre = input("Ingresa tu nombre: ")

    def get_edad(self):
        return self.edad

    def set_edad(self):
        self.edad = int(input("Ingresa tu edad: "))

    def get_id(self):
        return self.id

    def set_id(self):
        self.id = random.randint(1, 1000)

import random

class Libro:
    def __init__(self, name=None, autor=None, id=None, cantidad=None):
        self.id = id
        self.name = name
        self.autor = autor
        self.cantidad = cantidad

    def get_id(self):
        return self.id

    def set_id(self):
        self.id = random.randint(1, 100)

    def get_name(self):
        return self.name

    def set_name(self):
        self.name = input("Ingresa el nombre del libro: ")

    def get_autor(self):
        return self.autor

    def set_autor(self):
        self.autor = input("Ingresa el nombre del autor: ")

    def get_cantidad(self):
        return self.cantidad

    def set_cantidad(self):
        self.cantidad = int(input("Ingrese la cantidad disponible: "))

    def rentar_libro(self):
        if self.cantidad - 1 >= 0:
            self.cantidad -= 1
            print("Cantidad restante:", self.cantidad)
        else:
            print("El libro no se encuentra disponible\n")

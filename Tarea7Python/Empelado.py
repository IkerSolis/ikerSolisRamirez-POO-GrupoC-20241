class Empleado:
    def __init__(self, nombre="", edad=0, salario=0.0, numero_cuenta=0, tipo_cuenta=''):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario
        self.cuenta = None

        if tipo_cuenta.upper() in ['A', 'B', 'C']:
            self.cuenta = CuentaBanco(numero_cuenta, tipo_cuenta)
        else:
            print("Error: Tipo de cuenta inválido")

    def get_nombre(self):
        return self.nombre

    def set_nombre(self):
        self.nombre = input("Ingresa tu nombre: ")

    def get_edad(self):
        return self.edad

    def set_edad(self):
        self.edad = int(input("Ingresa tu edad: "))

    def get_salario(self):
        return self.salario

    def set_salario(self):
        self.salario = float(input("Ingresa tu salario: "))

    def get_cuenta(self):
        return self.cuenta

    def set_cuenta(self, cuenta):
        self.cuenta = cuenta


class CuentaBanco:
    def __init__(self, numero_cuenta=0, tipo_cuenta=''):
        self.numero_cuenta = numero_cuenta
        self.tipo_cuenta = tipo_cuenta

    def get_numero_cuenta(self):
        return self.numero_cuenta

    def get_tipo_cuenta(self):
        return self.tipo_cuenta

    def retiro(self):
        pass

    def deposito(self):
        pass

    def get_saldo_cuenta(self):
        pass

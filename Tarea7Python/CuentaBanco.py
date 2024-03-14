import random

class CuentaBanco:
    def __init__(self, numero_cuenta=0, tipo_cuenta='', saldo_cuenta=0.0):
        self.numero_cuenta = numero_cuenta
        self.tipo_cuenta = tipo_cuenta
        self.saldo_cuenta = saldo_cuenta

    def deposito(self):
        dinero = float(input("Ingresa la cantidad que deseas depositar: "))
        if dinero > 0:
            if self.tipo_cuenta == 'A' and self.saldo_cuenta + dinero <= 50000:
                self.saldo_cuenta += dinero
                print("Se han depositado: $" + str(dinero) + " a la cuenta.")
            elif self.tipo_cuenta == 'B' and self.saldo_cuenta + dinero <= 100000:
                self.saldo_cuenta += dinero
                print("Se han depositado: $" + str(dinero) + " a la cuenta.")
            elif self.tipo_cuenta == 'C':
                self.saldo_cuenta += dinero
                print("Se han depositado: $" + str(dinero) + " a la cuenta.")

    def retiro(self):
        dinero = float(input("Ingresa la cantidad que deseas retirar: "))
        if self.tipo_cuenta == 'A' and self.saldo_cuenta - dinero >= 1000:
            self.saldo_cuenta -= dinero
            print("Se retiraron $" + str(dinero) + " de su cuenta")
            print("Saldo total después del retiro: $" + str(self.saldo_cuenta))
        elif self.tipo_cuenta == 'B' and self.saldo_cuenta - dinero >= 5000:
            self.saldo_cuenta -= dinero
            print("Se retiraron $" + str(dinero) + " de su cuenta")
            print("Saldo total después del retiro: $" + str(self.saldo_cuenta))
        elif self.tipo_cuenta == 'C' and self.saldo_cuenta - dinero >= 10000:
            self.saldo_cuenta -= dinero
            print("Se retiraron $" + str(dinero) + " de su cuenta")
            print("Saldo total después del retiro: $" + str(self.saldo_cuenta))
        else:
            print("No se puede retirar tal cantidad, su cuenta quedaría con saldo menor al que tiene permitido")

    def get_numero_cuenta(self):
        return self.numero_cuenta

    def set_numero_cuenta(self):
        self.numero_cuenta = random.randint(1000, 9999)

    def get_tipo_cuenta(self):
        return self.tipo_cuenta

    def set_tipo_cuenta(self):
        self.tipo_cuenta = input("Ingresa el tipo de cuenta que desea tener: ")

    def get_saldo_cuenta(self):
        print("Este es su saldo: $" + str(self.saldo_cuenta))
        return self.saldo_cuenta

    def set_saldo_cuenta(self):
        self.saldo_cuenta += 1000

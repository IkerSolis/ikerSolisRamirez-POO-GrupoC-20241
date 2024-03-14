class Banco:
    def __init__(self):
        self.empleados = []

    def agregar_empleado(self, empleado):
        self.empleados.append(empleado)

    def mostrar_empleados(self):
        print("Estos son los empleados registrados")
        for empleado in self.empleados:
            print(" ")
            print("Nombre del empleado: " + empleado.get_nombre())
            print("Edad del empleado: " + str(empleado.get_edad()))
            print("Salario registrado: " + str(empleado.get_salario()))
            print("Numero de tu cuenta: " + empleado.get_cuenta().get_numero_cuenta())
            print("Tipo de cuenta seleccionado: " + empleado.get_cuenta().get_tipo_cuenta())
            print(" ")

    def mostrar_empleado(self):
        print("Cuentas registradas: ")
        for x in range(len(self.empleados)):
            print(str(x) + ". " + self.empleados[x].get_nombre())
        print("Empleado que quiera ver: ")
        num_empleado = int(input())
        if 0 <= num_empleado < len(self.empleados):
            print(" ")
            print("Los datos del empleado " + str(num_empleado) + " son: ")
            print("Nombre del titular : " + self.empleados[num_empleado].get_nombre())
            print("Edad del empleado: " + str(self.empleados[num_empleado].get_edad()))
            print("Salario registrado: " + str(self.empleados[num_empleado].get_salario()))
            print("Numero de cuenta: " + self.empleados[num_empleado].get_cuenta().get_numero_cuenta())
            print("Tipo de cuenta: " + self.empleados[num_empleado].get_cuenta().get_tipo_cuenta())
            print(" ")

    def elegir_cuenta_retiro(self):
        print("Cuentas registradas: ")
        for x in range(len(self.empleados)):
            print(str(x) + ". " + self.empleados[x].get_nombre() + " con numero de cuenta: " +
                  self.empleados[x].get_cuenta().get_numero_cuenta())
        print("Elige tu la cuenta para retirar: ")
        cuenta_retiro = int(input())
        if 0 <= cuenta_retiro < len(self.empleados):
            self.empleados[cuenta_retiro].get_cuenta().retiro()

    def elegir_cuenta_deposito(self):
        print("Cuentas registradas: ")
        for x in range(len(self.empleados)):
            print(str(x) + ". " + self.empleados[x].get_nombre() + " con numero de cuenta: " +
                  self.empleados[x].get_cuenta().get_numero_cuenta())
        print("Elige tu la cuenta para depositar: ")
        cuenta_deposito = int(input())
        if 0 <= cuenta_deposito < len(self.empleados):
            self.empleados[cuenta_deposito].get_cuenta().deposito()

    def ver_saldo_cuenta(self):
        print("Cuentas registradas: ")
        for x in range(len(self.empleados)):
            print(str(x) + ". " + self.empleados[x].get_nombre() + " con numero de cuenta: " +
                  self.empleados[x].get_cuenta().get_numero_cuenta())
        print("Elige tu la cuenta para retirar: ")
        cuenta_saldo = int(input())
        if 0 <= cuenta_saldo < len(self.empleados):
            self.empleados[cuenta_saldo].get_cuenta().get_saldo_cuenta()

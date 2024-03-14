class Banco:
    def __init__(self):
        self.empleados = []

    def agregar_empleado(self, empleado):
        self.empleados.append(empleado)

    def mostrar_empleados(self):
        print("\nLista de empleados:")
        for empleado in self.empleados:
            print(empleado)

    def mostrar_empleado(self):
        pass

    def elegir_cuenta_deposito(self):
        pass

    def elegir_cuenta_retiro(self):
        pass

    def ver_saldo_cuenta(self):
        pass


class Empleado:
    def __init__(self, nombre, edad, salario, numero_cuenta, tipo_cuenta):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario
        self.numero_cuenta = numero_cuenta
        self.tipo_cuenta = tipo_cuenta

    def __str__(self):
        return f"Nombre: {self.nombre}, Edad: {self.edad}, Salario: {self.salario}, Numero de Cuenta: {self.numero_cuenta}, Tipo de Cuenta: {self.tipo_cuenta}"


class CuentaBanco:
    def __init__(self):
        self.numero_cuenta = 0
        self.tipo_cuenta = ''

    def set_numero_cuenta(self):
        self.numero_cuenta = int(input("Ingrese el número de cuenta: "))

    def set_tipo_cuenta(self):
        self.tipo_cuenta = input("Ingrese el tipo de cuenta: ")

    def get_numero_cuenta(self):
        return self.numero_cuenta

    def get_tipo_cuenta(self):
        return self.tipo_cuenta


if __name__ == "__main__":
    banco = Banco()

    print("Bienvenido a tu app de banco")

    while True:
        print("\nElige una opción para continuar")
        print("1. Añadir Cuenta de Empleado")
        print("2. Mostrar Cuentas de Empleados")
        print("3. Mostrar Cuenta de algún Empleado")
        print("4. Depositar a cuenta")
        print("5. Retirar de cuenta")
        print("6. Mostrar saldo")
        print("7. Salir")
        opcion = int(input())

        if opcion == 1:
            print("\nElegiste la opción 1")

            nombre = input("Ingrese el nombre del empleado: ")
            edad = int(input("Ingrese la edad del empleado: "))
            salario = float(input("Ingrese el salario del empleado: "))

            cuenta_banco = CuentaBanco()
            cuenta_banco.set_numero_cuenta()
            cuenta_banco.set_tipo_cuenta()

            empleado = Empleado(nombre, edad, salario, cuenta_banco.get_numero_cuenta(), cuenta_banco.get_tipo_cuenta())

            banco.agregar_empleado(empleado)

            print(f"El empleado {nombre} se ha registrado.")
            print(f"Este es su número de cuenta: {cuenta_banco.get_numero_cuenta()}")

        elif opcion == 2:
            print("\nElegiste la opción 2")
            banco.mostrar_empleados()

        elif opcion == 3:
            print("\nElegiste la opción 3")
            banco.mostrar_empleado()

        elif opcion == 4:
            print("\nElegiste la opción 4")
            banco.elegir_cuenta_deposito()

        elif opcion == 5:
            print("\nElegiste la opción 5")
            banco.elegir_cuenta_retiro()

        elif opcion == 6:
            print("\nElegiste la opción 6")
            banco.ver_saldo_cuenta()

        else:
            break

    print("Gracias por usar su app de banco")

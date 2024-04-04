import random
import datetime

class Zoo:
    def __init__(self):
        self.empleados = []
        self.visitantes = []
        self.visitas = []
        self.animales = []
        self.mantenimientos = []

    def registrarEmpleado(self):
        print("Registrando empleado...")
        nombre = input("Nombre: ")
        apellidos = input("Apellidos: ")
        fecha_nacimiento = self.validar_fecha("Fecha de nacimiento (yyyy-MM-dd): ")
        curp = input("CURP: ")
        cargo = input("Cargo: ")
        salario = self.validar_float("Salario: ")

        empleado = Empleado(nombre, apellidos, fecha_nacimiento, curp, cargo, salario)
        self.empleados.append(empleado)
        print("Empleado registrado con éxito.")

    def registrarVisitante(self): 
        print("Registrando visitante...")
        nombre = input("Nombre: ")
        apellidos = input("Apellidos: ")
        fecha_nacimiento = self.validar_fecha("Fecha de nacimiento (yyyy-MM-dd): ")
        curp = input("CURP: ")

        visitante = Visitante(nombre, apellidos, fecha_nacimiento, curp)
        self.visitantes.append(visitante)
        print("Visitante registrado con éxito.")

    def registrarVisita(self):
        print("Registrando visita...")
        guia = input("Guía de la visita: ")
        cantidad_ninos = self.validar_entero("Cantidad de niños: ")
        cantidad_adultos = self.validar_entero("Cantidad de adultos: ")
        costo_total = self.validar_float("Costo total: ")
        fecha_visita = self.validar_fecha("Fecha de visita (yyyy-MM-dd): ")

        visitantes = []
        for _ in range(cantidad_ninos):
            visitantes.append(self.obtener_visitante_por_id())
        for _ in range(cantidad_adultos):
            visitantes.append(self.obtener_visitante_por_id())

        visita = Visita(guia, visitantes, costo_total, fecha_visita, cantidad_ninos, cantidad_adultos)
        self.visitas.append(visita)
        print("Visita registrada con éxito.")

    def registrarAnimal(self):
        print("Registrando animal...")
        tipo_animal = input("Tipo de animal: ")
        fecha_nacimiento = self.validar_fecha("Fecha de nacimiento (yyyy-MM-dd): ")
        fecha_llegada = self.validar_fecha("Fecha de llegada al zoológico (yyyy-MM-dd): ")
        peso = self.validar_float("Peso: ")
        enfermedades_respuesta = input("¿El animal tiene enfermedades? (S/N): ")
        if enfermedades_respuesta.upper() == 'S':
            enfermedades_input = input("Enfermedades (separadas por coma): ")
            enfermedades = [enf.strip() for enf in enfermedades_input.split(",")]
        else:
            enfermedades = []

        frecuencia_alimentacion = input("Frecuencia de alimentación: ")
        tipo_alimentacion = input("Tipo de alimentación: ")
        vacunas_respuesta = input("¿El animal cuenta con vacunas? (S/N): ")
        vacunas = vacunas_respuesta.upper() == 'S'

        animal = Animal(tipo_animal, fecha_nacimiento, fecha_llegada, peso, enfermedades,
                        frecuencia_alimentacion, tipo_alimentacion, vacunas)

        print("Animal registrado con éxito. ID del animal:", animal.getId())
        self.animales.append(animal)

    def registrarMantenimiento(self):
        print("Registrando mantenimiento...")
        empleado_encargado = input("Empleado encargado: ")
        id_animal = input("ID del animal: ")
        proceso_realizado = input("Proceso realizado: ")
        observaciones = input("Observaciones: ")

        mantenimiento = Mantenimiento(empleado_encargado, id_animal, proceso_realizado, observaciones)
        self.mantenimientos.append(mantenimiento)
        print("Mantenimiento registrado con éxito.")

    def modificarRegistro(self):
        print("Modificando registro...")
        print("1. Modificar Empleado")
        print("2. Modificar Visitante")
        print("3. Modificar Animal")
        opcion = self.validar_opcion(1, 3)

        if opcion == 1:
            self.modificarEmpleado()
        elif opcion == 2:
            self.modificarVisitante()
        elif opcion == 3:
            self.modificarAnimal()

    def modificarEmpleado(self):
        print("Modificando empleado...")
        empleado_id = input("ID del empleado que desea modificar: ")

        for empleado in self.empleados:
            if empleado.getId() == empleado_id:
                nombre = input(f"Nombre ({empleado.nombre}): ") or empleado.nombre
                apellidos = input(f"Apellidos ({empleado.apellidos}): ") or empleado.apellidos
                fecha_nacimiento = input(f"Fecha de nacimiento ({empleado.fecha_nacimiento}): ") or empleado.fecha_nacimiento
                curp = input(f"CURP ({empleado.curp}): ") or empleado.curp
                cargo = input(f"Cargo ({empleado.cargo}): ") or empleado.cargo
                salario = input(f"Salario ({empleado.salario}): ") or empleado.salario

                empleado.nombre = nombre
                empleado.apellidos = apellidos
                empleado.fecha_nacimiento = fecha_nacimiento
                empleado.curp = curp
                empleado.cargo = cargo
                empleado.salario = salario

                print("Empleado modificado con éxito.")
                return

        print("ID de empleado no encontrado.")

    def modificarVisitante(self):
        print("Modificando visitante...")
        visitante_id = input("ID del visitante que desea modificar: ")

        for visitante in self.visitantes:
            if visitante.getId() == visitante_id:
                nombre = input(f"Nombre ({visitante.nombre}): ") or visitante.nombre
                apellidos = input(f"Apellidos ({visitante.apellidos}): ") or visitante.apellidos
                fecha_nacimiento = input(f"Fecha de nacimiento ({visitante.fecha_nacimiento}): ") or visitante.fecha_nacimiento
                curp = input(f"CURP ({visitante.curp}): ") or visitante.curp

                visitante.nombre = nombre
                visitante.apellidos = apellidos
                visitante.fecha_nacimiento = fecha_nacimiento
                visitante.curp = curp

                print("Visitante modificado con éxito.")
                return

        print("ID de visitante no encontrado.")

    def modificarAnimal(self):
        print("Modificando animal...")
        animal_id = input("ID del animal que desea modificar: ")

        for animal in self.animales:
            if animal.getId() == animal_id:
                tipo_animal = input(f"Tipo de animal ({animal.tipo_animal}): ") or animal.tipo_animal
                fecha_nacimiento = input(f"Fecha de nacimiento ({animal.fecha_nacimiento}): ") or animal.fecha_nacimiento
                fecha_llegada = input(f"Fecha de llegada al zoológico ({animal.fecha_llegada}): ") or animal.fecha_llegada
                peso = input(f"Peso ({animal.peso}): ") or animal.peso
                enfermedades = input(f"Enfermedades ({animal.enfermedades}): ") or animal.enfermedades
                frecuencia_alimentacion = input(f"Frecuencia de alimentación ({animal.frecuencia_alimentacion}): ") or animal.frecuencia_alimentacion
                tipo_alimentacion = input(f"Tipo de alimentación ({animal.tipo_alimentacion}): ") or animal.tipo_alimentacion
                vacunas = input(f"Vacunas ({animal.vacunas}): ") or animal.vacunas

                animal.tipo_animal = tipo_animal
                animal.fecha_nacimiento = fecha_nacimiento
                animal.fecha_llegada = fecha_llegada
                animal.peso = peso
                animal.enfermedades = enfermedades
                animal.frecuencia_alimentacion = frecuencia_alimentacion
                animal.tipo_alimentacion = tipo_alimentacion
                animal.vacunas = vacunas

                print("Animal modificado con éxito.")
                return

        print("ID de animal no encontrado.")

    def eliminarRegistro(self):
        print("Eliminando registro...")
        print("1. Eliminar Empleado")
        print("2. Eliminar Visitante")
        print("3. Eliminar Animal")
        opcion = self.validar_opcion(1, 3)

        if opcion == 1:
            self.eliminarEmpleado()
        elif opcion == 2:
            self.eliminarVisitante()
        elif opcion == 3:
            self.eliminarAnimal()

    def eliminarEmpleado(self):
        print("Eliminando empleado...")
        empleado_id = input("ID del empleado que desea eliminar: ")

        for empleado in self.empleados:
            if empleado.getId() == empleado_id:
                self.empleados.remove(empleado)
                print("Empleado eliminado con éxito.")
                return

        print("ID de empleado no encontrado.")

    def eliminarVisitante(self):
        print("Eliminando visitante...")
        visitante_id = input("ID del visitante que desea eliminar: ")

        for visitante in self.visitantes:
            if visitante.getId() == visitante_id:
                self.visitantes.remove(visitante)
                print("Visitante eliminado con éxito.")
                return

        print("ID de visitante no encontrado.")

    def eliminarAnimal(self):
        print("Eliminando animal...")
        animal_id = input("ID del animal que desea eliminar: ")

        for animal in self.animales:
            if animal.getId() == animal_id:
                self.animales.remove(animal)
                print("Animal eliminado con éxito.")
                return

        print("ID de animal no encontrado.")

    def consultarRegistros(self):
        print("---------- Empleados ----------")
        for empleado in self.empleados:
            print(empleado)
        print("\n---------- Visitantes ----------")
        for visitante in self.visitantes:
            print(visitante)
        print("\n---------- Visitas ----------")
        for visita in self.visitas:
            print(visita)
        print("\n---------- Animales ----------")
        for animal in self.animales:
            print(animal)
        print("\n---------- Mantenimientos ----------")
        for mantenimiento in self.mantenimientos:
            print(mantenimiento)

    def obtener_visitante_por_id(self):
        print("\nLista de visitantes:")
        for visitante in self.visitantes:
            print(visitante)
        visitante_id = input("ID del visitante que participará: ")
        for visitante in self.visitantes:
            if visitante.getId() == visitante_id:
                return visitante
        print("ID de visitante no válido.")
        return None

    @staticmethod
    def validar_fecha(mensaje):
        while True:
            try:
                fecha = input(mensaje)
                datetime.datetime.strptime(fecha, '%Y-%m-%d')
                return fecha
            except ValueError:
                print("Formato de fecha incorrecto. Por favor, ingrese la fecha en formato yyyy-MM-dd.")

    @staticmethod
    def validar_float(mensaje):
        while True:
            try:
                valor = float(input(mensaje))
                return valor
            except ValueError:
                print("Valor no válido. Por favor, ingrese un número válido.")

    @staticmethod
    def validar_entero(mensaje):
        while True:
            try:
                valor = int(input(mensaje))
                return valor
            except ValueError:
                print("Valor no válido. Por favor, ingrese un número entero válido.")

    @staticmethod
    def validar_opcion(min, max):
        while True:
            try:
                opcion = int(input(f"Ingrese una opción ({min}-{max}): "))
                if opcion < min or opcion > max:
                    raise ValueError
                return opcion
            except ValueError:
                print("Opción no válida. Por favor, ingrese una opción válida.")

class Empleado:
    def __init__(self, nombre, apellidos, fecha_nacimiento, curp, cargo, salario):
        self.id = self.generar_id_aleatorio()
        self.nombre = nombre
        self.apellidos = apellidos
        self.fecha_nacimiento = fecha_nacimiento
        self.curp = curp
        self.cargo = cargo
        self.salario = salario

    def getId(self):
        return self.id

    def generar_id_aleatorio(self):
        num = random.randint(1, 1000)
        return "E" + str(num)

    def __str__(self):
        return f"Empleado(id='{self.id}', nombre='{self.nombre}', apellidos='{self.apellidos}', fecha_nacimiento='{self.fecha_nacimiento}', curp='{self.curp}', cargo='{self.cargo}', salario={self.salario})"

class Visitante:
    counter = 1

    def __init__(self, nombre, apellidos, fecha_nacimiento, curp):
        self.id = "V" + str(Visitante.counter)
        Visitante.counter += 1
        self.nombre = nombre
        self.apellidos = apellidos
        self.fecha_nacimiento = fecha_nacimiento
        self.curp = curp

    def getId(self):
        return self.id

    def __str__(self):
        return f"Visitante(id='{self.id}', nombre='{self.nombre}', apellidos='{self.apellidos}', fecha_nacimiento='{self.fecha_nacimiento}', curp='{self.curp}')"

class Visita:
    counter = 1

    def __init__(self, guia, visitantes, costo_total, fecha_visita, cantidad_ninos, cantidad_adultos):
        self.id = "VIS" + str(Visita.counter)
        Visita.counter += 1
        self.guia = guia
        self.visitantes = visitantes
        self.costo_total = costo_total
        self.fecha_visita = fecha_visita
        self.cantidad_ninos = cantidad_ninos
        self.cantidad_adultos = cantidad_adultos

    def getId(self):
        return self.id

    def __str__(self):
        return f"Visita(id='{self.id}', guia='{self.guia}', visitantes={self.visitantes}, costo_total={self.costo_total}, fecha_visita='{self.fecha_visita}', cantidad_ninos={self.cantidad_ninos}, cantidad_adultos={self.cantidad_adultos})"

class Animal:
    def __init__(self, tipo_animal, fecha_nacimiento, fecha_llegada, peso, enfermedades,
                 frecuencia_alimentacion, tipo_alimentacion, vacunas):
        self.id = self.generar_id_aleatorio()
        self.tipo_animal = tipo_animal
        self.fecha_nacimiento = fecha_nacimiento
        self.fecha_llegada = fecha_llegada
        self.peso = peso
        self.enfermedades = enfermedades
        self.frecuencia_alimentacion = frecuencia_alimentacion
        self.tipo_alimentacion = tipo_alimentacion
        self.vacunas = vacunas

    def generar_id_aleatorio(self):
        num = random.randint(1, 1000)
        return "A" + str(num)

    def getId(self):
        return self.id

    def __str__(self):
        return f"Animal(id='{self.id}', tipo_animal='{self.tipo_animal}', fecha_nacimiento='{self.fecha_nacimiento}', fecha_llegada='{self.fecha_llegada}', peso={self.peso}, enfermedades={self.enfermedades}, frecuencia_alimentacion='{self.frecuencia_alimentacion}', tipo_alimentacion='{self.tipo_alimentacion}', vacunas={self.vacunas})"

class Mantenimiento:
    def __init__(self, empleado_encargado, id_animal, proceso_realizado, observaciones):
        self.empleado_encargado = empleado_encargado
        self.id_animal = id_animal
        self.proceso_realizado = proceso_realizado
        self.observaciones = observaciones
        self.fecha_proceso = self.obtener_fecha_actual()

    def obtener_fecha_actual(self):
        formato = "%Y-%m-%d %H:%M:%S"
        fecha_actual = datetime.datetime.now()
        return fecha_actual.strftime(formato)

    def __str__(self):
        return f"Mantenimiento(empleado_encargado='{self.empleado_encargado}', id_animal='{self.id_animal}', proceso_realizado='{self.proceso_realizado}', observaciones='{self.observaciones}', fecha_proceso='{self.fecha_proceso}')"

def main():
    zoo = Zoo()
    password = ""

    while password != "ZOOMORELIA":
        print("\nBienvenido al Sistema del Zoológico de Morelia")
        password = input("Ingrese la contraseña del director: ")

    opcion = 0
    while opcion != 9:
        print("\n1. Registrar Empleado")
        print("2. Registrar Visitante")
        print("3. Registrar Visita")
        print("4. Registrar Animal")
        print("5. Registrar Mantenimiento")
        print("6. Modificar Registro (Empleado, Visitante, Animal)")
        print("7. Eliminar Registro (Empleado, Visitante, Animal)")
        print("8. Consultar Registros")
        print("9. Salir")
        opcion = int(input("Seleccione una opción: "))

        if opcion == 1:
            zoo.registrarEmpleado()
        elif opcion == 2:
            zoo.registrarVisitante()
        elif opcion == 3:
            zoo.registrarVisita()
        elif opcion == 4:
            zoo.registrarAnimal()
        elif opcion == 5:
            zoo.registrarMantenimiento()
        elif opcion == 6:
            zoo.modificarRegistro()
        elif opcion == 7:
            zoo.eliminarRegistro()
        elif opcion == 8:
            zoo.consultarRegistros()
        elif opcion == 9:
            print("Saliendo del sistema...")
        else:
            print("Opción no válida")

if __name__ == "__main__":
    main()

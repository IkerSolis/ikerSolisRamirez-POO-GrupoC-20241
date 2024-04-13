import random

class Producto:
    cantidad_productos = 0

    def __init__(self, nombre, precio, fecha_importacion, stock):
        self.nombre = nombre
        self.precio = precio
        self.fecha_importacion = fecha_importacion
        self.stock = stock
        self.numero_serie = Producto.cantidad_productos + 1
        Producto.cantidad_productos += 1
        self.se_compro = False

    def eliminar_stock(self, cantidad):
        if self.validar_stock():
            print("No se completó la eliminación del stock ya que el stock es 0")
        else:
            self.stock -= cantidad
            print("Se eliminó el stock con éxito")

    def validar_stock(self):
        return self.stock == 0

    def obtener_informacion(self):
        return f"Dtos del producto:\nNombre: {self.nombre}\nPrecio: {self.precio}\nFecha de importación: {self.fecha_importacion}\nStock: {self.stock}\nNúmero de serie: {self.numero_serie}"

    def agregar_stock(self, cantidad):
        self.stock += cantidad

class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, tipo_alimento):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.tipo_alimento = tipo_alimento

    def obtener_informacion_con_tipo_alimento(self):
        return super().obtener_informacion() + f"Tipo del alimento: {self.tipo_alimento}"

class Electrodomestico(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, funciones_programables, voltaje):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.funciones_programables = funciones_programables
        self.voltaje = voltaje

    def obtener_informacion_electrodomestico(self):
        return super().obtener_informacion() + f"Funciones programables: {self.funciones_programables}\nVoltaje: {self.voltaje}"

class Limpieza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, tipo_fragancia):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.tipo_fragancia = tipo_fragancia

    def obtener_informacion_limpieza(self):
        return super().obtener_informacion() + f"Fragancia del producto: {self.tipo_fragancia}"

class Cosmeticos(Producto):
    def __init__(self, nombre, precio, fecha_importacion, stock, ingredientes_principal):
        super().__init__(nombre, precio, fecha_importacion, stock)
        self.ingredientes_principal = ingredientes_principal

    def obtener_informacion_con_ingrediente(self):
        return super().obtener_informacion() + f"Ingreiente del producto: {self.ingredientes_principal}"

class Compra:
    marcador = 50

    def __init__(self, fecha):
        self.id_compra = Compra.marcador
        Compra.marcador += 1
        self.fecha = fecha
        self.lista_productos = []

    def agregar_producto(self, producto):
        self.lista_productos.append(producto)

    def mostrar_info_compra(self):
        print(f"ID de la compra: {self.id_compra}")
        print(f"Fecha de la compra: {self.fecha}")
        print("Lista de productos comprados:")
        total_compra = 0.0
        for producto in self.lista_productos:
            print(f"Número de serie: {producto.numero_serie}")
            print(f"Nombre: {producto.nombre}")
            print(f"Precio: {producto.precio}")
            total_compra += producto.precio
        print(f"Total del pago: {total_compra}")

class Cliente:
    def __init__(self, id, nombre, direccion):
        self.id = id
        self.nombre = nombre
        self.direccion = direccion
        self.realizo_compra = False

    def obtener_datos(self):
        return f"\nId: {self.id}\nNombre: {self.nombre}\nDirección: {self.direccion}"

class Tienda:
    def __init__(self):
        self.lista_clientes = []
        self.lista_compras = []
        self.productos_totales = []
        self.producto_limpieza = []
        self.producto_alimento = []
        self.producto_electrodomestico = []
        self.producto_cosmetico = []

    def registrar_cliente(self):
        id = self.validar_id_cliente()
        print("Tu id se genera automáticamente")
        nombre = input("Ingresa el nombre: ")
        direccion = input("Ingresa la dirección del cliente: ")

        cliente = Cliente(id, nombre, direccion)
        self.lista_clientes.append(cliente)
        print(f"Cliente registrado con éxito. Este es el ID generado: {cliente.id}")

    def validar_id_cliente(self):
        id_valido = True
        id_cliente = random.randint(1, 1000)
        while not id_valido:
            for cliente in self.lista_clientes:
                if id_cliente == cliente.id:
                    id_valido = False
                    id_cliente = random.randint(1, 1000)
        return id_cliente

    def registrar_producto_limpieza(self):
        print("Elegiste registrar un producto de limpieza")
        datos_usuario = self.registrar_datos()

        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        tipo_fragancia = input("Ingresa la fragancia del producto: ")

        producto = Limpieza(nombre, precio, fecha, stock, tipo_fragancia)
        self.producto_limpieza.append(producto)
        self.productos_totales.append(producto)
        print("Producto registrado con éxito")

    def registrar_producto_electrodomestico(self):
        print("Elegiste registrar un producto electromestico")
        datos_usuario = self.registrar_datos()

        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        funciones_programables = input("Ingresa las funciones programables del producto: ")
        voltaje = float(input("Ingresa el voltaje: "))

        producto = Electrodomestico(nombre, precio, fecha, stock, funciones_programables, voltaje)
        self.producto_electrodomestico.append(producto)
        self.productos_totales.append(producto)
        print("Producto registrado con éxito")

    def registrar_producto_alimento(self):
        print("Elegiste registrar un alimento")
        datos_usuario = self.registrar_datos()

        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        tipo_alimento = input("Ingresa el tipo de alimento: ")

        producto = Alimento(nombre, precio, fecha, stock, tipo_alimento)
        self.producto_alimento.append(producto)
        self.productos_totales.append(producto)
        print("Producto registrado con éxito")

    def registrar_producto_cosmetico(self):
        print("Elegiste registrar un producto de la categoría maquillaje")
        datos_usuario = self.registrar_datos()

        nombre = datos_usuario[0]
        precio = float(datos_usuario[1])
        fecha = datos_usuario[2]
        stock = int(datos_usuario[3])

        ingrediente = input("Ingresa el ingrediente del cosmético: ")

        producto = Cosmeticos(nombre, precio, fecha, stock, ingrediente)
        self.producto_cosmetico.append(producto)
        self.productos_totales.append(producto)
        print("Producto registrado con éxito")

    def registrar_datos(self):
        datos = []

        nombre = input("Ingresa el nombre del producto: ")
        datos.append(nombre)

        precio = float(input("Ingresa el precio del producto: "))
        datos.append(str(precio))

        fecha = input("Ingresa la fecha de importación: ")
        datos.append(fecha)

        stock = int(input("Ingresa el stock del producto: "))
        datos.append(str(stock))

        return datos

    def consultar_clientes(self):
        print("CLIENTES")
        if not self.lista_clientes:
            print("No existen clientes registrados")
        else:
            for cliente in self.lista_clientes:
                print(cliente.obtener_datos())

    def consultar_productos_limpieza(self):
        print("PRODUCTOS LIMPIEZA")
        if not self.producto_limpieza:
            print("No existen productos registrados")
        else:
            for producto in self.producto_limpieza:
                print(producto.obtener_informacion_limpieza())

    def consultar_productos_electrodomestico(self):
        print("PRODUCTOS ELECTRODOMESTICOS")
        if not self.producto_electrodomestico:
            print("No existen productos registrados")
        else:
            for producto in self.producto_electrodomestico:
                print(producto.obtener_informacion_electrodomestico())

    def consultar_productos_alimento(self):
        print("PRODUCTOS ALIMENTICIOS")
        if not self.producto_alimento:
            print("No existen productos registrados")
        else:
            for producto in self.producto_alimento:
                print(producto.obtener_informacion_con_tipo_alimento())

    def consultar_productos_cosmeticos(self):
        print("PRODUCTOS COSMETICOS")
        if not self.producto_cosmetico:
            print("No existen productos registrados")
        else:
            for producto in self.producto_cosmetico:
                print(producto.obtener_informacion_con_ingrediente())

    def consultar_lista_completa(self):
        print("LISTA DE TODOS LOS PRODUCTOS")
        for producto in self.productos_totales:
            print(producto.obtener_informacion())

    def agregar_stock():
        print("Añadir stock de productos")
        print("Elija el producto para añadir stock")
        print("Productos disponibles")
        print("1. Limpieza")
        print("2. Electrodomesticos")
        print("3. Alimentos")
        print("4. Cosmeticos")
        opcion = int(input())

        if opcion == 1:
            print("Ingrese el número de serie del producto: ")
            id = int(input())
            for limpieza in productoLimpieza:
                if limpieza.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea agregar")
                    cantidad = int(input())
                    limpieza.agregar_stock(cantidad)
                    print("Se agregaron", cantidad, "al stock")
                    print(" ")
                else:
                    print("Numero de serie inexistente")
        elif opcion == 2:
            print("Ingrese el número de serie del producto: ")
            id = int(input())
            for electrodomestico in productoElectrodomestico:
                if electrodomestico.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea agregar")
                    cantidad = int(input())
                    electrodomestico.agregar_stock(cantidad)
                    print("Se agregaron", cantidad, "al stock")
                    print(" ")
                else:
                    print("Numero de serie inexistente")
        elif opcion == 3:
            print("Ingrese el número de serie del producto: ")
            id = int(input())
            for alimento in productoAlimento:
                if alimento.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea agregar")
                    cantidad = int(input())
                    alimento.agregar_stock(cantidad)
                    print("Se agregaron", cantidad, "al stock")
                    print(" ")
            else:
                print("Numero de serie inexistente")
        elif opcion == 4:
            print("Ingrese el número de serie del producto: ")
            id = int(input())
            for cosmeticos in productoCosmetico:
                if cosmeticos.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea agregar")
                    cantidad = int(input())
                    cosmeticos.agregar_stock(cantidad)
                    print("Se agregaron", cantidad, "al stock")
                    print(" ")
            else:
                print("Numero de serie inexistente")
        else:
            print("No existe esa funcion")

    def eliminar_stock():
        print("Eliminar stock de productos")
        print("Ingresa e al que deseas quitar stock ")
        print("Productos disponibles")
        print("1. Limpieza")
        print("2. Electrodomesticos")
        print("3. Alimentos")
        print("4. Cosmeticos")
        opcion = int(input())

        if opcion == 1:
            print("Ingrese el número de serie del producto: ")
            id = int(input())

            for limpieza in productoLimpieza:
                if limpieza.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea eliminar: ")
                    cantidad = int(input())
                    limpieza.eliminar_stock(cantidad)
                    print("Se eliminaron", cantidad, "del stock")
                    print(" ")
                else:
                    print("numero de serie inexistente")
        elif opcion == 2:
            print("Ingrese el número de serie del producto: ")
            id = int(input())

            for electrodomestico in productoElectrodomestico:
                if electrodomestico.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea eliminar: ")
                    cantidad = int(input())
                    electrodomestico.eliminar_stock(cantidad)
                    print("Se eliminaron", cantidad, "del stock")
                    print(" ")
                else:
                    print("numero de serie inexistente")
        elif opcion == 3:
            print("Ingrese el número de serie del producto: ")
            id = int(input())

            for alimento in productoAlimento:
                if alimento.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea eliminar: ")
                    cantidad = int(input())
                    alimento.eliminar_stock(cantidad)
                    print("Se eliminaron", cantidad, "del stock")
                    print(" ")
                else:
                    print("numero de serie inexistente")
        elif opcion == 4:
            print("Ingrese el número de serie del producto: ")
            id = int(input())

            for cosmeticos in productoCosmetico:
                if cosmeticos.get_numero_serie() == id:
                    print("Ingresa la cantidad que desea eliminar: ")
                    cantidad = int(input())
                    cosmeticos.eliminar_stock(cantidad)
                    print("Se eliminaron", cantidad, "del stock")
                    print(" ")
                else:
                    print("numero de serie inexistente")
        else:
            print("No existe esa funcion")

    def consultar_productos_clientes(self):
        print("Total de clientes:", len(self.lista_clientes))
        total_productos = len(self.producto_limpieza) + len(self.producto_electrodomestico) + len(self.producto_alimento) + len(self.producto_cosmetico)
        print("Total de productos:", total_productos)

    def realizar_compra():
        print("COMPRA")
        print("Ingrese su ID: ")
        id = int(input())
        seguir_comprando = 0
        cliente = obtener_cliente(id)
        if cliente is not None:
            while True:
                print("Elija el tipo de producto que desea comprar")
                print("1. Limpieza")
                print("2. Electrodomesticos")
                print("3. Alimentos")
                print("4. Cosmeticos")

                print("Ingrese el id del producto que desea comprar: ")
                id_producto = int(input())

                if Producto(id_producto):
                    input("Escriba la fecha de compra: ")
                    fecha = input()
                    nueva_compra = Compra(fecha)
                    cliente.set_realizo_compra(True)
                    producto_comprado = obtener_producto(id_producto)
                    nueva_compra.agregar_producto(producto_comprado)
                    producto_comprado.set_se_compro(True)
                    lista_compras.append(nueva_compra)
                    print("Compra realizada: ", nueva_compra.get_id_compra())

                else:
                    print("Producto inexistente")

                seguir_comprando = int(input("Desea realizar mas compras? \n1.Si \t 2.No"))
                if seguir_comprando == 2:
                    break

        else:
            print("El cliente no se encuentra en la lista de registros")

    def ver_compras():
        print("Esta es la lista de compras")
        for compra in lista_compras:
            compra.mostrar_info_compra()

    def eliminar_cliente():
        print("Ingresa el id del cliente que deseas eliminar: ")
        id_cliente = int(input())
        cliente = obtener_cliente(id_cliente)
        if cliente is not None and not cliente.realizo_compra:
            lista_clientes.remove(cliente)
            print("Se eliminó el cliente")
        else:
            print("No existe el cliente ingresado o ya realizó una compra")

    def eliminar_producto():
        print("Ingresa el id del producto que deseas eliminar: ")
        id_producto = int(input())
        producto = obtener_producto(id_producto)
        if producto is not None and not producto.se_compro:
            producto.se_compro = False
            productos_totales.remove(producto)
            producto_limpieza.remove(producto)
            producto_electrodomestico.remove(producto)
            producto_alimento.remove(producto)
            producto_cosmetico.remove(producto)
            print("Producto eliminado")
        else:
            print("Este producto no se ha registrado o ya se ha comprado")

class Sistema:

    def __init__(self):
        self.clave = "Amlo4t"
        self.tienda = Tienda()

    def ejecutar_programa(self):
        clave_valida = False
        while not clave_valida:
            clave = input("Ingresa la contraseña para acceder al sistema: ")
            if self.validar_clave(clave):
                clave_valida = True
                self.mostrar_menu_sistema()
            else:
                print("Contraseña incorrecta")

    def validar_clave(self, clave):
        return clave == self.clave

    def mostrar_menu_sistema(self):
        opcion = 0
        print("BIENVENIDO A LOS ABARROTES DON DENZEL")
        while opcion != 13:
            print("Estas son las opciones del sistema")
            print("1.- Registrar cliente")
            print("2.- Registrat producto")
            print("3.- Agregar stock")
            print("4.- Eliminar stock")
            print("5.- Ver lista de clientes clientes")
            print("6.- Ver lsita de todos los productos")
            print("7.- Ver lista de productos por categoría")
            print("8.- Comprar productos")
            print("9.- Consultar Compras")
            print("10.- Ver lista de los productos y clientes")
            print("11.- Eliminar clientes")
            print("12.- Eliminar productos")
            print("13.- Salir del sistema")
            opcion = int(input("Ingresa la opción deseada: "))

            if opcion == 1:
                self.tienda.registrar_cliente()
            elif opcion == 2:
                self.registrar_producto()
            elif opcion == 3:
                self.tienda.agregar_stock()
            elif opcion == 4:
                self.tienda.eliminar_stock()
            elif opcion == 5:
                self.tienda.consultar_clientes()
            elif opcion == 6:
                self.tienda.consultar_lista_completa()
            elif opcion == 7:
                self.consultar_productos_por_categoria()
            elif opcion == 8:
                self.tienda.realizar_compra()
            elif opcion == 9:
                self.tienda.ver_compras()
            elif opcion == 10:
                self.tienda.consultar_productos_clientes()
            elif opcion == 11:
                self.tienda.eliminar_cliente()
            elif opcion == 12:
                self.tienda.eliminar_producto()
            elif opcion == 13:
                print("Saliendo del sistema...")
            else:
                print("Opción no válida")

        print("Gracias por usar el sistema :)")

    def registrar_producto(self):
        print("Elegiste registrar un producto")
        print("Estos son los tipos de productos para registrar")
        print("1. Limpieza")
        print("2. Electrodomesticos")
        print("3. Alimentos")
        print("4. Cosmeticos")
        tipo_producto = int(input("Ingresa el tipo de producto que deseas registrar: "))

        if tipo_producto == 1:
            self.tienda.registrar_producto_limpieza()
        elif tipo_producto == 2:
            self.tienda.registrar_producto_electrodomestico()
        elif tipo_producto == 3:
            self.tienda.registrar_producto_alimento()
        elif tipo_producto == 4:
            self.tienda.registrar_producto_cosmetico()
        else:
            print("No existe esa función")

if __name__ == "__main__":
    sistema = Sistema()
    sistema.ejecutar_programa()

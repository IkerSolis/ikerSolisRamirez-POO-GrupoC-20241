class Libreria:
    def __init__(self):
        self.usuarios = []
        self.lista_libros = []
        self.libros_rentados = []
        self.usuarios_renta = []
        self.libros_no_rentados = []

    def registrar_usuario(self, usuario):
        self.usuarios.append(usuario)

    def añadir_libro(self, libro):
        self.lista_libros.append(libro)

    def libros_renta(self, libros_renta):
        self.libros_rentados.append(libros_renta)

    def usuario_renta(self, usuarios_renta):
        self.usuarios_renta.append(usuarios_renta)

    def libro_sin_renta(self, libros_no_renta):
        self.libros_no_rentados.append(libros_no_renta)

    def mostrar_usuarios(self):
        print("---USUARIOS---")
        for usuario in self.usuarios:
            print("-" + usuario.get_nombre() + " ID: " + str(usuario.get_id()))

    def mostrar_libros(self):
        print("---LIBROS---")
        for libro in self.lista_libros:
            print("Datos del libro:")
            print("Nombre del libro: " + libro.get_name())
            print("Nombre del autor: " + libro.get_autor())
            print("ID del libro: " + str(libro.get_id()))
            print("Cantidad disponible: " + str(libro.get_cantidad()))
            print(" ")

    def renta_libros(self):
        print("---Usuarios Registrados---")
        for x, usuario in enumerate(self.usuarios):
            print(f"{x}. {usuario.get_nombre()}")

        print("Quién va a rentar: ")
        renta = int(input())
        self.usuario_renta(self.usuarios[renta])

        while True:
            print("---Libros disponibles---")
            for y, libro in enumerate(self.lista_libros):
                print(f"{y}. {libro.get_name()}")

            print("Qué libro desea rentar: ")
            renta_libro = int(input())
            if renta_libro >= 0:
                print("Se rentó el libro: " + self.lista_libros[renta_libro].get_name())
                self.lista_libros[renta_libro].rentar_libro()
                self.libros_renta(self.lista_libros[renta_libro])

            seguir = input("Quieres rentar más libros? (Y/N): ")
            if seguir.lower() != 'y':
                break

        for libro in self.lista_libros:
            if libro not in self.libros_rentados:
                self.libro_sin_renta(libro)

    def mostrar_rentadores(self):
        print("Esta es la lista de rentadores")
        for usuario_renta in self.usuarios_renta:
            print("-" + usuario_renta.get_nombre() + " ID: " + str(usuario_renta.get_id()))

    def mostrar_libros_rentados(self):
        print("Estos son los libros que han sido rentados")
        for libros_rentados in self.libros_rentados:
            print("-" + libros_rentados.get_name() + " By: " + libros_rentados.get_autor() + " ID: " + str(libros_rentados.get_id()))
            print("Cantidad restante: " + str(libros_rentados.get_cantidad()))

    def mostrar_libros_no_rentados(self):
        print("Estos son los libros no rentados")
        for libros_no_rentados in self.libros_no_rentados:
            print("-" + libros_no_rentados.get_name() + " By: " + libros_no_rentados.get_autor() + " ID: " + str(libros_no_rentados.get_id()))
            print("Cantidad restante: " + str(libros_no_rentados.get_cantidad()))

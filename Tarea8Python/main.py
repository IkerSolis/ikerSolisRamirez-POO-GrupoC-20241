from Libreria import Libreria
from Usuario import Usuario
from Libro import Libro

libreria = Libreria()

usuarioUno = Usuario("Goku Ortiz", 45, 360)
libreria.registrar_usuario(usuarioUno)

libroUno = Libro("Las batallas en el desierto", "José Emilio Pacheco", 345, 12)
libreria.añadir_libro(libroUno)

libroDos = Libro("La insoportable levedad del ser", "Milan Kundera", 123, 10)
libreria.añadir_libro(libroDos)

libroTres = Libro("All Tomorrows", "C. M. Kosemen", 420, 2)
libreria.añadir_libro(libroTres)

print("Bienvenido a la libreria")

while True:
    print("Elige una opción para continuar")
    print("1. Añadir Usuario")
    print("2. Mostrar Usuarios")
    print("3. Añadir Libros")
    print("4. Mostrar Libros")
    print("5. Rentar libros")
    print("6. Usuarios que han rentado libros")
    print("7. Libros que han sido rentados")
    print("8. Libros que no han sido rentados")
    print("9. Salir")

    opcion = int(input())

    if opcion == 1:
        print("\nElegiste la opción 1")
        usuarioDatos = Usuario()
        usuarioDatos.set_nombre()
        nombre = usuarioDatos.get_nombre()
        usuarioDatos.set_edad()
        edad = usuarioDatos.get_edad()
        usuarioDatos.set_id()
        id_usuario = usuarioDatos.get_id()

        usuario = Usuario(nombre, edad, id_usuario)

        libreria.registrar_usuario(usuario)

        print("El usuario", nombre, "ha sido registrado")
        print("El id del usuario", nombre, "es:", id_usuario)
    elif opcion == 2:
        print("\nElegiste la opción 2")
        libreria.mostrar_usuarios()
        print(" ")
    elif opcion == 3:
        print("\nElegiste la opción 3")
        libroDatos = Libro()
        libroDatos.set_name()
        name = libroDatos.get_name()
        libroDatos.set_autor()
        autor = libroDatos.get_autor()
        libroDatos.set_id()
        id_libro = libroDatos.get_id()
        libroDatos.set_cantidad()
        cantidad = libroDatos.get_cantidad()

        libro = Libro(name, autor, id_libro, cantidad)

        libreria.añadir_libro(libro)
        print("\nLibro registrado")
        print("Estos son los datos: ")
        print("Nombre del libro:", libro.get_name())
        print("Nombre del autor:", libro.get_autor())
        print("ID del libro:", libro.get_id())
        print("Cantidad del libro:", libro.get_cantidad())
        print(" ")
    elif opcion == 4:
        print("\nElegiste la opción 4")
        libreria.mostrar_libros()
        print(" ")
    elif opcion == 5:
        print("\nElegiste la opción 5")
        libreria.renta_libros()
        print(" ")
    elif opcion == 6:
        print("\nElegiste la opción 6")
        libreria.mostrar_rentadores()
        print(" ")
    elif opcion == 7:
        print("\nElegiste la opción 7")
        libreria.mostrar_libros_rentados()
        print(" ")
    elif opcion == 8:
        print("\nElegiste la opción 8")
        libreria.mostrar_libros_no_rentados()
        print(" ")
    else:
        print("Saliendo de la librería ...")
        break

print("¡Disfrute los libros!")

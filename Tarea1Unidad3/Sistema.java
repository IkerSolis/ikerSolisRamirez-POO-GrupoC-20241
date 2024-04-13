import java.util.Scanner;

public class Sistema {

    Scanner leer = new Scanner(System.in);
    private final String CLAVE = "Amlo4t";
    private Tienda objetoTienda = new Tienda();

    public void ejecutarPrograma() {
        boolean claveValida = false;
        do {
            System.out.print("Ingresa la contraseña para acceder al sistema: ");
            String clave = leer.nextLine();

            if (validarClave(clave)) {

                claveValida = true;
                mostrarMenuSistema();
            } else {

                System.out.println("Contraseña incorrecta");
            }
        } while (!claveValida);

    }

    private boolean validarClave(String clave) {
        return clave.equals(CLAVE);
    }

    private void mostrarMenuSistema()
    {
        int opcion = 0;
        System.out.println("BIENVENIDO AL SISTEMA DE ");
        do {;
            System.out.println("Estas son las opciones del sistema");
            System.out.println("1.- Registrar cliente");
            System.out.println("2.- Registrat producto");
            System.out.println("3.- Agregar stock");
            System.out.println("4.- Eliminar stock");
            System.out.println("5.- Ver lista de clientes clientes");
            System.out.println("6.- Ver lsita de todos los productos");
            System.out.println("7.- Ver lista de productos por categoría");
            System.out.println("8.- Comprar productos");
            System.out.println("9.- Consultar Compras");
            System.out.println("10.- Ver lista de los productos y clientes");
            System.out.println("11.- Eliminar clientes");
            System.out.println("12.- Eliminar productos");
            System.out.println("13.- Salir del sistema");
            opcion = leer.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println("Elegiste la opcion 1");
                    objetoTienda.registrarCliente();
                    break;
                case 2:
                    System.out.println("Elegiste la opcion 2");
                    System.out.println("Estos son los tipos de productos para registrar");
                    System.out.println("1. Limpieza");
                    System.out.println("2. Electrodomesticos");
                    System.out.println("3. Alimentos");
                    System.out.println("4. Cosmeticos");
                    System.out.print("Ingresa el tipo de producto que deseas registrar: ");
                    int tipoProducto = leer.nextInt();

                    switch(tipoProducto)
                    {
                        case 1:
                            objetoTienda.registrarProductoLimpieza();
                            break;
                        case 2:
                            objetoTienda.registrarProductoElectrodomestico();
                            break;
                        case 3:
                            objetoTienda.registrarProductoAlimento();
                            break;
                        case 4:
                            objetoTienda.registrarProductoCosmetico();
                            break;

                        default: System.out.println("No existe esa funcion");
                    }
                    break;
                case 3:
                    objetoTienda.agregarStock();
                    break;
                case 4:
                    objetoTienda.eliminarStock();
                    break;
                case 5:
                    objetoTienda.consultarClientes();
                    break;
                case 6:
                    objetoTienda.consultarListaCompleta();
                    break;

                case 7:
                    System.out.println("Estos son los tipos de productos para consultar");
                    System.out.println("1. Limpieza");
                    System.out.println("2. Electrodomesticos");
                    System.out.println("3. Alimentos");
                    System.out.println("4. Cosmeticos");
                    System.out.print("Ingresa el tipo de producto que deseas ver: ");
                    int tipoProductoLista = leer.nextInt();

                    switch(tipoProductoLista)
                    {
                        case 1:
                            objetoTienda.consultarProductosLimpieza();
                            break;
                        case 2:
                            objetoTienda.consultarProductosElectrodomestico();
                            break;

                        case 3:
                            objetoTienda.consultarProductosAlimento();
                            break;

                        case 4:
                            objetoTienda.consultarProductosCosmeticos();
                            break;

                        default:
                            System.out.println("No existe esa funcion");
                    }
                    break;
                case 8:
                    objetoTienda.realizarCompra();
                    break;
                case 9:
                    objetoTienda.verCompras();
                    break;
                case 10:
                    objetoTienda.consultarProductosClientes();
                    break;
                case 11:
                    objetoTienda.eliminarCliente();
                    break;
                case 12:
                    objetoTienda.eliminarProducto();
                    break;
                case 13:
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        } while (opcion != 13);

        System.out.println("Gracias por usar el sistema :)");

    }
}
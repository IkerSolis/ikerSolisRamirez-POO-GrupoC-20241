import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Tienda {
    private Random aleatorio = new Random();
    private Scanner leer = new Scanner(System.in);
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private ArrayList<Compra> listaCompras = new ArrayList<Compra>();
    private ArrayList<Producto> productosTotales = new ArrayList<Producto>();
    private ArrayList<Cosmeticos> productoCosmetico = new ArrayList<Cosmeticos>();
    private ArrayList<Limpieza> productoLimpieza = new ArrayList<Limpieza>();
    private ArrayList<Alimento> productoAlimento = new ArrayList<Alimento>();
    private ArrayList<Electrodomestico> productoElectrodomestico = new ArrayList<Electrodomestico>();


    public void registrarCliente() {
        int id = validarIdCliente();
        System.out.println("Tu id se genera automáticamente");
        System.out.print("Ingresa el nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Ingresa la dirección del cliente: ");
        String direccion = leer.nextLine();

        Cliente objetoCliente = new Cliente(id, nombre, direccion);
        listaClientes.add(objetoCliente);
        System.out.println("Cliente registrado con exito este es el id generado: " + objetoCliente.getId());
    }

    public int validarIdCliente() {
        boolean idValido = true;
        int id = aleatorio.nextInt(1000) + 1;

        do {
            for (Cliente iteradorCliente : listaClientes) {
                if (id == iteradorCliente.getId()) {
                    idValido = false;
                    id = aleatorio.nextInt(1000) + 1;
                }
            }
        } while (!idValido);

        return id;
    }

    public ArrayList<String> registrarDatos() {
        ArrayList<String> datos = new ArrayList<String>();

        System.out.print("Ingresa el nombre del procuto: ");
        String nombre = leer.nextLine();
        datos.add(nombre);

        System.out.print("Ingresa el precio del producto: ");
        double precio = leer.nextDouble();
        datos.add(String.valueOf(precio));

        leer.nextLine();
        System.out.print("Ingresa la fecha de importación: ");
        String fecha = leer.nextLine();
        datos.add(fecha);

        System.out.print("Ingresa el stock del producto: ");
        int stock = leer.nextInt();
        datos.add(String.valueOf(stock));

        return datos;
    }

    public void registrarProductoLimpieza() {
        System.out.println("Elegiste registrar un producto de limpieza");

        ArrayList<String> datosUsuario = registrarDatos();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.print("Ingresa la fragancia del procducto: ");
        String tipoFragancia = leer.nextLine();

        Limpieza objetoLimpieza = new Limpieza(nombre, precio, fecha, stock, tipoFragancia);
        productoLimpieza.add(objetoLimpieza);
        productosTotales.add(objetoLimpieza);
        System.out.println("Procuto registrado con exito");
    }

    public void registrarProductoElectrodomestico() {
        System.out.println("Elegiste registrar un producto electromestico");

        ArrayList<String> datosUsuario = registrarDatos();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.println("Ingresa las funciones programales con las que cuenta el producto: ");
        String funcionesProgramales = leer.nextLine();

        System.out.print("Ingresa el voltaje: ");
        double voltaje = leer.nextDouble();

        Electrodomestico objetoElectrodomestico = new Electrodomestico(nombre, precio, fecha, stock,
                funcionesProgramales,voltaje);
        productoElectrodomestico.add(objetoElectrodomestico);
        productosTotales.add(objetoElectrodomestico);
        System.out.println("Procuto registrado con exito");
    }

    public void registrarProductoAlimento() {
        System.out.println("Elegiste registrar un Alimento");

        ArrayList<String> datosUsuario = registrarDatos();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.print("Ingresa el tipo del alimento: ");
        String tipoAlimento = leer.nextLine();

        Alimento objetoAlimento = new Alimento(nombre, precio, fecha, stock, tipoAlimento);
        productoAlimento.add(objetoAlimento);
        productosTotales.add(objetoAlimento);
        System.out.println("Procuto registrado con exito");
    }

    public void registrarProductoCosmetico() {
        System.out.println("Elegiste registrar un producto de la categoría maquillaje");

        ArrayList<String> datosUsuario = registrarDatos();

        String nombre = datosUsuario.get(0);
        double precio = Double.parseDouble(datosUsuario.get(1));

        String fecha = datosUsuario.get(2);

        int stock = Integer.parseInt(datosUsuario.get(3));

        leer.nextLine();

        System.out.print("Ingresa el ingrediente del cosmetico: ");
        String ingrediente = leer.nextLine();

        Cosmeticos objetoMaquillaje = new Cosmeticos(nombre, precio, fecha, stock, ingrediente);
        productoCosmetico.add(objetoMaquillaje);
        productosTotales.add(objetoMaquillaje);
        System.out.println("Procuto registrado con exito");
    }

    public void consultarClientes() {
        System.out.println("CLIENTES");
        if (listaClientes.isEmpty()) {
            System.out.println("No existen clientes registrados");
        }
        for (Cliente iteradorCliente : listaClientes) {
            System.out.println(iteradorCliente.obtenerDatos());
        }
    }

    public void consultarProductosLimpieza() {
        System.out.println("PRODUCTOS LIMPIEZA");

        if (productoLimpieza.isEmpty()) {
            System.out.println("No existen productos registrados");
        } else {
            for (Limpieza iteradorLimpieza : productoLimpieza) {
                System.out.println(iteradorLimpieza.obtenerInformacionLimpieza());
            }
        }

    }

    public void consultarProductosElectrodomestico() {
        System.out.println("PRODUCTOS ELECTRODOMESTICOS");
        if (productoElectrodomestico.isEmpty()) {
            System.out.println("No existen productos registrados");
        } else {
            for (Electrodomestico iteradorElectrodomestico : productoElectrodomestico) {
                System.out.println(iteradorElectrodomestico.obtenerInformacionElectrodomestico());
            }
        }

    }

    public void consultarProductosAlimento() {
        System.out.println("PRODUCTOS ALIMENTICIOS");
        if (productoAlimento.isEmpty()) {
            System.out.println("No eixten productos registrados");
        } else {
            for (Alimento iteradorAlimento : productoAlimento) {
                System.out.println(iteradorAlimento.obtenerInformacionConTipoAlimento());
            }
        }

    }

    public void consultarProductosCosmeticos() {
        System.out.println("PRODUCTOS COSMETICOS");
        if (productoCosmetico.isEmpty()) {
            System.out.println("No existen productos registrados");
        }
        for (Cosmeticos iteradorMaquillaje : productoCosmetico) {
            System.out.println(iteradorMaquillaje.obtenerInformacionConIngrediente());
        }
    }

    public void consultarListaCompleta() {
        System.out.println("LISTA DE TODOS LOS PRODUCTOS");

        for (Limpieza iteradorLimpieza : productoLimpieza) {
            System.out.println(iteradorLimpieza.obtenerInformacionLimpieza());
        }

        for (Electrodomestico iteradorElectrodomestico : productoElectrodomestico) {
            System.out.println(iteradorElectrodomestico.obtenerInformacionElectrodomestico());
        }

        for (Alimento iteradorAlimento : productoAlimento) {
            System.out.println(iteradorAlimento.obtenerInformacionConTipoAlimento());
        }

        for (Cosmeticos iteradorCosmetico : productoCosmetico) {
            System.out.println(iteradorCosmetico.obtenerInformacionConIngrediente());
        }
    }

    public void agregarStock() {
        System.out.println("Añadir stock de productos");
        System.out.println("Elija el producto para añadir stock");
        System.out.println("Productos disponibles");
        System.out.println("1. Limpieza");
        System.out.println("2. Electrodomesticos");
        System.out.println("3. Alimentos");
        System.out.println("4. Cosmeticos");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el número de serie del producto: ");
                int id = leer.nextInt();
                for (Limpieza limpieza : productoLimpieza) {
                    if (limpieza.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea agregar");
                        int cantidad = leer.nextInt();
                        limpieza.agregarStock(cantidad);
                        System.out.println("Se agregaron " + cantidad +" al stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }
                break;
            case 2:

                System.out.print("Ingrese el número de serie del producto: ");
                id = leer.nextInt();
                for (Electrodomestico electrodomestico : productoElectrodomestico) {
                    if (electrodomestico.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea agregar");
                        int cantidad = leer.nextInt();
                        electrodomestico.agregarStock(cantidad);
                        System.out.println("Se agregaron " + cantidad +" al stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }
                break;
            case 3:
                System.out.print("Ingrese el número de serie del producto: ");
                id = leer.nextInt();
                for (Alimento alimento : productoAlimento) {
                    if (alimento.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea agregar");
                        int cantidad = leer.nextInt();
                        alimento.agregarStock(cantidad);
                        System.out.println("Se agregaron " + cantidad +" al stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }
                break;
            case 4:
                System.out.print("Ingrese el número de serie del producto: ");
                id = leer.nextInt();
                for (Cosmeticos cosmeticos : productoCosmetico) {
                    if (cosmeticos.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea agregar");
                        int cantidad = leer.nextInt();
                        cosmeticos.agregarStock(cantidad);
                        System.out.println("Se agregaron " + cantidad +" al stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }
                break;
            default:
                System.out.println("No existe esa funcion");
                break;
        }
    }

    public void eliminarStock() {
        System.out.println("Eliminar stock de productos");
        System.out.println("Ingresa e al que deseas quitar stock ");
        System.out.println("Productos disponibles");
        System.out.println("1. Limpieza");
        System.out.println("2. Electrodomesticos");
        System.out.println("3. Alimentos");
        System.out.println("4. Cosmeticos");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el número de serie del producto: ");
                int id = leer.nextInt();

                for (Limpieza limpieza : productoLimpieza) {
                    if (limpieza.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea eliminar: ");
                        int cantidad = leer.nextInt();
                        limpieza.eliminarStock(cantidad);
                        System.out.println("Se eliminaron " + cantidad +" del stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }
                break;
            case 2:

                System.out.print("Ingrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Electrodomestico electrodomestico : productoElectrodomestico) {
                    if (electrodomestico.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea eliminar: ");
                        int cantidad = leer.nextInt();
                        electrodomestico.eliminarStock(cantidad);
                        System.out.println("Se eliminaron " + cantidad +" del stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }
                break;
            case 3:
                System.out.print("Ingrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Alimento alimento : productoAlimento) {
                    if (alimento.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea eliminar: ");
                        int cantidad = leer.nextInt();

                        alimento.eliminarStock(cantidad);
                        System.out.println("Se eliminaron " + cantidad +" del stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }

                break;

            case 4:
                System.out.print("Ingrese el número de serie del producto: ");
                id = leer.nextInt();

                for (Cosmeticos cosmeticos : productoCosmetico) {
                    if (cosmeticos.getNumeroSerie() == id) {
                        System.out.print("Ingresa la cantidad que desea eliminar: ");
                        int cantidad = leer.nextInt();
                        cosmeticos.eliminarStock(cantidad);
                        System.out.println("Se eliminaron " + cantidad +" del stock");
                        System.out.println(" ");
                    } else {
                        System.out.println("numero de serie inexistente");
                    }
                }
                break;
            default:
                System.out.println("No existe esa funcion");
                break;
        }

    }

    public void consultarProductosClientes() {
        System.out.println("Total de clientes: " + listaClientes.size());
        int totalProductos = productoLimpieza.size() + productoElectrodomestico.size() + productoAlimento.size()
                + productoCosmetico.size();
        System.out.println("Total de productos: " + totalProductos);
    }

    public void realizarCompra() {
        System.out.println("COMPRA");
        System.out.print("Ingrese su ID: ");
        int id = leer.nextInt();
        int seguirComprando = 0;
        Cliente cliente = obtenerCliente(id);
        if (cliente != null) {
            do {
                System.out.println("Elija el tipo de producto que desea comprar");
                System.out.println("1. Limpieza");
                System.out.println("2. Electrodomesticos");
                System.out.println("3. Alimentos");
                System.out.println("4. Cosmeticos");

                System.out.print("Ingrese el id del producto que desea comprar: ");
                int idProducto = leer.nextInt();

                if (Producto(idProducto)) {

                    leer.nextLine();
                    System.out.print("Escriba la fecha de compra: ");
                    String fecha = leer.nextLine();
                    Compra newCompra = new Compra(fecha);
                    cliente.setRealizoCompra(true);
                    Producto productoComprado = obtenerProducto(idProducto);
                    newCompra.agregarProducto(productoComprado);
                    productoComprado.setSeCompro(true);
                    listaCompras.add(newCompra);
                    System.out.println("Compra realizada: " + newCompra.getIdCompra());

                } else {
                    System.out.println("Producto inexistente");
                }

                System.out.println("Desea realizar mas compras? \n1.Si \t 2.No");
                seguirComprando = leer.nextInt();
            } while (seguirComprando != 2);

        } else {
            System.out.println("El cliente no se encuentra en la lista de registros");
        }
    }

    public Cliente obtenerCliente(int id) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public boolean Producto(int idProducto) {
        for (Producto producto : productosTotales) {
            if (producto.getNumeroSerie() == idProducto) {
                return true;
            }
        }
        return false;
    }

    public Producto obtenerProducto(int idProducto) {
        for (Producto producto : productosTotales) {
            if (producto.getNumeroSerie() == idProducto) {
                return producto;
            }
        }
        return null;
    }

    public void verCompras() {
        System.out.println("Esta es la lista de compras");
        for (Compra compra : listaCompras) {
            compra.mostrarInfoCompra();
        }
    }

    public void eliminarCliente() {
        System.out.print("Ingresa el id del cliente que desea a eliminar: ");
        int id = leer.nextInt();
        Cliente cliente = obtenerCliente(id);
        if (cliente != null && !cliente.isRealizoCompra()) {
            listaClientes.remove(cliente);
            System.out.println("Se elimino el cliente");
        } else {
            System.out.println("No existe el cliente ingresado");
        }
    }

    public void eliminarProducto()
    {
        System.out.print("Ingresa el id del producto que desea eliminar: ");
        int id = leer.nextInt();

        Producto producto = obtenerProducto(id);
        if (producto != null && !producto.seCompro)
        {
            producto.setSeCompro(false);
            productosTotales.remove(producto);
            productoLimpieza.remove(producto);
            productoElectrodomestico.remove(producto);
            productoAlimento.remove(producto);
            productoCosmetico.remove(producto);


            System.out.println("Producto eliminado");
        } else {
            System.out.println("Este producto no se ha registrado");
        }
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //  ArrayIndexOutOfBoundsException
//        La excepción ArrayIndexOutOfBoundsException se produce cuando intentas acceder a un índice
//        que está fuera del rango válido de un arreglo (array) en Java.
//        Por ejemplo, supongamos que tienes un arreglo de tamaño 3 y tratas de acceder al índice 3 o superior
//        (los índices válidos van de 0 a n-1, donde n es el tamaño del arreglo). Esto provocará que se lance
//        una ArrayIndexOutOfBoundsException.
//        Esta excepción es comúnmente encontrada cuando se itera sobre un arreglo y se accede a elementos fuera del
//        rango establecido.

        int[] array = {1, 2, 3};
        try {
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        //  ConcurrentModificationException
//        La excepción ConcurrentModificationException se produce en Java cuando se intenta modificar una colección
//        (como un ArrayList, HashMap, etc.) de manera concurrente, es decir, mientras se está iterando sobre ella.
//        Esta excepción se produce debido a que la mayoría de las implementaciones de las colecciones en
//        Java no son thread-safe, lo que significa que no están diseñadas para manejar operaciones de modificación
//        mientras se están realizando operaciones de iteración en paralelo.

        try {
            List<String> lista = new ArrayList<>();
            lista.add("A");
            lista.add("B");
            for (String item : lista) {
                lista.remove(item);
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException: " + e.getMessage());
        }

        //  ArithmeticException
//        La excepción ArithmeticException se produce en Java cuando ocurre una operación aritmética inválida.
//        Esta excepción es lanzada en situaciones donde se produce un error aritmético durante la ejecución de un
//        programa, como por ejemplo la división por cero.

        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        //  NumberFormatException
//        La excepción NumberFormatException se produce en Java cuando se intenta convertir una cadena (String)
//        a un tipo numérico (como int, double, float, etc.), pero la cadena no tiene un formato válido para ese
//        tipo numérico.

        try {
            String str2 = "abc";
            int num = Integer.parseInt(str2);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }

        //  FileNotFoundException
//        La excepción FileNotFoundException se produce en Java cuando se intenta acceder a un archivo que no
//        existe en el sistema durante operaciones de lectura o escritura de archivos.
//        Esta excepción es lanzada por clases relacionadas con operaciones de entrada y salida (I/O),
//        como FileInputStream, FileOutputStream, FileReader, FileWriter, entre otras, cuando intentan abrir un
//        archivo para lectura o escritura, pero el archivo especificado no se encuentra en la ubicación indicada
//        o no tiene permisos de lectura.

        try {
            FileInputStream fis = new FileInputStream("archivo_que_no_existe.txt");
        } catch (IOException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }

        //  IOException
//        La excepción IOException se utiliza en Java para representar cualquier tipo de error que pueda ocurrir
//        durante operaciones de entrada y salida (I/O). Esta excepción es una clase base para otras excepciones
//        más específicas relacionadas con operaciones de I/O, como la lectura o escritura de archivos, el acceso
//        a recursos de red, la manipulación de flujos de datos, entre otros.

        try {
            BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"));
            String line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        //  ClassNotFoundException
//        La excepción ClassNotFoundException se produce en Java cuando se intenta cargar dinámicamente una
//        clase en tiempo de ejecución utilizando el método Class.forName() o la reflexión, pero la clase especificada
//        no se encuentra en el classpath del programa.
//        El classpath es la lista de directorios y archivos JAR donde Java busca las clases necesarias para la
//        ejecución de un programa. Si una clase no se encuentra en el classpath, Java no puede cargarla y lanzará
//        una ClassNotFoundException.

        try {
            Class.forName("ClaseQueNoExiste");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }

        //  InterruptedException
//        La excepción InterruptedException se produce en Java cuando un hilo (thread) en ejecución es
//        interrumpido por otro hilo mediante la llamada al método interrupt().
//        Esta excepción se utiliza comúnmente para manejar situaciones en las que un hilo está esperando
//        (sleep(), wait(), join(), etc.) y otro hilo interrumpe su ejecución antes de que termine el tiempo de espera.

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        }

        //  SecurityException
//        La excepción SecurityException se produce en Java cuando se intenta realizar una operación de seguridad que
//        está restringida por el Administrador de Seguridad de Java.
//        Java cuenta con un sistema de seguridad que controla el acceso a recursos sensibles del sistema,
//        como el acceso al sistema de archivos, la creación de sockets de red, la modificación de propiedades
//        del sistema, entre otros. Esta excepción se lanza cuando un programa intenta realizar una operación que está
//        prohibida por las políticas de seguridad establecidas.

        try {
            System.setProperty("java.home", "/nuevo/directorio");
        } catch (SecurityException e) {
            System.out.println("SecurityException: " + e.getMessage());
        }

        //  NullPointerException
//        La excepción NullPointerException es una de las excepciones más comunes en Java y se produce cuando
//        intentas acceder a un método o propiedad de un objeto que no ha sido inicializado, es decir, su valor es null.
//        En Java, null es un valor especial que se puede asignar a cualquier referencia de objeto para indicar que no
//        apunta a ningún objeto válido en memoria. Cuando intentas acceder a métodos o propiedades de un objeto que
//        es null, se lanza una NullPointerException.

        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
    }
}
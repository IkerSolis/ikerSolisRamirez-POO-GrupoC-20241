package tarea.pkg3.unidad.pkg2;
public class Tarea3Unidad2 {

    public static void main(String[] args) {
        
        //Punto uno
        System.out.println("---Personas---");
        person Person1 = new person("Shrek", 21, "Angry", "Ogre");
        System.out.println("Name: " +Person1.name);
        System.out.println("Age: " +Person1.age);
        System.out.println("Feeling Status: " +Person1.feelingStatus);
        System.out.println("Gender: " +Person1.gender);
        System.out.println();
        
        person Person2 = new person("Goku", 45, "Excited", "Saiyajin");
        System.out.println("Name: " +Person2.name);
        System.out.println("Age: " +Person2.age);
        System.out.println("Feeling Status: " +Person2.feelingStatus);
        System.out.println("Gender: " +Person2.gender);
        System.out.println();
        
        person Person3 = new person("Carl Johnson", 24, "Gangsta", "Male");
        System.out.println("Name: " +Person3.name);
        System.out.println("Age: " +Person3.age);
        System.out.println("Feeling Status: " +Person3.feelingStatus);
        System.out.println("Gender: " +Person3.gender);
        System.out.println();
        
        person Person4 = new person("Venom", 35, "Hungry", "Symbiote");
        System.out.println("Name: " +Person4.name);
        System.out.println("Age: " +Person4.age);
        System.out.println("Feeling Status: " +Person4.feelingStatus);
        System.out.println("Gender: " +Person4.gender);
        System.out.println();
        
        //Punto dos
        
        System.out.println("---Libros---");
        libro libro1 = new libro(); 
        System.out.println("Titulo: " +libro1.tittle);
        System.out.println("Autor: " +libro1.author);
        System.out.println("Anio de publicacion: " +libro1.yearPublication);
        System.out.println();
        
        libro libro2 = new libro();
        libro2.tittle = "A la mitad del camino";
        libro2.author = "Andres Manuel Lopez Obrador";
        libro2.yearPublication = 2021;
        System.out.println("Titulo: " +libro2.tittle);
        System.out.println("Autor: " +libro2.author);
        System.out.println("Anio de publicacion: " +libro2.yearPublication);
        System.out.println();
        
        libro libro3 = new libro();
        libro3.tittle = "Berserk";
        libro3.author = "Kentaro Miura";
        libro3.yearPublication = 1997;
        System.out.println("Titulo: " +libro3.tittle);
        System.out.println("Autor: " +libro3.author);
        System.out.println("Anio de publicacion: " +libro3.yearPublication);
        System.out.println();
        
        libro libro4 = new libro();
        libro4.tittle = "El negociador: Consejos para triunfar en la vida y en los negocios";
        libro4.author = "Arturo Elias Ayub";
        libro4.yearPublication = 2021;
        System.out.println("Titulo: " +libro4.tittle);
        System.out.println("Autor: " +libro4.author);
        System.out.println("Anio de publicacion: " +libro4.yearPublication);
        System.out.println();
        
        //Punto tres
        System.out.println("---Rectangulos---");
        rectangulo Rectangulo1 = new rectangulo(21,50);
        System.out.println("Area primer rectangulo: " +Rectangulo1.area());
        System.out.println();
        
        rectangulo Rectangulo2 = new rectangulo(30.5,2.5);
        System.out.println("Area segundo rectangulo: " +Rectangulo2.area());
        System.out.println();
        
        rectangulo Rectangulo3 = new rectangulo(100,25);
        System.out.println("Area tercer rectangulo: " +Rectangulo3.area());
        System.out.println();
        
        rectangulo Rectangulo4 = new rectangulo(27.2,10);
        System.out.println("Area cuarto rectangulo: " +Rectangulo4.area());
        System.out.println();
        
    }
    
}

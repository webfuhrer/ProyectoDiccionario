/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiccionario;

import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
public class EntradaSalida {
static Scanner sc=new Scanner(System.in);
    static int pedirOpcion() {//Opciones menu ppal
        System.out.println("1-Insertar palabra");
        System.out.println("2-Buscar palabra");       
        System.out.println("3-SALIR");
        int opcion=sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    static Palabra pedirPalabra() {//insertar palabra nueva
        System.out.println("Introduzca la palabra en inglés");
        String ing=sc.nextLine();
        System.out.println("Introduzca la palabra en español");
        String esp=sc.nextLine();
        
        Palabra p=new Palabra(esp, ing);
        return p;
    }

    static int seleccionarIdioma() {//Opciones submebu esp-ing/ing-esp
        System.out.println("1-Español-inglés");
        System.out.println("2-Inglés-español");       
        
        int opcion=sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    static String pedirPalabraIdioma() {//Preguntar la palabra para traducir
        System.out.println("Introduzca la palabra para traducir:");
        String palabra=sc.nextLine();
        return palabra;
    }

    static void mostrarPalabra(Palabra p) {//Muestra la palabra
        if(p!=null)//Esto pasa cuando la palbra no está en el diccionario
        {
            if (p.getPalabra_esp()!=null)
            {
                System.out.println(p.getPalabra_esp());
            }
            else
            {
                System.out.println(p.getPalabra_ing());
            }
               
        }
        else
        {
            System.out.println("La palabra no existe");
        }
    }
    
}

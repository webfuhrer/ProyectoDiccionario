/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiccionario;

/**
 *
 * @author Mañanas
 */
public class Proyectodiccionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccesoBD.crearTabla();
        int opcion=EntradaSalida.pedirOpcion();
        
        while(opcion!=3)
        {
            switch (opcion)
            {
                case 1:
                    Palabra p=EntradaSalida.pedirPalabra();
                    AccesoBD.insertarPalabra(p);
                    break;
                    //insertar
                case 2:
                    //int opcion_idioma=EntradaSalida.seleccionarIdioma();
                    //1-esp-ing
                    //2-ing-esp
                    String palabra_buscada=EntradaSalida.pedirPalabraIdioma();
                    Palabra p2=AccesoBD.buscarPalabra(palabra_buscada);
                    EntradaSalida.mostrarPalabra(p2);
                    break;
                    //buscar
                
            }
            opcion=EntradaSalida.pedirOpcion();
        }
    }
    
}

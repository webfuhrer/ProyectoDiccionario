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
public class Palabra {
    private String palabra_esp, palabra_ing;

    public Palabra(String palabra_esp, String palabra_ing) {
        this.palabra_esp = palabra_esp;
        this.palabra_ing = palabra_ing;
    }

    public String getPalabra_esp() {
        return palabra_esp;
    }

    public String getPalabra_ing() {
        return palabra_ing;
    }
    
}

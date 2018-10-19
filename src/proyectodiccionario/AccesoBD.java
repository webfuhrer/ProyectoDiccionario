/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiccionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class AccesoBD {
     static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/diccionario?user=root";
/*  private int magnitud, estacion;
    private String fecha;
    private ArrayList<String> datos_contaminacion;*/
    public static void crearTabla()
    {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
        String query="CREATE TABLE IF NOT EXISTS t_palabras("
                + "ingles varchar(20),"
                + "espanol varchar(20)"
                + ");";
            
                
                try {
                    Connection conexion=DriverManager.getConnection(url);
                    Statement stmt=conexion.createStatement();
                    stmt.executeUpdate(query);
                    stmt.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void insertarPalabra(Palabra p) {
         try {
             Connection c=DriverManager.getConnection(url);
             Statement stmt=c.createStatement();
             String query="INSERT INTO t_palabras values ('"+p.getPalabra_ing()+"', "
                     + "'"+p.getPalabra_esp()+"')";
           stmt.executeUpdate(query);
           stmt.close();
           c.close();
         } catch (SQLException ex) {
             Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    static Palabra buscarPalabra(String palabra_buscada) {
       //1-Español-ingles
       //2-Ingles-español
       Palabra p=null;
    
       String query="SELECT * FROM t_palabras WHERE"
               + " espanol='"+palabra_buscada+"' OR ingles='"+palabra_buscada+"'";
     
         try {
             Connection c=DriverManager.getConnection(url);
             Statement stmt=c.createStatement();
             ResultSet rs=stmt.executeQuery(query);
             if(rs.next())
             {
             String palabra_ingles=rs.getString("ingles");
             String palabra_espanol=rs.getString("espanol");
             if(palabra_buscada.equals(palabra_ingles))
             {
                 //Me habian metido una palabra en ingles
                 palabra_ingles=null;
             }
             else
             {
                 //Me habian metido una palabra en español
                 palabra_espanol=null;
             }
             
             p=new Palabra(palabra_espanol, palabra_ingles);
             }
         } catch (SQLException ex) {
             Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
         }
       return p;
    }
}

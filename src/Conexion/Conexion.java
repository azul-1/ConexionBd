
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexion {
    
    Connection conn = null;
    String bd = "registros";
    String user = "root";
    String pass = "123456";
    String ip = "localhost";
    String puerto = "3306";
    Statement st = null;
    ResultSet rs = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    
    String cadena = "jdbc:mysql://"+
            ip + ":" + puerto + "/" + bd;
   public Connection estableceConexion() {
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(cadena, user, pass);
            st = conn.createStatement();
            rs=st.executeQuery("SELECT * FROM alumnos");
          
            while(rs.next())
            {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                int edad = rs.getInt(4);
                  System.out.println("id del alumno: "+id);
                  System.out.println ("Nombre: " + nombre);
                  System.out.println ("Apellido: " + apellido);
                  System.out.println ("Edad: " + edad);
                  System.out.println ("-------------------------");
            }
            JOptionPane.showMessageDialog(null, "conexion exitosa ");
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null, "No se coneco a la base de datos " + e.toString());
        }
   return conn;
    }
   }

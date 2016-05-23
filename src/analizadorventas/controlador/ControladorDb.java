/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorventas.controlador;

import analizadorventas.modelo.Transaccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;


/**
 *
 * @author root
 */
public class ControladorDb {
    private static Connection conexiondb =null; 
    private ControladorDb(){};
    
    public static Connection getConexiondb(){
        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        if (conexiondb == null){
            try {
                ResourceBundle rb = ResourceBundle.getBundle("sqlite");
                String url = rb.getString("url");
                String driver = rb.getString("driver");
                Class.forName(driver);
                SQLiteConfig config = new SQLiteConfig();
                conexiondb= DriverManager.getConnection(url,config.toProperties());
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ControladorDb.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return conexiondb;
    }
    
    public static int actualizarRegistro(Connection con, Transaccion t, int registro){
        PreparedStatement s;
        String sentencia;
        return 0;
    }
    
    public static void primeraInsercion(Connection con, List<Transaccion> lista){
        for (Transaccion t : lista) {
        String sql = "INSERT INTO transaccion VALUES"
                + "(null,"+"'"+t.getNombreCliente()+"',"+t.getPrecio()+",'"+t.getProductoComprado()+"',"+t.getFechaParseada()+",'"+t.getCiudad()+"')";
        }
    }
    
    public static void crearTablaTransaccion(Connection con){
        Statement s;
        String sentencia = "CREATE TABLE IF NOT EXISTS transaccion("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT"
                + "precio INTEGER"
                + "producto TEXT"
                + "fecha DATE"
                + "ciudad TEXT)";
        try {
            s=con.createStatement();
            s.executeUpdate(sentencia);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static class ShutdownHook extends Thread{

        @Override
        public void run() {
            if (conexiondb!=null){
                try {
                    conexiondb.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
            
    }
}
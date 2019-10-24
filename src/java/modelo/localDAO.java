/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author irving
 */
public class localDAO {
    
    public static localDTO Register(localDTO bean){
        
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        Statement stmt = null;
        try
        {
            
              String descripcion= bean.getNombre();
              String direccion = bean.getDireccion();
              String codigo= bean.getCodigo();
              String ubigeo= bean.getUbigeo();

 
            String sql="INSERT INTO `local_votacion` (`descripcion`,`direccion`, `codigo`, `ubigeo`) VALUES ('"+
                    descripcion+"', '"+direccion+"', '"+codigo+"','"+ubigeo+"')";

            System.out.println("Query: "+ sql);
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            ps.execute();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(cn != null) cn.close();
            }
            catch(Exception e2)
            {
                e2.printStackTrace();
            }
        }

        return bean;
        
       
    }

    
}

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
public class electoresDAO {
    
    public static electoresDTO Register(electoresDTO bean){
        
        
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try
        {
            
            String userFirstname=bean.getFirstName();
            String userLastname=bean.getLastName();
            String dni=bean.getDni();

            String sql="INSERT INTO `persona` (`dni`,`nombres`, `apellidos`, `ubigeo`, `direccion`, `sexo`, `estado_civil`, `fecha_caducidad`, `foto`, `firma`, `huella_digital`) VALUES ('"+dni+"', '"+userFirstname+"', '"+userLastname+"','123','asd','asd','asd','05/05/19','asd','asd','asd')";
            System.out.println("Your user Firstname is "+ userFirstname);
            System.out.println("Your user Lastname is "+ userLastname);
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

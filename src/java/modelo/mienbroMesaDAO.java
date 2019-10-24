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
public class mienbroMesaDAO {
    
    public static mienbroMesaDTO Register(mienbroMesaDTO bean){
        
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try
        {
            
            String id_mienbro =bean.getIdPersona();
            String id_persona = bean.getIdPersona();
            String tipo = bean.getTipo();
            String descripcion = bean.getDescripcion();
            String id_mesa= bean.getIdMesa();

 
            String sql="INSERT INTO `mienbro_mesa` (`id_mienbro`,`id_persona`, `tipo`, `descripcion`,`id_mesa`) VALUES ('"+
                    id_mienbro+"', '"+id_persona+"', '"+tipo+"','"+descripcion+"','"+id_mesa+"')";

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

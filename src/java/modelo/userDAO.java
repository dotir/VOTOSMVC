/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author irving
 */
public class userDAO {
    
    static Connection currenctCon= null;
    static ResultSet rs = null;
    
    public static userDTO login(userDTO bean){
        
        Statement stmt = null;
        
        String username = bean.getUsername();
        String password = bean.getPassword();

        String searchQuery =
                "SELECT * FROM administrador a inner join persona p on a.id_persona=p.id_persona "
                + "where a.usuario='"+
                username+"' AND contraseña='"+
                password+"';";
        
        System.out.println(searchQuery);
        
        try{
            
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more= rs.next();
            
            if(!more){
                System.out.println("No esta registrado");
                bean.setValid(false);
            }
            
            do{
                
                String nombre = rs.getString("nombres");
                bean.setFirstName(nombre);
                String apellido = rs.getString("apellidos");
                bean.setLastName(apellido);
                bean.setValid(true);
            }while(rs.next());
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        finally{
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    rs=null;
                }  
            }
            if(stmt != null){
                try{
                    stmt.close();
                }catch(Exception e){
                    stmt=null;
                }  
            }
            if(currenctCon != null){
                try{
                    currenctCon.close();
                }catch(Exception e){
                    currenctCon=null;
                }  
            }
        }
        return bean;
    }
    
    public static userDTO Register(userDTO bean){
        
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        Statement stmt = null;
        try
        {
            
            String userFirstname=bean.getFirstName();
            String userLastname=bean.getLastName();
            String username=bean.getUsername();
            String password=bean.getPassword();
            String dni=bean.getDni();
            bean.setValid(true);
            //INSERT INTO `persona` (`id_persona`, `dni`, `nombres`, `apellidos`, `ubigeo`, `direccion`, `sexo`, `estado_civil`, `fecha_caducidad`, `foto`, `firma`, `huella_digital`) VALUES (NULL, '', '', '', '', '', '', '', '', '', '', '')
            String sql="INSERT INTO `persona` (`dni`,`nombres`, `apellidos`, `ubigeo`, `direccion`, `sexo`, `estado_civil`, `fecha_caducidad`, `foto`, `firma`, `huella_digital`) VALUES ('"+dni+"', '"+userFirstname+"', '"+userLastname+"','123','asd','asd','asd','05/05/19','asd','asd','asd')";
            String sql2="INSERT INTO `administrador` (`usuario`, `contraseña`, `id_persona`, `valid`) VALUES ('"+username+"', '"+password+"',1,1)";
            System.out.println("Your user Firstname is "+ userFirstname);
            System.out.println("Your user Lastname is "+ userLastname);
            System.out.println("Your user name is "+ username);
            System.out.println("Your password is " + password);
            System.out.println("Query: "+ sql);
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            System.out.println(sql2);
            ps = cn.prepareStatement(sql);
            ps2 = cn.prepareStatement(sql2);
            ps.execute();
            ps2.execute();
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
                if(ps2 != null) ps2.close();
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

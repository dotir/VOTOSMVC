/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.mesaDAO;
import modelo.mesaDTO;
import modelo.mienbroMesaDAO;
import modelo.mienbroMesaDTO;

/**
 *
 * @author irving
 */
@WebServlet(name = "MienbroMesaRegister", urlPatterns = {"/MienbroMesaRegister"})
public class MienbroMesaRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        mienbroMesaDTO user = new mienbroMesaDTO();

              //JSON  //////////////////////////////////////////////////////////////////////      
            String data_json = request.getParameter("text_json").trim();
            JsonObject jobj = new Gson().fromJson(data_json, JsonObject.class);
            String id_persona = jobj.get("id_persona").getAsString();
            String tipo = jobj.get("tipo").getAsString();
            String descripcion = jobj.get("descripcion").getAsString();
            String id_mesa = jobj.get("id_mesa").getAsString();
            
            
            user.setIdPersona(id_persona);
            user.setTipo(tipo);
            user.setDescripcion(descripcion);
            user.setIdMesa(id_mesa); 

        mienbroMesaDAO.Register(user);
        Gson g = new Gson();
        String jsonResult = g.toJson(user);
     
        PrintWriter writer = response.getWriter();
        writer.print(jsonResult);
        writer.flush();
        writer.close(); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

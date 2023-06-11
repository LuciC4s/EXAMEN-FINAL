/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoKardex;
import org.model.ModelKardex;

/**
 *
 * @author Lucia Pérez
 */
@WebServlet(name = "ControllerKardex", urlPatterns = {"/ControllerKardex"})
public class ControllerKardex extends HttpServlet {
DaoKardex dao = new DaoKardex();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerKardex</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerKardex at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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
        String action = request.getParameter("action");
        switch (action) {
            case "insert":

                ModelKardex modelKardex = new ModelKardex();

                modelKardex.setIdProducto(Integer.parseInt(request.getParameter("ID_PRODUCTO")));
                modelKardex.setDesccripcion(request.getParameter("DESCRIPCION"));
                modelKardex.setCantidad(Integer.parseInt(request.getParameter("CANTIDAD")));
                modelKardex.setExistencia(1);
                modelKardex.setFecha("2023-10-06 00:00:00.0");
                modelKardex.setIdTipoMovimiento(Integer.parseInt(request.getParameter("ID_TIPO_MOVIMIENTO")));
                modelKardex.setIdUsuario(Integer.parseInt(request.getParameter("ID_USUARIO")));
                boolean inserto = dao.insertar(modelKardex);
                //List listar

                break;
        }
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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

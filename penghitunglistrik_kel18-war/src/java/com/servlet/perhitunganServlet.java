/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.penghitunglistrik;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bleezy
 */
public class perhitunganServlet extends HttpServlet {

    @EJB
    private penghitunglistrik penghitunglistrik;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-grid.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-grid.min.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-reboot.css\" />");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-reboot.min.css\" />");
            out.println("<script href=\"js/bootstrap.bundle.js\" > </script>");
            out.println("<script href=\"js/bootstrap.bundle.min.js\" > </script>");
            out.println("<script href=\"js/bootstrap.js\" > </script>");
            out.println("<script href=\"js/bootstrap.min.js\" > </script>");
            out.println("</head>");
            out.println("<body class=\"container\">");
            out.println("<nav class=\"navbar navbar-expand-sm bg-primary navbar-dark\">\n" +
            "  <a class=\"navbar-brand\" href=\"#\">RSBK</a>\n" +
            "</nav>");
            out.println("<br/>");
            out.println("<div class=\"container\">\n" +
"  <div class=\"jumbotron\">\n" +
"    <h1>Tugas RSBK Modul 2 Kelompok 18</h1>      \n" +
"    <p>Program penghitung tagihan pembayaran listrik per bulan</p>\n" +
"  </div>   \n" +
"</div>");
            String daya = request.getParameter("daya");
            String waktu = request.getParameter("waktu");
            
            if ((daya != null) && (daya.length() > 0)&& (waktu != null) && (waktu.length() > 0)) {
                double d = Double.parseDouble(daya);
                double w = Double.parseDouble(waktu);
                if (request.getParameter("Perhitungan Listrik") != null){
                    String tagihan = penghitunglistrik.perhitunganlistrik(d, w);
                    out.println("<div class=\"alert alert-danger\" role=\"alert\">\n" +
                          "  Segera lakukan pembayaran !\n" +
                           "</div>");
                    out.println("<p> Total Tagihan: RP. "+tagihan+"</p>");
                }  
                
            } else {
                out.println("<center>");
                out.println("<p>Masukan Daya(Watt):</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"daya\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<p>Masukan Waktu Pemakaian(/jam):</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"waktu\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" class=\"btn btn-info\" name=\"Perhitungan Listrik\" value=\"Perhitungan Listrik\">");
               
                out.println("<br/>");
            }
        
        } finally {
            out.println("<br/>");
            out.println("</center>");
            out.println("</body>");
            out.println("</head>");
            out.println("</html>");
            out.close();
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

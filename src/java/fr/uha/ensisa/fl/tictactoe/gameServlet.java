/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.uha.ensisa.fl.tictactoe;

import java.io.IOException;
import static java.lang.Math.random;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Florent
 */
@WebServlet(name = "gameServlet", urlPatterns = {"/gameServlet"})
public class gameServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //Recup model
            TicTacToe ttt = (TicTacToe) request.getSession().getAttribute("model");
            
            //user play
            ttt.setStateCell(TicTacToe.State.CROSS, Integer.parseInt(request.getParameter("x")), Integer.parseInt(request.getParameter("y")));
            
            //user win ?
            if(ttt.win()) { 
                request.getSession().setAttribute("win", "me");
                request.getRequestDispatcher("/game.jsp").forward(request, response);
            }
            
            //init computer play
            int newIntX = Integer.parseInt(request.getParameter("x"));
            int newIntY = Integer.parseInt(request.getParameter("y"));

            //computer play
            if(ttt.haveCellEmpty()) {
                while(ttt.getStateCell(newIntX,newIntY)!=TicTacToe.State.EMPTY){
                    newIntX = (int)(random()*100)%3;
                    newIntY = (int)(random()*100)%3;
                }
                ttt.setStateCell(TicTacToe.State.RING, newIntX, newIntY);
            }
            
            //computer win ?
            request.getSession().setAttribute("model", ttt);
            if(ttt.win()) { 
                request.getSession().setAttribute("win", "computer");
            }
            
            //return at game !
            request.getRequestDispatcher("/game.jsp").forward(request, response);            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

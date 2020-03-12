package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.beanes.Client;
import com.beanes.ClientService;
import com.beanes.Compte;
import com.beanes.CompteService;

/**
 * Servlet implementation class nouveauCompte
 */
@WebServlet("/nouveauCompte")
public class nouveauCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nouveauCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();
		try {
			Client client = (Client) session.getAttribute("client");
			Compte compte = new Compte();
			compte.setCpt_compte(request.getParameter("libelle"));
			compte.setCpt_solde(Float.valueOf(request.getParameter("solde")));
			compte.setCpt_statut(request.getParameter("statut"));
			compte.setCpt_client(client);
			
			CompteService compteService = new CompteService();
			compteService.addCompte(compte);
			
			response.sendRedirect("clientInfo");

		} catch (Exception e) {
			e.fillInStackTrace();
			// TODO: handle exception
		}
		
	}

}

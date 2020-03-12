package com.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class clientInfo
 */
@WebServlet("/clientInfo")
public class clientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		Client client = (Client) session.getAttribute("client");
		CompteService compteService = new CompteService();
		List<Compte> comptes = compteService.Comptes(client);
		
		try {
			int compte_id;
			Compte compte;
			String param = request.getParameter("action");
			switch (param) {
			case "supprimer":
				compte_id = Integer.valueOf(request.getParameter("compteId"));
				compte = findCompte(comptes, compte_id);
				compteService.removeCompte(compte);
				comptes = compteService.Comptes(client);
				break;
			case "modifier":
				compte_id = Integer.valueOf(request.getParameter("compteId"));
				compte = findCompte(comptes, compte_id);
				compte.setCpt_compte(request.getParameter("libelle"));
				compte.setCpt_solde(Float.valueOf(request.getParameter("solde")));
				compte.setCpt_statut(request.getParameter("statut"));
				compteService.updateCompte(compte);
				comptes = compteService.Comptes(client);
				
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.fillInStackTrace();
		}

		
		request.setAttribute("comptes", comptes);
		
		request.getRequestDispatcher("clientInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	Compte findCompte(List<Compte> cpts, int byId) {
	    for(Compte cpt : cpts) {
	        if(cpt.getCpt_compte_id() == byId) {
	            return cpt;
	        }
	    }
	    return null;
	}

}

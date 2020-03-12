package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beanes.Client;
import com.beanes.ClientService;
import com.beanes.Compte;
import com.beanes.CompteService;

/**
 * Servlet implementation class clientAdmin
 */
@WebServlet("/clientAdmin")
public class clientAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
HttpSession session = request.getSession();
		
		Client adminClient = (Client) session.getAttribute("client");
		ClientService clientService = new ClientService();
		List<Client> clients = clientService.Clients();
		
		try {
			int client_id;
			Client client;
			String param = request.getParameter("action");
			switch (param) {
			case "supprimer":
				client_id = Integer.valueOf(request.getParameter("clientId"));
				client = findClient(clients, client_id);
				clientService.removeCompte(client);
				clients = clientService.Clients();
				break;
			case "modifier":
				client_id = Integer.valueOf(request.getParameter("clientId"));
				client = findClient(clients, client_id);
//				client.setClt_email(request.getParameter("email"));
				client.setClt_mot_de_passe(request.getParameter("pwd"));
				client.setClt_nom(request.getParameter("nom"));
				client.setClt_prenom(request.getParameter("prenom"));;
				client.setClt_profile(request.getParameter("profile"));
				clientService.updateCompte(client);
				clients = clientService.Clients();
				
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.fillInStackTrace();
		}

		//response.getWriter().append("client: ").append(clients.toString());
		
		request.setAttribute("clients", clients);
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	Client findClient(List<Client> cpts, int byId) {
	    for(Client cpt : cpts) {
	        if(cpt.getClt_client_id() == byId) {
	            return cpt;
	        }
	    }
	    return null;
	}

}

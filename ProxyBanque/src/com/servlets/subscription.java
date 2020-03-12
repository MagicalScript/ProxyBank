package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beanes.*;

/**
 * Servlet implementation class subscription
 */
@WebServlet("/subscription")
public class subscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subscription() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		try {
			ClientService clientService = new ClientService();
			
			Client _clienAdmint = clientService.getAdminClient();
			
			if(_clienAdmint != null && request.getParameter("profile").equalsIgnoreCase("admin")) {
				
				request.setAttribute("errorProfile", "errorProfile");
				request.getRequestDispatcher("subscription.jsp").forward(request, response);
			}
			
			Client client = new Client();
			client.setClt_email(request.getParameter("email"));
			client.setClt_mot_de_passe(request.getParameter("pwd"));
			client.setClt_nom(request.getParameter("nom"));
			client.setClt_prenom(request.getParameter("prenom"));
			client.setClt_profile(request.getParameter("profile"));
			
			clientService.addClient(client);
			
			//response.getWriter().append("client: ").append(request.getParameter("profile"));
			
			response.sendRedirect("authentification.jsp");

		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
			// TODO: handle exception
		}
	}

}

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
 * Servlet implementation class authentification
 */
@WebServlet("/authentification")
public class authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		HttpSession session = request.getSession();

		try {
			ClientService clientService = new ClientService();
			Client client = new Client();
			client = clientService.LoginClient(
					request.getParameter("email"),
					request.getParameter("pwd"));
			
			//String test = Integer.toString(client.getClt_client_id()) ;
			
			//response.getWriter().append("client: ").append(test);
			if(client != null) {
				session.setAttribute("client", client);
				session.setMaxInactiveInterval(60*60);

				response.sendRedirect("clientInfo");
			}else {
				response.sendRedirect("authentification.jsp");
			}


		} catch (Exception e) {
			e.fillInStackTrace();
			// TODO: handle exception
		}
	}

}

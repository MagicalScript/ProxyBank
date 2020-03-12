package com.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beanes.Client;


@WebFilter(urlPatterns = {
		"/clientInfo",
		"/nouveauCompte.jsp"
    })
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
        // TODO Auto-generated constructor stub
    }

	
	private ServletContext context;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		try {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			
			String uri = req.getRequestURI();
			this.context.log("Requested Resource::"+uri);
			
			HttpSession session = req.getSession();
			
			if(((Client) session.getAttribute("client")) == null) {
				this.context.log("Unauthorized access request");
				res.sendRedirect("index.jsp");
			}else{
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			this.context.log(e.getMessage());
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
	}


}

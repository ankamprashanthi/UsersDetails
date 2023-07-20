package org.studyeasy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		page=page.toLowerCase();
		switch(page) {
		case "home":
			
			homePage(request,response);
			break;
		default:
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			break;
		}
	}
	protected void homePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    request.setAttribute("title", "HomePage");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	

}

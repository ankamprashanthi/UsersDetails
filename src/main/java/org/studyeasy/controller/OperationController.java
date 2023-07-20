package org.studyeasy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.studyeasy.entity.user;
import org.studyeasy.model.UsersModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project")
	private DataSource datasource;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		page=page.toLowerCase();
		switch(page) {
		
		case "listuser":
			listUsers(request,response);
			break;
		case "adduser":
			addUserFormLoader(request,response);
			break;
		case "updateuser":
			updateUserFormLoader(request,response);
			break;
		case "deleteuser":
			deletUser(Integer.parseInt(request.getParameter("userid")));
			listUsers(request,response);
			break;
		default:
			request.setAttribute("title","errorpage");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			break;
			
		}
	}
	
	private void deletUser(int userid) {
		new UsersModel().deleteuser(datasource,userid);
		return;
		
	}

	private void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "Update Users");
		try {
			request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form=request.getParameter("form");
		form=form.toLowerCase();
		switch(form)
		{
		case "adduseroperation":
			user newUser=new user( request.getParameter("username"),request.getParameter("email"));
			addUserOperation(newUser);
			listUsers(request,response);
			break;
		case "updateuseroperation":
			user updatedUser=new user(Integer.parseInt(request.getParameter("userid")),request.getParameter("username"),request.getParameter("email"));
		    updatedUserOperation(datasource,updatedUser);
		    listUsers(request,response);
		    break;
		 
		default:
			request.setAttribute("title","errorpage");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			break;
		
		}
		
	}
private void updatedUserOperation(DataSource datasource2, user updatedUser) {
		new UsersModel().updateUser(datasource,updatedUser);
		return;
		
	}

protected void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<user> listUsers=new ArrayList<>();
		listUsers=new UsersModel().listUsers(datasource);
		request.setAttribute("listUsers", listUsers);
		request.setAttribute("title","list of users");
		request.getRequestDispatcher("/listUser.jsp").forward(request, response);
	}

public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {	
	request.setAttribute("title", "Add User");
	request.getRequestDispatcher("addUser.jsp").forward(request, response);
}
	
private void addUserOperation(user newUser)
{
	new UsersModel().addUser(datasource,newUser);
	return;
}
}

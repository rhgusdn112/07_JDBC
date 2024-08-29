package edu.kh.jdbc.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.jdbc.dto.User;
import edu.kh.jdbc.service.UserService;
import edu.kh.jdbc.service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	try {
    	UserService service = new UserServiceImpl();
        
    	List<User> userList = service.userList();

        req.setAttribute("userList", userList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/selectAll.jsp");
        
        dispatcher.forward(req, resp);
    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}

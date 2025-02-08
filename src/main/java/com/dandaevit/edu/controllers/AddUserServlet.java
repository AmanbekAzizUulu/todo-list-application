package com.dandaevit.edu.controllers;

import java.io.IOException;

import com.dandaevit.edu.dto.UserDTO;
import com.dandaevit.edu.utils.jsp_utils.JSPUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO validate and add user to databas

		var firstName = req.getParameter("firstName");
		var lastName = req.getParameter("lastName");
		var email = req.getParameter("email");

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);

		var userDTO = new UserDTO(firstName, lastName, email);

		System.out.println(userDTO);
		
		req.getSession().setAttribute("user", userDTO);

		var userDTO_1 = req.getAttribute("user");
		System.out.println(userDTO_1);

		req.getRequestDispatcher(JSPUtils.getPath("successful-registration")).forward(req, resp);
	}
}

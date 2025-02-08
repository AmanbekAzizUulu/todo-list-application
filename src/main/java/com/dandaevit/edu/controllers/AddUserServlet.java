package com.dandaevit.edu.controllers;

import java.io.IOException;

import com.dandaevit.edu.model.User;
import com.dandaevit.edu.utils.jsp_utils.JSPUtils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO validate and add user to database

		var firstName = req.getParameter("firstName");
		var lastName = req.getParameter("lastName");
		var email = req.getParameter("email");

		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(email);

		var user = User.builder()
					   .id(1001)
		               .firstName("Aibek")
					   .lastName("Dandaev")
					   .email("aibekdandaev@gmail.com")
					   .password(BCrypt.withDefaults().hashToString(12, "password_1234567890".toCharArray()))
					   .build();

		System.out.println(user);

		req.getSession().setAttribute("user", user);

		var userDTO_1 = req.getAttribute("user");
		System.out.println(userDTO_1);

		req.getRequestDispatcher(JSPUtils.getPath("successful-registration")).forward(req, resp);
	}
}

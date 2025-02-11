package com.dandaevit.edu.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.dandaevit.edu.dto.UserDTO;
import com.dandaevit.edu.model.User;
import com.dandaevit.edu.service.user_service.UserServiceImplementation;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet {
	private UserServiceImplementation userServiceImplementation = new UserServiceImplementation();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var firstName = req.getParameter("firstName");
		var lastName = req.getParameter("lastName");
		var email = req.getParameter("email");
		var password = req.getParameter("password");

		var hashed_password = BCrypt.withDefaults().hashToString(12, password.toCharArray());

		var userDTO = UserDTO
							.builder()
		               		.firstName(firstName)
					   		.lastName(lastName)
					   		.email(email)
					   		.password(hashed_password)
					   		.build();
	    req.getSession().setAttribute("userDTO", userDTO);

		var user = User
						.builder()
						.firstName(firstName)
						.lastName(lastName)
						.email(email)
						.password(hashed_password)
						.build();

		var userId = userServiceImplementation.save(user);

		var user_1 = User
						.builder()
						.id(userId)
						.firstName(user.getFirstName())
						.lastName(user.getLastName())
						.email(user.getEmail())
						.password(user.getPassword())
						.userCode(user.getUserCode())
						.taskIds(user.getTaskIds() == null ? new ArrayList<Integer>() : user.getTaskIds())
						.build();


		req.getSession().setAttribute("user", user_1);

		resp.sendRedirect(req.getContextPath() + "/users/registration/successful-registration");
	}
}

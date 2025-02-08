package com.dandaevit.edu.controllers;

import java.io.IOException;

import com.dandaevit.edu.model.User;
import com.dandaevit.edu.model.task.Priorities;
import com.dandaevit.edu.model.task.Ratings;
import com.dandaevit.edu.model.task.Statuses;
import com.dandaevit.edu.model.task.Task;
import com.dandaevit.edu.service.task_service.TaskServiceImplementation;
import com.dandaevit.edu.utils.jsp_utils.JSPUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddTaskServlet extends HttpServlet {
	 private TaskServiceImplementation taskService = new TaskServiceImplementation();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JSPUtils.getPath("add-task")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Получаем данные из формы
		var title = req.getParameter("title");
		var description = req.getParameter("description");
		var status = req.getParameter("status");
		var priority = req.getParameter("priority");
		var rating = Integer.parseInt(req.getParameter("rating"));

		// Получаем текущего пользователя из сессии
		var session = req.getSession();
		var user = (User) session.getAttribute("user");

		// Создаем новую задачу
		var newTask = Task.builder()
						  .title(title)
						  .description(description)
						  .status(Statuses.valueOf(status))
						  .priority(Priorities.valueOf(priority))
						  .rating(Ratings.fromInteger(rating))
						  .build();

		// Сохраняем задачу в базу данных
		taskService.addTask(newTask, user.getId());

		// Перенаправляем обратно на страницу профиля
		resp.sendRedirect(req.getContextPath() + "/users/profile");
	}
}

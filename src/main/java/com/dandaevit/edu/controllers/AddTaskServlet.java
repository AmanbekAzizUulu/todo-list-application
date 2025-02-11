package com.dandaevit.edu.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.dandaevit.edu.dao.dao_factory.DAOFactory;
import com.dandaevit.edu.dao.task_dao.TaskDAOImplementation;
import com.dandaevit.edu.database_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.model.User;
import com.dandaevit.edu.model.task.Task;
import com.dandaevit.edu.service.user_task_service.UserTasksServiceImplementation;
import com.dandaevit.edu.utils.jsp_utils.JSPUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddTaskServlet extends HttpServlet {
	private UserTasksServiceImplementation userTaskServiceImplementation = new UserTasksServiceImplementation();
	private TaskDAOImplementation taskDAOImplementation = DAOFactory.getTaskDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JSPUtils.getPath("add-task")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Получаем данные из формы
		var title = req.getParameter("title");
		var description = req.getParameter("description");

		// Получаем текущего пользователя из сессии
		var user = (User) req.getSession().getAttribute("user");

		// Создаем новую задачу
		var task = Task
					   .builder()
					   .title(title)
					   .description(description)
					   .build();

		var taskId = taskDAOImplementation.save(task);

		var task_1 = Task
						.builder()
						.id(taskId)
						.title(task.getTitle())
						.description(task.getDescription())
						.build();


		user.getTaskIds().add(task_1.getId());
		userTaskServiceImplementation.addTask(task_1.getId(), user.getId());

		var userTasks = getUserTasks(user.getTaskIds());

		req.getSession().setAttribute("tasks", userTasks);

		// Перенаправляем обратно на страницу профиля
		resp.sendRedirect(req.getContextPath() + "/users/profile");
	}

	public List<Task> getUserTasks(List<Integer> userTasks) {
		if (userTasks.isEmpty()) {
			return Collections.emptyList(); // Если нет задач, возвращаем пустой список
		}

		// Генерируем плейсхолдеры для IN
		    // Генерируем плейсхолдеры "?, ?, ?, ..." по количеству элементов
		String placeholders = userTasks.stream()
									   .map(id -> "?")
			                           .collect(Collectors.joining(", "));

		String sql =	String.format(
		"""
			SELECT
				t.description,
				t.title
			FROM
				todo_list_application.user_tasks ut
			JOIN
				todo_list_application.tasks t
				ON t.id = ut.task_id
			WHERE
				t.id IN (%s)
			""", placeholders);

		sql.formatted(placeholders);

		System.out.println(sql);

		var tasks = new ArrayList<Task>();

		try (var connection = DatabaseConnectionManager.get();
			 var preparedStatement = connection.prepareStatement(sql)) {

			for (int i = 0; i < userTasks.size(); i++) {
				preparedStatement.setInt(i + 1, userTasks.get(i));
			}

			System.out.println(preparedStatement);

			try (var resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					var task = Task
								   .builder()
							       .description(resultSet.getString("description"))
							       .title(resultSet.getString("title"))
							       .build();

					tasks.add(task);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Ошибка при получении задач пользователя", e);
		}

		return tasks;
	}
}

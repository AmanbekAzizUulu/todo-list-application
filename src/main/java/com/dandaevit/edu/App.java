package com.dandaevit.edu;

import com.dandaevit.edu.model.task.Priorities;

public class App {
	private static final String INSERTION_QUERRY =
			"""
			INSERT INTO todo_list_application.users
				(
					first_name,
					last_name,
					email,
					password_hash
				)
			VALUES
				(
					?,
					?,
					?,
					?
				)
			RETURNING
				id;
			""";
	public static void main(String[] args) {
		Priorities priority = Priorities.HIGH_PRIORITY;

		System.out.println(priority.name());
	}
}

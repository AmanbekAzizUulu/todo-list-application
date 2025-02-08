package com.dandaevit.edu;

import java.sql.SQLException;

import com.dandaevit.edu.database_connection_manager.DatabaseConnectionManager;

import at.favre.lib.crypto.bcrypt.BCrypt;

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
		var hashed_password = BCrypt.withDefaults().hashToString(12, "password".toCharArray());

		try (var connection = DatabaseConnectionManager.get();) {

			var pstmt = connection.prepareStatement(INSERTION_QUERRY);

            pstmt.setString(1, "Aibek");
            pstmt.setString(2, "Dandaev");
            pstmt.setString(3, "aibekdandaev@gmail.com");
            pstmt.setString(4, hashed_password);

			var rs = pstmt.executeQuery();

			while (rs.next()) {
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}

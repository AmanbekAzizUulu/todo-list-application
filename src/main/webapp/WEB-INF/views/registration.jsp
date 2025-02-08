<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/styles/registration-form.css">

	<title>Регистрация</title>

</head>
<body>
	<% if ("email_exists".equals(request.getParameter("error"))) { %>
        <p style="color:red;">Ошибка: Email уже зарегистрирован!</p>
    <% } else if ("db_error".equals(request.getParameter("error"))) { %>
        <p style="color:red;">Ошибка сервера. Попробуйте позже.</p>
    <% } %>

    <div class="container">
        <h2>Регистрация пользователя</h2>
        <form action="${pageContext.request.contextPath}/users/register-user" method="post">

            <label for="user-first-name-registration-form">Имя:</label>
            <input type="text" id="user-first-name-registration-form" name="firstName" placeholder="Введите имя" required>

            <label for="user-last-name-registration-form">Фамилия:</label>
            <input type="text" id="user-last-name-registration-form" name="lastName" placeholder="Введите фамилию" required>

            <label for="user-email-registration-form">Email:</label>
            <input type="email" id="user-email-registration-form" name="email" placeholder="Введите email" required>

            <label for="user-password-registration-form">Пароль:</label>
            <input type="password" id="user-password-registration-form" name="password" placeholder="Введите пароль" required>

            <button type="submit">Зарегистрироваться</button>
        </form>
    </div>

</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/styles/index.css">

	<title>JustTodoIt - Главная страница</title>

</head>
<body>
    <header>
        <h1>JustTodoIt</h1>
        <p>Организуйте свои дела легко!</p>
    </header>


    <div class="auth-links">
        <a href="${pageContext.request.contextPath}/users/registration">Регистрация</a> |
        <a href="#">Войти</a>
    </div>

	<footer class="footer">
        <p>&copy; 2025 JustTodoIt. Все права защищены.</p>
        <p>
			<a href="#" class="footer-link">Политика конфиденциальности</a> |
			<a href="#" class="footer-link">Условия использования</a>
		</p>
    </footer>
</body>
</html>

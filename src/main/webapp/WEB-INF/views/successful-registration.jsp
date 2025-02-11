<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/styles/successful-registration.css">

    <title>Успешная регистрация</title>

</head>
<body>
	<h1>Поздравляем, регистрация прошла успешно!</h1>
    <p>Вы можете перейти в свой профиль или вернуться на главную страницу.</p>
	
    <!-- Кнопка для перехода в профиль -->
    <a href="${pageContext.request.contextPath}/users/profile" class="button">В профиль</a>

    <!-- Кнопка для перехода на главную -->
    <a href="${pageContext.request.contextPath}/index" class="button">На главную</a>
</body>
</html>

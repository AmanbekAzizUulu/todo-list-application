<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/styles/profile.css">

</head>
<body>
    <h1>User Profile</h1>

    <!-- Информация о пользователе -->
    <div class="profile-info">
        <p><label>First Name:</label> ${sessionScope.user.firstName()}</p>
        <p><label>Last Name:</label> ${sessionScope.user.lastName()}</p>
        <p><label>Email:</label> ${sessionScope.user.email()}</p>
    </div>


	<!-- Список задач пользователя -->
    <div class="tasks-list">
        <h2>Your Tasks</h2>
        <c:choose>
            <c:when test="${empty tasks}">
                <p>You have no tasks yet.</p>

				<!-- Кнопка для добавления задачи -->
    			<div class="add-task">
        			<a href="${pageContext.request.contextPath}/users/tasks/add-task">
            			<button>Add Task</button>
        			</a>
    			</div>
            </c:when>

            <c:otherwise>
                <table>
                    <tr>
                        <th>Task ID</th>
                        <th>Title</th>
                        <th>Status</th>
                        <th>Priority</th>
                        <th>Rating</th>
                    </tr>
                    <c:forEach items="${tasks}" var="task">
                        <tr>
                            <td>${task.taskId}</td>
                            <td>${task.title}</td>
                            <td>${task.status}</td>
                            <td>${task.priority}</td>
                            <td>
                                <c:if test="${task.status == 'COMPLETED'}">
                                    ${task.rating}
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>

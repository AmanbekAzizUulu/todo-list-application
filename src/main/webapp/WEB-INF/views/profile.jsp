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
        <p><label>First Name:</label> ${sessionScope.userDTO.firstName()}</p>
        <p><label>Last Name:</label> ${sessionScope.userDTO.lastName()}</p>
        <p><label>Email:</label> ${sessionScope.userDTO.email()}</p>
    </div>


	<!-- Список задач пользователя -->
	<div class="tasks-list">
	    <h2>Your Tasks</h2>

	<!-- Список задач пользователя -->
	<div class="tasks-list">
	    <c:choose>
	        <c:when test="${empty tasks}">
	            <p>You have no task yet.</p>

	            <!-- Кнопка для добавления задачи -->
	            <div class="add-task">
	                <a href="${pageContext.request.contextPath}/users/tasks/add-task">
	                    <button>Add Task</button>
	                </a>
	            </div>
	        </c:when>

	        <c:otherwise>
	            <table border="1">
	                <tr>
	                    <th>Title</th>
	                    <th>Description</th>
	                    <th>Priority</th>
	                    <th>Status</th>
						<th>Rating</th>
	                </tr>
	                <c:forEach var="task" items="${tasks}">
	                    <tr>
	                        <td>${task.title}</td>
	                        <td>${task.description}</td>


	                        <!-- Выпадающий список для приоритета -->
	                        <td>
								<a href="${pageContext.request.contextPath}/#"><!-- SetTaskPriorityServlet-->
	                   	 			<button>Set Priority</button>
	                			</a>
	                            <select>
	                                <option>LOW</option>
	                                <option>MIDDLE</option>
	                                <option>HIGH</option>
	                            </select>
								<br>
								<br>
	                        </td>

	                        <!-- Кнопка и выпадающий список статуса -->
	                        <td>
	                            <a href="${pageContext.request.contextPath}/#"><!-- SetTaskStatusServlet-->
	                   	 			<button>Set Status</button>
	                			</a>
	                            <select>
	                                <option>COMPLETED</option>
	                                <option>IN PROGRESS</option>
	                                <option>FAILED</option>
	                            </select>
								<br>
								<br>
	                        </td>

							<!-- Кнопка для оценки -->
	                        <td>
	                            <a href="${pageContext.request.contextPath}/#"><!-- SetTaskRateServlet-->
	                   	 			<button>Set Rate</button>
	                			</a>
	                            <select>
	                                <option>1</option>
	                                <option>2</option>
	                                <option>3</option>
	                                <option>4</option>
	                                <option>5</option>
	                            </select>
								<br>
								<br>
	                        </td>
	                    </tr>
	                </c:forEach>
	            </table>
				<br>
				<br>

	            <!-- Кнопка для добавления задачи -->
	            <div class="add-task">
	                <a href="${pageContext.request.contextPath}/users/tasks/add-task">
                    <button>Add Task</button>
	                </a>
	            </div>
	        </c:otherwise>
	    </c:choose>
	</div>
</body>
</html>

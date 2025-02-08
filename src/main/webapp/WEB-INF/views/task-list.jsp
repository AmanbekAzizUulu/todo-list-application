<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task List</title>
</head>
<body>
    <h1>Task List</h1>

    <!-- Форма для добавления новой задачи -->
    <%-- <form action="/tasks" method="post">
        <input type="hidden" name="action" value="add">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea>
        <label for="priority">Priority:</label>
        <select id="priority" name="priority">
            <option value="high">High</option>
            <option value="normal">Normal</option>
        </select>
        <button type="submit">Add Task</button>
    </form>

    <!-- Таблица с задачами -->
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
            <th>Priority</th>
            <th>Rating</th>
            <th>Date of Creation</th>
            <th>Last Updated</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.title}</td>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td>${task.priority}</td>
                <td>
                    <c:if test="${task.status == 'COMPLETED'}">
                        <form action="/tasks" method="post">
                            <input type="hidden" name="action" value="rate">
                            <input type="hidden" name="task_id" value="${task.taskId}">
                            <select name="rating">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                            <button type="submit">Rate</button>
                        </form>
                    </c:if>
                </td>
                <td>${task.dateOfCreation}</td>
                <td>${task.lastUpdatedDate}</td>
                <td>
                    <c:if test="${task.status != 'FAILED'}">
                        <form action="/tasks" method="post">
                            <input type="hidden" name="action" value="update-status">
                            <input type="hidden" name="task_id" value="${task.taskId}">
                            <select name="status">
                                <option value="in_progress">In Progress</option>
                                <option value="completed">Completed</option>
                                <option value="failed">Failed</option>
                            </select>
                            <button type="submit">Update Status</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table> --%>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add Task</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/styles/add-task.css">
</head>
<body>
    <h1>Add New Task</h1>

    <!-- Форма для добавления задачи -->
    <form action="${pageContext.request.contextPath}/users/tasks/add-task" method="post">

		<label for="task-title">Title:</label>
        <input type="text" id="task-title" name="title" required><br><br>

        <label for="task-description">Description:</label>
        <textarea id="task-description" name="description"></textarea><br><br>

        <%-- <!-- TODO переписать при помощи jstl -->
		<label for="task-status">Status:</label>
        <select id="task-status" name="status" required>
            <option value="COMPLETED">Completed</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="FAILED">Failed</option>
        </select><br><br> --%>

        <%-- <label for="task-priority">Priority:</label>
        <select id="task-priority" name="priority" required>
            <option value="HIGH_PRIORITY">High Priority</option>
            <option value="NORMAL_PRIORITY">Normal Priority</option>
            <option value="LOW_PRIORITY">Low Priority</option>
        </select><br><br> --%>

        <%-- <label for="task-rating">Rating:</label>
        <select id="task-rating" name="rating" required>
            <option value="1">5 — A</option>
            <option value="2">4 — B</option>
            <option value="3">3 — C</option>
            <option value="4">2 — D</option>
            <option value="5">1 — E</option>
        </select><br><br> --%>

        <button type="submit">Add Task</button>
    </form>
</body>
</html>

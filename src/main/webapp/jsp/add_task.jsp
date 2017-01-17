<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>New Task</title>
</head>
<body>
<div class="addTasks">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/task/newTask" method="post">
        <h3>Add task</h3>
        <input type="text" name="new_task" placeholder="add task" required><br>
        <h3>Add description</h3>
        <input type="text" name="new_description" placeholder="add description" ><br>
        <h3>Add start time</h3>
        <label>
            <input type="datetime-local" name="new_startTime" required>
        </label><br>
        <h3>Add end time</h3>
        <label>
            <input type="datetime-local" name="new_currentTime" required>
        </label><br>
        <h3>Add list for task</h3>
        <select name="new_list">
            <c:forEach items="${ListTasks}" var="listTasks">
                <option value="${listTasks.list_id}">${listTasks.list_name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Add Task"><br>
    </form>
</div>
</body>
</html>

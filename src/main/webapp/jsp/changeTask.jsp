<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>Change old task</title>
</head>

<body>
<div class="changeTask">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/task/${task.id}/changeTask" method="post">
        <input type="hidden" name="taskId" value="${task.id}"><br>
        <h3>Title</h3>
        <input type="text" name="title" value="${task.title}" placeholder="add title" required><br>
        <h3>Details</h3>
        <input type="text" name="details" value="${task.details}" placeholder="add details" required><br>
        <h3>Start Time</h3>
        <label>
            <input type="datetime-local" name="startTime" required>
        </label><br>
        <h3>End Time</h3>
        <label>
            <input type="datetime-local" name="endTime" required>
        </label><br>
        <h3>List name</h3>
        <select name="new_list">
            <c:forEach items="${ListTasks}" var="listTasks">
                <option value="${listTasks.list_id}">${listTasks.list_name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Change"><br>
    </form>
</div>
</body>
</html>

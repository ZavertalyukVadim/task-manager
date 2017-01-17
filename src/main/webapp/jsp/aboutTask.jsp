<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>About Task</title>
</head>

<body>
<div class="aboutTask">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <table>
        <h4>Title:</h4>
        ${task.title}<br>
        <h4>Details:</h4>
        ${task.details}<br>
        <h4>Creation time:</h4>
        ${task.startTime}
        <h4>End time:</h4>
        ${task.endTime}
        <h4>List:</h4>
        ${task.tasksList.list_name}
    </table>
    <input type="submit" value="Correct task" onclick="window.location='/task/${task.id}/changeTask'" style="font-size:12px"><br>
</div>
</body>
</html>

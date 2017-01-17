<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>New List</title>
</head>
<body>
<div class="addList">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/list/newList" method="post">
        <h3>Add name for new List</h3>
        <input type="text" name="name" placeholder="add name" required><br>
        <input type="submit" value="Add List"><br>
    </form>
</div>
</body>
</html>

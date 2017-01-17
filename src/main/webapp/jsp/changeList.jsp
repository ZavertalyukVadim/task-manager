<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>Change list</title>
</head>
<body>
<div class="changeList">
    <input type="submit" value="Home" onclick="window.location='/home'"><br>
    <form action="/list/${list.list_id}/update" method="post">
        <input type="hidden" name="id" value="${list.list_id}"><br>
        <h3>Title</h3>
        <input type="text" name="name" value="${list.list_name}" placeholder="add title" required><br>
        </select><br>
        <input type="submit" value="Change"><br>
    </form>
</div>
</body>
</html>

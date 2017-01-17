<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
    <title>Home</title>
</head>
<body>
<div class="allTasks">
    <form action="/task/newTask" method="get">
        <input type="submit" value="Add Task"><br>
    </form>
    <form action="/list/newList" method="get">
        <input type="submit" value="Add List"><br>
    </form>
    <c:forEach items="${ListTasks}" var="list">
        <div class="Task">
            <h2>${list.list_name}</h2>
            <h3>TO DO</h3>
            <div class="list">
                <table>
                    <c:forEach items="${list.tasks}" var="task">
                        <tr>
                            <c:if test="${!task.view}">
                                <td>
                                        ${task.title}
                                </td>
                                <td>
                                    <form action="/task/${task.id}/description" method="get">
                                        <input type="submit" value="View"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/task/${task.id}/delete" method="post">
                                        <input type="hidden" name="id" value="${task.id}">
                                        <input type="submit" value="Delete"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/task/${task.id}/status" method="post">
                                        <input type="hidden" name="id" value="${task.id}">
                                        <input type="submit" value="Active"><br>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <h3>Done Tasks</h3>
            <div class="toDo">
                <table>
                    <c:forEach items="${list.tasks}" var="task">
                        <tr>
                            <c:if test="${task.view}">
                                <td>
                                        ${task.title}
                                </td>
                                <td>
                                    <form action="/task/${task.id}/description" method="get">
                                        <input type="submit" value="View"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/task/${task.id}/delete" method="post">
                                        <input type="hidden" name="id" value="${task.id}">
                                        <input type="submit" value="Delete"><br>
                                    </form>
                                </td>
                                <td>
                                    <form action="/task/${task.id}/status" method="post">
                                        <input type="hidden" name="id" value="${task.id}">
                                        <input type="submit" value="Active"><br>
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <form action="/list/${list.list_id}/description" method="get">
                <input type="submit" value="Change ${list.list_name}"><br>
            </form>
            <form action="/list/${list.list_id}/delete" method="post">
                <input type="hidden" name="id" value="${list.list_id}"><br>
                <input type="submit" value="Delete ${list.list_name}"><br>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>

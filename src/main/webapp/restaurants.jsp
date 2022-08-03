<%@ page import="com.forvvard09.votingsystem.util.DateTimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>--%>

<html lang="ru">
<head>
    <title>Restaurants list</title>
    <style>
        .normal {
            color: green;
        }

        .excess {
            color: red;
        }
    </style>
</head>
<body>
<script src="https://use.fontawesome.com/993d1b1b71.js" defer></script>
<%--
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Restaurants</h2>
--%>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Meals</h2>
    <a href="restaurants?action=create">Add Restaurant</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Likes</th>
            <th>Date edit menu</th>
            <th>Menu</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${restiks}" var="restaurant">
            <jsp:useBean id="restaurant" type="com.forvvard09.votingsystem.model.Restaurant"/>
            <tr>
            <td>${restaurant.name}</td>
            <td>${restaurant.countLikes}</td>
            <td><%=DateTimeUtil.toString(restaurant.getDateTimeEditMenu())%>
            </td>
            <%--${fn:replace(restaurant.dateTimeEditMenu.toString(), 'T', ' ')}--%>
            <%--${fn:formatDateTime(meal.dateTime)}--%>
            <td>
                <c:forEach var="menuItem" items="${restaurant.mapMenu}">
                    <li>${menuItem.value.printFormat}</li>
                </c:forEach>
            </td>
            <td>
                <a href="restaurants?action=update&id=${restaurant.id}"><i class="fa fa-pencil fa-2x" aria-hidden="true"></i></a>
            </td>
            <td>
                <a href="restaurants?action=delete&id=${restaurant.id}"><i class="fa fa-trash-o fa-2x" aria-hidden="true"></i></a>
            </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>


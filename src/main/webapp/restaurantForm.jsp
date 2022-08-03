<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Restaurant</title>
    <style>
        dl {
            background: none repeat scroll 0 0 #FAFAFA;
            margin: 8px 0;
            padding: 0;
        }

        dt {
            display: inline-block;
            width: 170px;
        }

        dd {
            display: inline-block;
            margin-left: 8px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<script src="https://use.fontawesome.com/993d1b1b71.js" defer></script>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <jsp:useBean id="restaurant" type="com.forvvard09.votingsystem.model.Restaurant" scope="request"/>
    <h2>${restaurant.id == null ? 'Create restaurant' : 'Edit restaurant'}</h2>

    <form method="post" action="restaurantForm">
        <input type="hidden" name="id" value="${restaurant.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${restaurant.name}" size=40 name="name" required></dd>
        </dl>
        <dl>
            <dt>Count likes:</dt>
            <dd><input type="number" value="${restaurant.countLikes}" name="countLikes" required></dd>
        </dl>
        <dl>
            <dt>Date and time last editing menu:</dt>
            <dd><input type="datetime-local" value="${restaurant.dateTimeEditMenu}" name="dateTimeEditMenu" required>
            </dd>
        </dl>

        <h2>List menu</h2>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr>
                <th>Dish</th>
                <th>Cost</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <c:forEach var="menuItem" items="${restaurant.mapMenu}">
                <tr>
                    <td>${menuItem.key}</td>
                    <td>${menuItem.value.nameDish}</td>
                    <td>${menuItem.value.cost}</td>
                    <td><"${menuItem.key}"><i class="fa fa-pencil fa-1x" aria-hidden="true"></i></a>
                    </td>
                    <td><a href="restaurantForm?action=deleteMenu&id=${menuItem.key}"><i class="fa fa-trash-o fa-1x"
                                                                                          aria-hidden="true"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div>
            <input type="text" value="" name="nameDish">
            <input type="number" value="" name="cost">
            <div>
                <button class="dish-add">Add new dish</button>
                <button class="dish-edit">Edit dish</button>
            </div>

        </div>
        <hr>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>

</section>
<script type="text/javascript">
    <c:if test="${not empty param.username}">
    setCredentials("${param.username}", "");
    </c:if>

    function login(username, password) {
        setCredentials(username, password);
        $("#login_form").submit();
    }

    function setCredentials(username, password) {
        $('input[name="username"]').val(username);
        $('input[name="password"]').val(password);
    }
</script>
</body>
</html>

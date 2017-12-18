<%--
  Created by IntelliJ IDEA.
  User: koka
  Date: 12.12.17
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
</head>
<body ng-app="" ng-model="isConfirmed" ng-init="isConfirmed = ${isSucceded}">
<div ng-if="isConfirmed">
    <img src="https://cdn.pastemagazine.com/www/articles/Lead%20Dicaprio%20Gallery.jpg">
    <h3><p class="text-primary">Gratulacje, stworzyłeś grupę: ${gname} </p></h3>
    <br>
    <p>Członkowie grupy mogą teraz zalogować sie na swoich smartfonach przy pomocy podanego loginu i hasła.</p>
</div>
<div ng-if="isConfirmed == false">
    <img src="https://img.cda.pl/vid/oryginalne/dfba4748a16c848ddcb2b94112678e9f.jpg">
    <p class="text-danger">Coś, coś się popsuło, spróbuj jeszcze raz lub skontaktuj się z nami przez e-mail.</p>
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: koka
  Date: 12.12.17
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<form:form method="POST" action="/check" modelAttribute="command">
    <form:label path="name">Nazwa grupy: </form:label><form:input path="name"/><br>
    <form:label path="password">Hasło dostępu: </form:label><form:input type="password" path="password" /><br>
    <input class="btn btn-primary" type="submit" value="Loguj" id="sbt"/>
</form:form>
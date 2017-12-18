<%--
  Created by IntelliJ IDEA.
  User: koka
  Date: 12.12.17
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<form:form method="POST" action="/createDB" modelAttribute="command">
    <form:label path="name">Nazwa grupy: </form:label><form:input path="name"/><br>
    <form:label path="password">Hasło dostępu: </form:label><form:input type="password" path="password" onchange="valide()" /><br>
    <b>Powtórz hasło:</b><input type="password" id="confirm" onchange="valide()" />
    <div class="bg-danger text-white" id="pasc" style="visibility: hidden">
        Hasła się nie zgadzają
    </div>
    <input class="btn btn-primary" type="submit" value="Utwórz" id="sbt"/>
</form:form>
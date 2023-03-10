<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Login Page</title>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div>
      <a href="/registration">New Staff?</a>
    </div>
    <c:if test="${logoutMessage != null}">
      <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <c:if test="${errorMessage != null}">
      <c:out value="${errorMessage}"></c:out>
    </c:if>

    <h2>Login</h2>
    <form:form action="/login" method="post" modelAttribute="user">
      <input
        type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"
      />
      <table>
        <thead>
          <tr>
            <td colspan="2">Log In</td>
          </tr>
        </thead>
        <thead>
          <tr>
            <td class="float-left">User Name:</td>
            <td class="float-left">
              <form:errors path="username" class="text-danger" />
              <form:input class="input" path="username" />
            </td>
          </tr>
          <tr>
            <td class="float-left">Password:</td>
            <td class="float-left">
              <form:errors path="password" class="text-danger" />
              <form:input class="input" path="password" />
            </td>
          </tr>
          <tr>
            <td colspan="2">
              <input
                class="input"
                class="button"
                type="submit"
                value="Submit"
              />
            </td>
          </tr>
        </thead>
      </table>
    </form:form>
  </body>
</html>

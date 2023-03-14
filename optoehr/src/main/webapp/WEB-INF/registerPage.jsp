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
    <title>Registration Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <div>
      <a href="/">Already Registered?</a>
    </div>
    <h1>Register</h1>
    <c:if test="${errorMessage != null}">
      <c:out value="${errorMessage}"></c:out>
    </c:if>

    <form:form action="/registration" method="post" modelAttribute="user">
      <table>
        <thead>
          <tr>
            <td colspan="2">Register</td>
          </tr>
        </thead>
        <thead>
          <tr>
            <td class="float-left">First Name:</td>
            <td class="float-left">
              <form:errors path="firstName" class="text-danger" />
              <form:input class="input" path="firstName" />
            </td>
          </tr>
          <tr>
            <td class="float-left">Last Name:</td>
            <td class="float-left">
              <form:errors path="lastName" class="text-danger" />
              <form:input class="input" path="lastName" />
            </td>
          </tr>
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
            <td class="float-left">Confirm PW:</td>
            <td class="float-left">
              <form:errors path="pwConfirmation" class="text-danger" />
              <form:input class="input" path="pwConfirmation" />
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

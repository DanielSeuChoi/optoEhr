<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Patient Creation</title>
  </head>
  <body>
    <div>
      <a href="/">Back Home</a>
      <a href="/search">Back to Search</a>
    </div>
    <h2>Current User ID: ${currentUser.firstName}</h2>
    <form:form method="POST" action="/patients" modelAttribute="patient">
      <form:hidden path="user" value="${currentUser.id}"></form:hidden>
      <p>
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName" />
      </p>
      <p>
        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName" />
      </p>
      <p>
        <form:label path="sex">Sex:</form:label>
        <form:input path="sex" />
      </p>
      <p>
        <form:label path="height">Height:</form:label>
        <form:input path="height" />
      </p>
      <p>
        <form:label path="weight">Weight:</form:label>
        <form:input path="weight" />
      </p>
      <p>
        <form:label path="dob">DOB:</form:label>
        <form:input type="date" path="dob" />
      </p>
      <input type="submit" value="Create Patient!" />
    </form:form>
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>All Patients</title>
  </head>
  <body>
    <div>${currentUser.firstName}</div>
    <table class="table">
      <thead>
        <tr>
          <th>FirstName</th>
          <th>Last Name</th>
          <th>Sex</th>
          <th>Weight</th>
          <th>Date Of Birth</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="patient" items="${patient}">
          <tr>
            <td>${patient.firstName}</td>
            <td>${patient.lastName}</td>
            <td>${patient.sex}</td>
            <td>${patient.weight}</td>
            <td>${patient.dob}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>

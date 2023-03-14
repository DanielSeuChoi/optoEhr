<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Prescription Form</title>
  </head>
  <body>
    <div>
      <a href="/">Back Home</a>
      <a href="/search">Back to Search</a>
    </div>
    <h2>Admin ID: ${currentUser.firstName}</h2>
    <h2>Patient ID: ${patient.id}</h2>
    <c:if
      test="${currentUser.roles.get(0).name.contains('ROLE_OWNER')|| currentUser.roles.get(0).name.contains('ROLE_ADMIN')}"
    >
      <form:form method="POST" action="/createrx" modelAttribute="prescription">
        <div>
          <form:input
            type="hidden"
            path="patientRx"
            value="${patient.id}"
          ></form:input>
        </div>
        <p>
          <form:label path="sph">Sph:</form:label>
          <form:input path="sph" />
        </p>
        <p>
          <form:label path="cyl">Cyl:</form:label>
          <form:input path="cyl" />
        </p>
        <p>
          <form:label path="axis">axis:</form:label>
          <form:input path="axis" />
          <form:errors path="axis" />
        </p>
        <p>
          <form:label path="expirDate">Expiration:</form:label>
          <form:input type="date" path="expirDate" />
        </p>
        <input type="submit" value="Create Patient!" />
      </form:form>
    </c:if>
    <table class="table">
      <thead>
        <tr>
          <th>Full Name</th>
          <th>Sex</th>
          <th>Height</th>
          <th>Weight</th>
          <th>Date Of Birth</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${patient.firstName} ${patient.lastName}</td>
          <td>${patient.sex}</td>
          <td>${patient.height}</td>
          <td>${patient.weight}</td>
          <td>${patient.dob}</td>
        </tr>
      </tbody>
      <thead>
        <tr>
          <th>SPH</th>
          <th>CYL</th>
          <th>AXIS</th>
          <th>Date</th>
          <th>Expiration Date</th>
          <th>Opto Name:</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="patientRx" items="${patientRx}">
          <tr>
            <td>${patientRx.sph}</td>
            <td>${patientRx.cyl}</td>
            <td>${patientRx.axis}</td>
            <td>
              <fmt:formatDate
                pattern="y-MM-dd"
                value="${patientRx.createdAt}"
              />
            </td>
            <td>${patientRx.expirDate}</td>
            <td>${currentUser.firstName} ${currentUser.lastName}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>

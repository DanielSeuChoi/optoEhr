<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix = "c" uri =
"http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <title>Search For Patient</title>
  </head>
  <body>
    <div>
      <a href="/">Back to Admin Page</a>
    </div>
    <div>
      <h2>Search For Patient</h2>
    </div>
    <form action="/searchp" method="post">
      <table>
        <tbody>
          <tr>
            <td><input type="text" name="firstNameSearch" class="input" /></td>
            <td>
              <input
                class="input"
                class="button"
                type="submit"
                value="Search"
              />
            </td>
          </tr>
        </tbody>
      </table>
    </form>

    <c:if test="${searchResults!=null}">
      <table>
        <thead>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>DOB</th>
            <th>Sex</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="patient" items="${searchResults}">
            <tr>
              <td>${patient.firstName}</td>
              <td>${patient.lastName}</td>
              <td>${patient.dob}</td>
              <td>
                ${patient.sex} <a href="/patients/${patient.id}">See More</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>
  </body>
</html>

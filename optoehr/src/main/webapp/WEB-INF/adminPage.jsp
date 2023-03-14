<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <title>Admin Dashboard</title>
  </head>
  <body>
    <h1>Welcome, ${currentUser.firstName}</h1>
    <h2>Admin ID: ${currentUser.id}</h2>
    <form id="logoutForm" method="POST" action="/logout">
      <input
        type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"
      />
      <input type="submit" value="Logout!" />
    </form>
    <div>
      <a href="/patient/forms">Patient Forms</a>
      <a href="/allpatients">All Patients</a>
      <a href="/search">Search For Patient</a>
    </div>
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Username</th>
          <th>Action</th>
          <th>Role</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="user" items="${users}">
          <c:if test="${!user.roles.get(0).name.contains('ROLE_OWNER')}">
            <tr>
              <td>${user.firstName} ${user.lastName}</td>
              <td>${user.username}</td>
              <c:if
                test="${currentUser.roles.get(0).name.contains('ROLE_OWNER')}"
              >
                <td>
                  <a href="/delete/${user.id}">Delete</a>
                  <c:if
                    test="${!user.roles.get(0).name.contains('ROLE_ADMIN')}"
                  >
                    <a href="/admin/${user.id}">Make Admin</a>
                  </c:if>
                </td>
                <c:if test="${user.roles.get(0).name.contains('ROLE_ADMIN')}">
                  <td>Admin</td>
                </c:if>
              </c:if>
            </tr>
          </c:if>
        </c:forEach>
      </tbody>
    </table>
    <div>
      <fmt:formatDate pattern="MMMM dd, y" value="${currentUser.createdAt}" />
    </div>
    <!-- <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>User Name</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="user" items="${users}">
          <c:if test="${!user.roles.get(0).name.contains('ROLE_OWNER')}">
            <tr>
              <td>${user.firstName} ${user.lastName}</td>
              <td>${user.username}</td>
              <c:if
                test="${currentUser.roles.get(0).name.contains('ROLE_OWNER')}"
              >
                <td>
                  <a href="/delete/${user.id}">Delete</a>
                  <a href="/admin/${user.id}">Make Admin</a>
                </td>
              </c:if>
              <c:if
                test="${currentUser.roles.get(0).name.contains('ROLE_ADMIN')}"
              >
                <c:if test="${user.roles.get(0).name.contains('ROLE_USER')}">
                  <td>
                    <a href="/delete/${user.id}">Delete</a>
                    <a href="/admin/${user.id}">Make Admin</a>
                  </td>
                </c:if>
                <c:if test="${user.roles.get(0).name.contains('ROLE_ADMIN')}">
                  <td>Admin</td>
                </c:if>
              </c:if>
            </tr>
          </c:if>
        </c:forEach>
      </tbody>
    </table> -->
  </body>
</html>

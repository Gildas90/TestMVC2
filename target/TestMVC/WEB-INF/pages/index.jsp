<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:template>
  <c:if test="${!empty cars}">
    <table class="book-list-table">
      <tr>
        <th>Mark</th>
        <th>Model</th>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
          <th>&nbsp;</th>
        </sec:authorize>

      </tr>
      <c:forEach items="${cars}" var="car">
        <tr>
          <td>${car.mark}</td>
          <td>${car.model}</td>
          <sec:authorize access="hasRole('ROLE_ADMIN')">
            <td><a href="javascript:CarUtil.deletecar(${car.id})">Delete</a> </td>
          </sec:authorize>

        </tr>
      </c:forEach>
    </table>
  </c:if>
  <sec:authorize access="isAuthenticated()">
    <a href="addcar">Add Car</a>
  </sec:authorize>

</t:template>

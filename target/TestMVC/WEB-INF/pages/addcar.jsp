<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<t:template>
  <form:form method="post" action="addcar" commandName="car" >
    <table>
      <tr>
        <td><form:label path="mark">
          Mark
        </form:label></td>
        <td><form:input path="mark"/></td>
        <td><form:errors cssClass="errors" path="mark"></form:errors> </td>

      </tr>
      <tr>
        <td><form:label path="model">
          Model
        </form:label>
        </td>
        <td>
          <form:input path="model"/> </td>
        <td><form:errors cssClass="errors" path="model"></form:errors> </td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="Add Car"/></td>
      </tr>
    </table>
  </form:form>
</t:template>



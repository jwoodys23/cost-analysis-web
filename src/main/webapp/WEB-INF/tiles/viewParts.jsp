<%--
  Created by IntelliJ IDEA.
  User: jourdanwoodrich
  Date: 9/5/16
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-offset-2 col-md-8">
        <table class="table table-condensed table-hover">
            <caption>Part Listing</caption>
            <thead>
                <tr>
                    <th>Part Name</th>
                    <th>Material Cost</th>
                </tr>
            </thead>
        <c:forEach var="partUpdate" items="${page.content}">
            <tbody>
                <tr>
                    <td><c:out value="${partUpdate.partName}"/></td>
                    <td><c:out value="${partUpdate.materialCost}"/></td>
                </tr>
            </tbody>
        </c:forEach>
        </table>
    </div>
</div>



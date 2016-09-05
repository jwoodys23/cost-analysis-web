<%--
  Created by IntelliJ IDEA.
  User: jourdanwoodrich
  Date: 9/4/16
  Time: 2:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-md-8 col-md-offset-2">


        <div class="panel panel-default">
             <div class="panel-heading">
                 <div class="panel-title">Add A new part</div>
             </div>

            <div class="panel-body">
                <form:form commandName="partUpdate">
                    <%--<div class="form-group">--%>
                        <%--<label for="material-cost">Material Cost</label>--%>
                        <%--<form:input path="materialCost" class="form-control" id="material-cost" text="materialCost"></form:input>--%>
                        <%--</div>--%>
                    <%--<div class="form-group">--%>
                        <%--<label for="part-text">Part Name</label>--%>
                        <%--<form:input path="text" class="form-control" id="part-text" name="text"></form:input>--%>
                    <%--</div>--%>
                    <div class="form-group">
                        <form:textarea path="text" name="text" rows="10" cols="50"></form:textarea>
                    </div>

                    <input type="submit" name="submit" value="Add Part"/>
                </form:form>
            </div>

        </div>
    </div>
</div>

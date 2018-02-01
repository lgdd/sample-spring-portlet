<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>

<portlet:defineObjects/>

<h1>Sample Spring Portlet</h1>

<liferay-portlet:actionURL name="processMyForm" var="formActionUrl"/>

<liferay-ui:success key="myform-success" message="Form successfully submitted :)"/>

<form:form name="myForm" cssClass="form-horizontal" method="post" action="${formActionUrl}" modelAttribute="myForm">
    <spring:bind path="firstName">
        <div class="control-group ${status.error ? 'error' : ''}">
            <form:label path="firstName" cssClass="control-label">First name:</form:label>
            <div class="controls">
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="help-inline"/>
            </div>
        </div>
    </spring:bind>
    <spring:bind path="lastName">
        <div class="control-group ${status.error ? 'error' : ''}">
            <form:label path="lastName" cssClass="control-label">Last name:</form:label>
            <div class="controls">
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="help-inline"/>
            </div>
        </div>
    </spring:bind>
    <input type="submit" class="btn btn-primary" value="Submit"/>
</form:form>
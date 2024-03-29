<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageTitle" value="My Events" scope="request"/>
<jsp:include page="../includes/header.jsp"/>

<p id="description">
    Below you can find the events for
    <strong><c:out value="${currentUser.email}" /></strong>.
    Once security is applied this will be the events for the currently logged in user.
</p>
<c:url var="createUrl" value="/events/form"/>
<div id="create" class="pull-right"><a href="${createUrl}">Create Event</a></div>
<table class="table table-bordered table-striped table-condensed">
    <thead>
        <tr>
            <th>Date/Time</th>
            <th>Owner</th>
            <th>Attendee</th>
            <th>Summary</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${empty events}">
            <tr>
                <td colspan="2" class="msg">No events.</td>
            </tr>
        </c:if>
         <c:forEach items="${events}" var="event">
            <tr>
                <fmt:formatDate value="${event.when.time}" type="both" pattern="yyyy-MM-dd HH:mm" var="when"/>
                <td><c:out value="${when}"/></td>
                <td><c:out value="${event.owner.name}" /></td>
                <td><c:out value="${event.attendee.name}" /></td>
                <c:url var="eventUrl" value="${event.id}"/>
                <td><a href="${eventUrl}"><c:out value="${event.summary}" /></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<jsp:include page="../includes/footer.jsp"/>
<%@ include file="/html/init.jsp" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/borrowbook/edit_book.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addNewBook" var="addNewBookURL"/>

<aui:form action="<%=addNewBookURL %>" name="book-form">
	<aui:fieldset>
		<aui:input name="title" label="Title"/>
		<aui:input name="description" label="Description"/>
		<aui:input name="cost" label="Cost"/>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
		<aui:button type="cancel" onClick="${viewUrl}"/>
	</aui:button-row>
</aui:form>
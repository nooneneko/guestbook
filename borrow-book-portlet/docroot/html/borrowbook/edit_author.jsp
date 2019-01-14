<%@ include file="/html/init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/borrowbook/edit_author.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addNewAuthor" var="addNewAuthorURL"/>

<aui:form action="<%=addNewAuthorURL %>" name="author-form">
	<aui:fieldset>
		<aui:input name="name" label="Name"/>
		<aui:input name="email" label="Email"/>
		<aui:input name="address" label="address"/>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit"/>
		<aui:button type="cancel" onClick="${ viewURL}"/>
	</aui:button-row>
</aui:form>
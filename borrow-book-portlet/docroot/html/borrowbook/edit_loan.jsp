<%@ include file="/html/init.jsp" %>

<portlet:renderURL var="viewURL">
 	<portlet:param name="mvcPath" value="/html/borrowbook/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addNewLoan" var="addNewLoanURL"/>

<aui:form action="${addNewLoanURL }" name="loan-form">
	<aui:fieldset>
		<aui:input name=""/>
	</aui:fieldset>
</aui:form>
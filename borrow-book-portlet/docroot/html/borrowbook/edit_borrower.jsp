<%@ include file="/html/init.jsp"%>

<portlet:renderURL var="viewUrl">
	<portlet:param name="mcvPath" value="/html/borrowbook/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addBorrower" var="addBorrowerUrl"/>

<aui:form action="${addBorrowerUrl }" name="borrower-form">
	<aui:fieldset>
		<aui:input name="name" label="Name"/>
		<aui:input name="address" label="Address"/>
		<aui:input name="city" label="City"/>
		<aui:input name="email" label="Email"/>
		<aui:input name="phoneNo" label="Phone Number"/>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
		<aui:button type="cancel" onClick="${viewUrl}"/>
	</aui:button-row>
</aui:form>
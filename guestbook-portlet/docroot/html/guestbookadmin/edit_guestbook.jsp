<%@ include file="/html/init.jsp" %>

<%
	Long guestBookId = Long.parseLong(renderRequest.getParameter("guestBookId") != null 
		? renderRequest.getParameter("guestBookId") : "0");
	
	GuestBook guestBook = guestBookId != null && guestBookId > 0 ? GuestBookLocalServiceUtil.getGuestBook(guestBookId) : null;
%>

<portlet:renderURL var="viewUrl">
	 <portlet:param name="mvcPath" value="/html/guestbookadmin/view.jsp"/>	
</portlet:renderURL>

<portlet:actionURL name='<%= guestBook == null ? "addGuestBookAdmin" : "updateGuestBook" %>' 
	var="addGuestBookUrl"/>
<aui:model-context bean="<%= guestBook %>" model="<%= GuestBook.class %>" />
<aui:form action="<%= addGuestBookUrl.toString() %>" name="<portlet:namespace />fm">
	
	<aui:fieldset>
		<aui:input name="name"/>
		<aui:input name="guestBookId" type="hidden" 
			value='<%=guestBook == null ? 0 : guestBook.getGuestBookId() %>'/>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit"/>
		<aui:button type="cancel" onClick="<%=viewUrl.toString() %>"/>
	</aui:button-row>
</aui:form>
<%@ include file="/html/init.jsp" %>
<aui:button-row>
	<c:if test='<%=GuestBookModelPermission.contain(permissionChecker, scopeGroupId, "ADD_GUESTBOOK") %>'>
		<portlet:renderURL var="addGuestBookUrl">
			<portlet:param name="mvcPath" value="/html/guestbookadmin/edit_guestbook.jsp"/>
		</portlet:renderURL>
		
		<aui:button onClick="<%=addGuestBookUrl.toString()%>" value="Add GuestBook"/>
	</c:if>
</aui:button-row>

<liferay-ui:search-container>
	<liferay-ui:search-container-results 
		total="<%=GuestBookLocalServiceUtil.getGuestbooksCount(scopeGroupId) %>"
		results="<%=GuestBookLocalServiceUtil.getGuestbooks(scopeGroupId, searchContainer.getStart(), 
				searchContainer.getEnd()) %>"/>
	<liferay-ui:search-container-row className="com.liferay.docs.guestbook.model.GuestBook" modelVar="guestBook">
		<portlet:renderURL var="viewGuestbookURL">
	        <portlet:param name="mvcPath" value="/html/guestbookadmin/view_guestbook.jsp" />
	        <portlet:param name="guestBookId" value='<%=String.valueOf(guestBook.getGuestBookId()) %>' />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text property="name" href="<%=viewGuestbookURL %>"/>
		<liferay-ui:search-container-column-text name="status" >
       		<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>"
            	status="<%= guestBook.getStatus() %>" />
    	</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/html/guestbookadmin/guestbook_action.jsp" align="right"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


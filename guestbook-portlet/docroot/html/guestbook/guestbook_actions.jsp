<%@ include file="/html/init.jsp"%>
<%
	String mcvPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Entry entry = (Entry) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test='<%=EntryPermission.contain(permissionChecker, entry.getEntryId(), ActionKeys.UPDATE)%>'>
		<portlet:renderURL var="editEntry">
			<portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp" />
			<portlet:param name="entryId"
				value='<%=String.valueOf(entry.getEntryId())%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="Update"
			url="<%=editEntry.toString()%>" />
	</c:if>
	<c:if
		test="<%=EntryPermission.contain(permissionChecker, entry.getEntryId(), ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%=Entry.class.getName()%>"
			modelResourceDescription="<%=entry.getMessage()%>"
			resourcePrimKey="<%=String.valueOf(entry.getEntryId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>
	<c:if test="<%=EntryPermission.contain(permissionChecker, entry.getEntryId(), ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteEntry" var="deleteEntryUrl">
			<portlet:param name="entryId" value="<%=String.valueOf(entry.getEntryId()) %>"/>
			<portlet:param name="guestBookId" value="<%=String.valueOf(entry.getGuestBookId()) %>"/>
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteEntryUrl.toString() %>"></liferay-ui:icon-delete>
	</c:if>
</liferay-ui:icon-menu>
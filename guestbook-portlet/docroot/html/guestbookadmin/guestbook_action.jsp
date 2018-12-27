<%@ include file="/html/init.jsp"%>
<%
	String mcvPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	GuestBook guestBook = (GuestBook) row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if
		test='<%=GuestBookPermission.contain(permissionChecker, guestBook.getGuestBookId(), ActionKeys.UPDATE)%>'>
		<portlet:renderURL var="editGuestBook">
			<portlet:param name="mvcPath" value="/html/guestbookadmin/edit_guestbook.jsp" />
			<portlet:param name="guestBookId"
				value='<%=String.valueOf(guestBook.getGuestBookId())%>' />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" message="Update"
			url="<%=editGuestBook.toString()%>" />
	</c:if>
	<c:if
		test="<%=GuestBookPermission.contain(permissionChecker, guestBook.getGuestBookId(), ActionKeys.PERMISSIONS)%>">
		<liferay-security:permissionsURL
			modelResource="<%=GuestBook.class.getName()%>"
			modelResourceDescription="<%=guestBook.getName()%>"
			resourcePrimKey="<%=String.valueOf(guestBook.getGuestBookId())%>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%=permissionsURL%>" />
	</c:if>
	<c:if test="<%=GuestBookPermission.contain(permissionChecker, guestBook.getGuestBookId(), ActionKeys.DELETE)%>">
		<portlet:actionURL name="deleteGuestBook" var="deleteGuestBookUrl">
			<portlet:param name="guestBookId" value="<%=String.valueOf(guestBook.getGuestBookId()) %>"/>
		</portlet:actionURL>
		<liferay-ui:icon-delete url="<%=deleteGuestBookUrl.toString() %>"/>
	</c:if>
</liferay-ui:icon-menu>
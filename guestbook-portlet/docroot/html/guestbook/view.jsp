<%@ include file="/html/init.jsp"%>
<%
	long guestBookId = Long.parseLong(renderRequest.getAttribute("guestBookId").toString());
%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/html/guestbook/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<aui:nav cssClass="nav-tabs">

	<%
		List<GuestBook> guestbooks = GuestBookLocalServiceUtil.getGuestbooks(scopeGroupId, WorkflowConstants.STATUS_APPROVED);
			for (GuestBook guestBook : guestbooks) {
				GuestBook curGuestbook = guestBook;

				String cssClass = StringPool.BLANK;

				if (curGuestbook.getGuestBookId() == guestBookId) {
					cssClass = "active";
				}
				if (GuestBookPermission.contain(permissionChecker, curGuestbook.getGuestBookId(), ActionKeys.VIEW)) {
	%>

	<portlet:renderURL var="viewPageURL">
		<portlet:param name="mvcPath" value="/html/guestbook/view.jsp" />
		<portlet:param name="guestBookId"
			value="<%=String.valueOf(curGuestbook.getGuestBookId())%>" />
	</portlet:renderURL>

	<aui:nav-item cssClass="<%=cssClass%>" href="<%=viewPageURL%>"
		label="<%=HtmlUtil.escape(curGuestbook.getName())%>" />

	<%
		}
			}
	%>
</aui:nav>

<aui:button-row cssClass="guestbook-buttons">
	<portlet:renderURL var="viewEditGuestBook">
		<portlet:param name="mvcPath"
			value="/html/guestbook/edit_guestbook.jsp" />
	</portlet:renderURL>
	<portlet:renderURL var="viewEditEntry">
		<portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp" />
		<portlet:param name="guestBookId"
			value="<%=String.valueOf(guestBookId)%>" />
	</portlet:renderURL>

	<c:if
		test='<%=GuestBookModelPermission.contain(permissionChecker, scopeGroupId, "ADD_GUESTBOOK")%>'>
		<aui:button onClick="<%=viewEditGuestBook.toString() %>"
			value="Add GuestBook" />
	</c:if>
	<c:if
		test='<%=GuestBookPermission.contain(permissionChecker, guestBookId, "ADD_ENTRY")%>'>
		<aui:button onClick="<%=viewEditEntry.toString() %>" value="Add Entry" />
	</c:if>

</aui:button-row>

<liferay-ui:search-container>
	<liferay-ui:search-container-results
		total="<%=EntryLocalServiceUtil.getEntriesCount(scopeGroupId, guestBookId,  WorkflowConstants.STATUS_APPROVED)%>"
		results="<%=EntryLocalServiceUtil.getEntries(scopeGroupId, guestBookId,  WorkflowConstants.STATUS_APPROVED,
							searchContainer.getStart(),
							searchContainer.getEnd())%>" />
	
	<liferay-ui:search-container-row
		className="com.liferay.docs.guestbook.model.Entry" modelVar="entry">
		<portlet:renderURL var="viewEntryRow">
			<portlet:param name="mvcPath" value="/html/guestbook/view_entry.jsp"/>
			<portlet:param name="entryId" value="<%=String.valueOf(entry.getEntryId()) %>"/>
		</portlet:renderURL>
		<c:if test="<%=EntryPermission.contain(permissionChecker, entry.getEntryId(), ActionKeys.VIEW) %>">
			<liferay-ui:search-container-column-text property="message" />

			<liferay-ui:search-container-column-text property="name" href="<%=viewEntryRow %>"/>

			<liferay-ui:search-container-column-text property="email" />

			<liferay-ui:search-container-column-jsp
				path="/html/guestbook/guestbook_actions.jsp" align="right" />
		</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />


</liferay-ui:search-container>








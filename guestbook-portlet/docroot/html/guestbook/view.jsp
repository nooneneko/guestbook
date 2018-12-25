<%@ include file="/html/guestbook/init.jsp"%>
<%
	long guestBookId = Long.parseLong(renderRequest.getAttribute("guestbookId").toString());
%>

<aui:nav cssClass="nav-tabs">

	<%
		List<GuestBook> guestbooks = GuestBookLocalServiceUtil.getGuestbooks(scopeGroupId);
			for (int i = 0; i < guestbooks.size(); i++) {
				GuestBook curGuestbook = (GuestBook) guestbooks.get(i);

				String cssClass = StringPool.BLANK;

				if (curGuestbook.getGuestBookId() == guestBookId) {
					cssClass = "active";
				}
	%>

	<portlet:renderURL var="viewPageURL">
		<portlet:param name="mvcPath" value="/html/guestbook/view.jsp" />
		<portlet:param name="guestbookId"
			value="<%=String.valueOf(curGuestbook.getGuestBookId())%>" />
	</portlet:renderURL>

	<aui:nav-item cssClass="<%=cssClass%>" href="<%=viewPageURL%>"
		label="<%=HtmlUtil.escape(curGuestbook.getName())%>" />

	<%
		}
	%>
	<aui:button-row>
		<portlet:renderURL var="viewEditGuestBook">
			<portlet:param name="mvcPath"
				value="/html/guestbook/edit_guestbook.jsp" />
		</portlet:renderURL>

		<portlet:renderURL var="viewEditEntry">
			<portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp" />
		</portlet:renderURL>

		<aui:button onClick="<%=viewEditGuestBook.toString() %>"
			value="Add GuestBook"></aui:button>
		<aui:button onClick="<%=viewEditEntry.toString() %>" value="Add Entry"></aui:button>
	</aui:button-row>

	<liferay-ui:search-container
		total="<%=EntryLocalServiceUtil.getEntriesCount()%>">
		<liferay-ui:search-container-results
			results="<%=EntryLocalServiceUtil.getEntrys(scopeGroupId, guestBookId, searchContainer.getStart(),
							searchContainer.getEnd())%>" />

		<liferay-ui:search-container-row
			className="com.liferay.docs.guestbook.model.Entry" modelVar="entry">

			<liferay-ui:search-container-column-text property="message" />

			<liferay-ui:search-container-column-text property="name" />

		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</aui:nav>







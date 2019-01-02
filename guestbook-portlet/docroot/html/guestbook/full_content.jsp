<%@include file="/html/init.jsp"%>

<%
Entry entry = (Entry)request.getAttribute("gb_entry");

entry = entry.toEscapedModel();
%>

<dl>
        <dt>GuestBook</dt>
        <dd><%= GuestBookLocalServiceUtil.getGuestBook(entry.getGuestBookId()).getName() %></dd>
        <dt>Name</dt>
        <dd><%= entry.getName() %></dd>
        <dt>Message</dt>
        <dd><%= entry.getMessage() %></dd>
        <dt>Email</dt>
        <dd><%= entry.getEmail() %></dd>
</dl>
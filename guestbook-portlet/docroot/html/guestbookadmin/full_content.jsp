<%@include file="/html/init.jsp"%>

<%
GuestBook guestbook = (GuestBook)request.getAttribute("gb_guestbook");

guestbook = guestbook.toEscapedModel();
%>

<dl>
        <dt>Name</dt>
        <dd><%= guestbook.getName() %></dd>
</dl>
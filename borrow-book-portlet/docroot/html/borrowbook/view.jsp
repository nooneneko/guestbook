<%@ include file="/html/init.jsp"%>

<c:set var="borrowerId" value="${borrowerId}" scope="request" />

<portlet:renderURL var="viewUrl">
	<portlet:param name="mvcPath" value="/html/borrowbook/view.jsp" />
</portlet:renderURL>
	
<aui:nav cssClass="nav-tabs">
	<c:forEach items="${borrowerBook:getListBorrowers(scopeGroupId) }"
		var="curBorrower">
		<portlet:renderURL var="viewPageURL">
			<portlet:param name="mvcPath" value="/html/borrowbook/view.jsp" />
			<portlet:param name="borrowerId" value="${curBorrower.borrowerId}>" />
		</portlet:renderURL>
		<c:choose>
			<c:when test="${curBorrower.borrowerId == borrowerId}">
				<aui:nav-item cssClass="active" href="${viewPageURL}"
					label="${curBorrower.name}" />
			</c:when>

			<c:otherwise>
				<aui:nav-item href="${viewPageURL}" label="${curBorrower.name}" />
			</c:otherwise>
		</c:choose>
	</c:forEach>
</aui:nav>

<aui:button-row >

	<portlet:renderURL var="addBorrowerURL">	
		<portlet:param name="mvcPath" value="/html/borrowbook/edit_borrower.jsp" />
	</portlet:renderURL>
	
	<portlet:renderURL var="addBookURL">	
		<portlet:param name="mvcPath" value="/html/borrowbook/edit_book.jsp" />
	</portlet:renderURL>

	<portlet:renderURL var="addLoanURL">
		<portlet:param name="mvcPath" value="/html/borrowbook/edit_loan.jsp" />
		<portlet:param name="borrowerId" value="${borrowerId}" />
	</portlet:renderURL>

	<aui:button onClick="${addBorrowerURL}" value="Add Borrower" />

	<aui:button onClick="${addLoanURL}" value="Add Loan"/>
	
	<aui:button onClick="${addBookURL}" value="Add Book"/>

</aui:button-row>
<%@ include file="/html/init.jsp"%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/guestbook/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL"></portlet:actionURL>
<%
	long entryId = ParamUtil.getLong(renderRequest, "entryId");

	Entry entry = null;

	if (entryId > 0) {

		entry = EntryLocalServiceUtil.getEntry(entryId);

	}

	long guestbookId = ParamUtil.getLong(renderRequest, "guestBookId");
%>
<aui:form action="<%=addEntryURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%=entry%>" model="<%=Entry.class%>" />
	<aui:fieldset>

		<aui:input name="name" id="name">
			<aui:validator name="required" errorMessage="Please enter your name" />
		</aui:input>
		<aui:input name="email" id="email">
			<aui:validator name="email" />
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="message" id="message" type="textarea">
			<aui:validator name="required" errorMessage="Please enter a message" />
		</aui:input>
		<div id="counterContainer">
			<p>
				<span id="messageCounter"></span> character(s) remaining
			</p>
		</div>
		<aui:input name="entryId" type="hidden" />
		<aui:input name='guestBookId' type='hidden'
			value='<%=entry == null ? guestbookId : entry.getGuestBookId()%>' />

	</aui:fieldset>

	<liferay-ui:asset-categories-error />
	<liferay-ui:asset-tags-error />
	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryCategorizationPanel" persistState="<%=true%>"
		title="categorization">
		<aui:fieldset>
			<aui:input name="categories" type="assetCategories" />

			<aui:input name="tags" type="assetTags" />
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel defaultState="closed" extended="<%=false%>"
		id="entryAssetLinksPanel" persistState="<%=true%>"
		title="related-assets">
		<aui:fieldset>
			<liferay-ui:input-asset-links
				className="<%=Entry.class.getName()%>" classPK="<%=entryId%>" />
		</aui:fieldset>
	</liferay-ui:panel>
	
	<liferay-ui:panel title="populate" defaultState="false" extended="<%=false %>"
		id="populatePanel" persistState="<%=true %>">
		<c:if test="<%= themeDisplay.isSignedIn() %>">
                <aui:button-row>
                        <aui:button 
                            id="useNameButton" 
                            value="Use My Full Name">
                        </aui:button>
                </aui:button-row>
        </c:if>

        <c:if test="<%= themeDisplay.isSignedIn() %>">

                <aui:button-row>
                        <aui:button 
                            id="useEmailButton" 
                            value="Use My Email Address">
                        </aui:button>
                </aui:button-row>

        </c:if>
		
	</liferay-ui:panel>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

	</aui:button-row>
</aui:form>

<c:if test="<%= themeDisplay.isSignedIn() %>">
	<%
		String emailAddress = user.getEmailAddress();
		String fullName = user.getFullName();
	%>
	
	<aui:script use="node, event">
		var fullName = '<%= fullName %>';

    	var useNameButton = A.one('#useNameButton');

   		useNameButton.on('click', function(event) {
            var name = A.one('#<portlet:namespace/>name');

            name.val(fullName);
    	});
   		
   		var emailAddress = '<%= emailAddress %>';
   		
   		var useEmailButton = A.one('#useEmailButton');
   		
   		useEmailButton.on('click', function(event) {
			var email = A.one('#<portlet:namespace/>email');
			
			email.val(emailAddress);
		});
	</aui:script>
</c:if>

<aui:script use="aui-char-counter">
AUI().use(
  function(A) {
    new A.CharCounter(
      {
        counter: '#messageCounter',
        input: '#<portlet:namespace />message',
        maxLength: 140
      }
    );
  }
);
</aui:script>
	


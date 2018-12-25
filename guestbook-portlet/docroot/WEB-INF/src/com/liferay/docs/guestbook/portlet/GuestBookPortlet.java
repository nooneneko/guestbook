package com.liferay.docs.guestbook.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.EntryLocalServiceUtil;
import com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class GuestBookPortlet
 */
public class GuestBookPortlet extends MVCPortlet {

	public void addEntry(ActionRequest request, ActionResponse actionResponse) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestBookPortlet.class.getName(),
				request);
		String name = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		String message = ParamUtil.getString(request, "message");
		long guestBookId = ParamUtil.getLong(request, "guestbookId");
		
		try {
			EntryLocalServiceUtil.addEntry(serviceContext.getUserId(), 
					guestBookId, name, email, message, serviceContext);
			SessionMessages.add(request, "entryAdded");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			
			actionResponse.setRenderParameter("mvcPath", 
					"/html/guestbook/edit_entry.jsp");
		}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		try {
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(
	                GuestBook.class.getName(), renderRequest);

	        long groupId = serviceContext.getScopeGroupId();

	        long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");

	        List<GuestBook> guestbooks = GuestBookLocalServiceUtil
	                .getGuestbooks(groupId);

	        if (guestbooks.size() == 0) {
	        	GuestBook guestbook = GuestBookLocalServiceUtil.addGuestBook(
	                    serviceContext.getUserId(), "Main", serviceContext);

	            guestbookId = guestbook.getGuestBookId();

	        }
	        
	        if (!(guestbookId > 0)) {
	            guestbookId = guestbooks.get(0).getGuestBookId();
	        }

	        renderRequest.setAttribute("guestbookId", guestbookId);

	    } catch (Exception e) {

	        throw new PortletException(e);
	    }

	    super.render(renderRequest, renderResponse);

	}
	
	public void addGuestBook(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory
				.getInstance(GuestBookPortlet.class.getName(), actionRequest);
		String name = ParamUtil.getString(actionRequest, "name");
		
		try {
	        GuestBookLocalServiceUtil.addGuestBook(serviceContext.getUserId(),
	                name, serviceContext);

	        SessionMessages.add(actionRequest, "guestbookAdded");

	    } catch (Exception e) {
	        SessionErrors.add(actionRequest, e.getClass().getName());

	        actionResponse.setRenderParameter("mvcPath",
	            "/html/guestbook/edit_guestbook.jsp");
	    }
	}

}

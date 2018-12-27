package com.liferay.docs.guestbook.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.docs.guestbook.model.GuestBook;
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
 * Portlet implementation class GuestBookAdminPortlet
 */
public class GuestBookAdminPortlet extends MVCPortlet {

	 public void updateGuestBook(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		 ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestBook.class.getName(),
				 actionRequest);
		 long guestBookId = ParamUtil.getLong(actionRequest, "guestBookId");
		 String name = ParamUtil.getString(actionRequest, "name");
		 
		 try {
			 GuestBookLocalServiceUtil.updateGuestBook(serviceContext.getUserId(), 
					 guestBookId, name, serviceContext);
			 SessionMessages.add(actionRequest, "guestBookUpdated");
		 } catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
			
			actionResponse.setRenderParameter("mcvPath", "/html/guestbookadmin/edit_guestbook.jsp");
		}
	 }
	 
	 public void addGuestBookAdmin(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		 ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestBook.class.getName(), 
				 actionRequest);
		 String name = ParamUtil.getString(actionRequest, "name"); 
		 try {
			 GuestBookLocalServiceUtil.addGuestBook(serviceContext.getUserId(), name, serviceContext);
			 SessionMessages.add(actionRequest, "guestBookAdded");
		 } catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
			
			actionResponse.setRenderParameter("mvcPath", "/html/guestbookadmin/edit_guestbook,jsp");
		}
	 }
	 
	 public void deleteGuestBook(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		 ServiceContext serviceContext = ServiceContextFactory.getInstance(GuestBook.class.getName(), actionRequest);
		 long guestBookId = ParamUtil.getLong(actionRequest, "guestBookId");
		 try {
			 GuestBookLocalServiceUtil.deleteGuestBook(guestBookId, serviceContext);
			 SessionMessages.add(actionRequest, "guestBookDeleted");
		 } catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
		}
	 }
}

package com.imsw.portlets;

import com.imsw.model.Author;
import com.imsw.model.Book;
import com.imsw.model.Borrower;
import com.imsw.service.AuthorLocalServiceUtil;
import com.imsw.service.BookLocalServiceUtil;
import com.imsw.service.BorrowerLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class BorrowBookPortlet
 */
public class BorrowBookPortlet extends MVCPortlet {

	public void addBorrower(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Borrower.class.getName(), actionRequest);
		String borrwerName = ParamUtil.getString(actionRequest, "name");
	    String email = ParamUtil.getString(actionRequest, "email");
	    String address = ParamUtil.getString(actionRequest, "address");
	    String phoneNo = ParamUtil.getString(actionRequest, "phoneNo");
	    String city = ParamUtil.getString(actionRequest, "city");
	    
	    try {
	        BorrowerLocalServiceUtil.addBorrower(serviceContext.getUserId(), 
	        		borrwerName, email, address, city, phoneNo, serviceContext);

	        SessionMessages.add(actionRequest, "borrowerAdd");

	    } catch (Exception e) {
	        SessionErrors.add(actionRequest, e.getClass().getName());

	        actionResponse.setRenderParameter("mvcPath",
	            "/html/borrowbook/edit_borrower.jsp");
	    }

	}

	public void addNewBook(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Book.class.getName(),
				actionRequest);
		String title = ParamUtil.getString(actionRequest, "title");
		String description = ParamUtil.getString(actionRequest, "description");
		int cost = ParamUtil.getInteger(actionRequest, "cost");
		
		try {
			BookLocalServiceUtil.addBook(serviceContext.getUserId(), title, description, cost, serviceContext);
			
			SessionMessages.add(actionRequest, "authorAdd");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
			
			actionResponse.setRenderParameter("mvcPath", 
					"/html/borrowbook/edit_book.jsp");
		}
	}

	public void addNewAuthor(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Author.class.getName(), 
				actionRequest);
		
		String name = ParamUtil.getString(actionRequest, "name");
		String email = ParamUtil.getString(actionRequest, "email");
		String address = ParamUtil.getString(actionRequest, "address");
		
		try {
			AuthorLocalServiceUtil.addAuthor(serviceContext.getUserId(), name, email, address, serviceContext);
			
			SessionMessages.add(actionRequest, "authorAdd");
		} catch(Exception e) {
			SessionErrors.add(actionRequest, e.getClass().getName());
			
			actionResponse.setRenderParameter("mvcPath", "/html/borrowbook/edit_author.jsp");
		}
	}
 

}

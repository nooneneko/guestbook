package com.liferay.docs.guestbook.service.permission;

import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class GuestBookPermission {
	public static void check(PermissionChecker permissionChecker, long guestBookId, 
			String actionId) throws PortalException, SystemException {
		if (!contain(permissionChecker, guestBookId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contain(PermissionChecker permissionChecker, long guestBookId, String actionId) throws PortalException, SystemException {

		GuestBook guestBook = GuestBookLocalServiceUtil.getGuestBook(guestBookId);
		
		return permissionChecker.hasPermission(guestBook.getGroupId(), 
				GuestBook.class.getName(), guestBook.getGuestBookId(), actionId);
	}
}

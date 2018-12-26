package com.liferay.docs.guestbook.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class GuestBookModelPermission {
	
	private static final String RESOURCE_NAME = "com.liferay.docs.guestbook.model";
	
	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) throws PortalException {
		if (!contain(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
		
	}

	public static boolean contain(PermissionChecker permissionChecker, long groupId, String actionId) {
		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId, actionId);
	}

}

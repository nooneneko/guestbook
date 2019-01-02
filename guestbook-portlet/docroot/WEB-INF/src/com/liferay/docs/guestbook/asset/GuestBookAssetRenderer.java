package com.liferay.docs.guestbook.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.permission.GuestBookPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class GuestBookAssetRenderer extends BaseAssetRenderer{
	
	private GuestBook _guestBook;
	
	private Log _log;
	
	public GuestBookAssetRenderer(GuestBook _guestBook) {
		super();
		this._guestBook = _guestBook;
	}

	@Override
	public String getClassName() {
		return GuestBook.class.getName();
	}

	@Override
	public long getClassPK() {
		return _guestBook.getGuestBookId();
	}

	@Override
	public long getGroupId() {
		return _guestBook.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return "Name:"+ _guestBook.getName();
	}

	@Override
	public String getTitle(Locale locale) {
		return _guestBook.getName();
	} 

	@Override
	public long getUserId() {
		return _guestBook.getUserId();
	}

	@Override
	public String getUserName() {
		return _guestBook.getUserName();
	}

	@Override
	public String getUuid() {
		return _guestBook.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
            renderRequest.setAttribute("gb_guestbook", _guestBook);

            return "/html/guestbookadmin/" + template + ".jsp";
		}
		return null;
	}
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException, SystemException {
		long guestBookId = _guestBook.getGuestBookId();

        boolean contains = false;

        try {
                contains = GuestBookPermission.contain(permissionChecker,
                		guestBookId, ActionKeys.UPDATE);
        } catch (PortalException pe) {
                _log.error(pe.getLocalizedMessage());
        } catch (SystemException se) {
                _log.error(se.getLocalizedMessage());
        }

        return contains;
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException, SystemException {
		long guestBookId = _guestBook.getGuestBookId();

        boolean contains = false;

        try {
                contains = GuestBookPermission.contain(permissionChecker,
                		guestBookId, ActionKeys.VIEW);
        } catch (PortalException pe) {
                _log.error(pe.getLocalizedMessage());
        } catch (SystemException se) {
                _log.error(se.getLocalizedMessage());
        }

        return contains;
	}
	
	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getURLPortal()
                + "/guestbook-portlet/guestbook.png";
	}

}

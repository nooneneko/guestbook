package com.liferay.docs.guestbook.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.permission.EntryPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class EntryAssetRenderer extends BaseAssetRenderer{

	private Entry _entry;
	
	private Log _log;
	
	public EntryAssetRenderer(Entry _entry) {
		super();
		this._entry = _entry;
	}

	@Override
	public String getClassName() {
		return Entry.class.getName();
	}

	@Override
	public long getClassPK() {
		return _entry.getEntryId();
	}

	@Override
	public long getGroupId() {
		return _entry.getGroupId();
	}

	@Override
	public String getSummary(Locale locale) {
		return "Name: " + _entry.getName();
	}

	@Override
	public String getTitle(Locale locale) {
		return _entry.getName();
	}

	@Override
	public long getUserId() {
		return _entry.getUserId();
	}

	@Override
	public String getUserName() {
		return _entry.getUserName();
	}

	@Override
	public String getUuid() {
		return _entry.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("gb_entry", _entry);
			
			return "/html/guestbook/" + template + ".jsp";
		}
		
		return null;
	}
	
	@Override
    public boolean hasEditPermission(PermissionChecker permissionChecker) {

            long entryId = _entry.getEntryId();

            boolean contains = false;

            try {
                    contains = EntryPermission.contain(permissionChecker,
                                    entryId, ActionKeys.UPDATE);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }

            return contains;
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker) {

            long entryId = _entry.getEntryId();

            boolean contains = false;

            try {
                    contains = EntryPermission.contain(permissionChecker,
                                    entryId, ActionKeys.VIEW);
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
                + "/guestbook-portlet/entry.png";
	}

}

package com.liferay.docs.guestbook.asset;

import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil;
import com.liferay.docs.guestbook.service.permission.GuestBookPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class GuestBookAssetRendererFactory extends BaseAssetRendererFactory{
    public static final String CLASS_NAME = GuestBook.class.getName();

    public static final String TYPE = "guestbook";
	@Override
	public AssetRenderer getAssetRenderer(long classPK, int type) throws PortalException, SystemException {
		GuestBook guestbook = GuestBookLocalServiceUtil.getGuestBook(classPK);

        return new GuestBookAssetRenderer(guestbook);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	@Override
    public boolean hasPermission(
                    PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {

            return GuestBookPermission.contain(permissionChecker, classPK, actionId);
    }

    @Override
    public boolean isLinkable() {
            return _LINKABLE;
    }

    private static final boolean _LINKABLE = true;

}

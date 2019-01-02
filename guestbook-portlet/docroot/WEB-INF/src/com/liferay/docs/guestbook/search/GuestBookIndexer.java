package com.liferay.docs.guestbook.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil;
import com.liferay.docs.guestbook.service.permission.GuestBookPermission;
import com.liferay.docs.guestbook.service.persistence.GuestBookActionableDynamicQuery;
import com.liferay.docs.guestbook.util.PortletKeys;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

public class GuestBookIndexer extends BaseIndexer {
	public static final String[] CLASS_NAMES = { GuestBook.class.getName() };

    public static final String PORTLET_ID = PortletKeys.GUESTBOOK_ADMIN;

    public GuestBookIndexer() {

            setPermissionAware(true);
    }

    @Override
    public String[] getClassNames() {

            return CLASS_NAMES;
    }

    @Override
    public String getPortletId() {

            return PORTLET_ID;
    }

    @Override
    public boolean hasPermission(PermissionChecker permissionChecker,
                    String guestbookClassName, long guestbookClassPK, String actionId)
                    throws Exception {

            return GuestBookPermission.contain(permissionChecker, guestbookClassPK,
                            ActionKeys.VIEW);
    }

    @Override
    protected void doDelete(Object obj) throws Exception {

            GuestBook guestbook = (GuestBook)obj;

            deleteDocument(guestbook.getCompanyId(), guestbook.getGuestBookId());
    }

    @Override
    protected Document doGetDocument(Object obj) throws Exception {

            GuestBook guestbook = (GuestBook)obj;

            Document document = getBaseModelDocument(PORTLET_ID, guestbook);

            document.addDate(Field.MODIFIED_DATE, guestbook.getModifiedDate());
            document.addText(Field.TITLE, guestbook.getName());
            document.addKeyword(Field.GROUP_ID, getSiteGroupId(guestbook.getGroupId()));
            document.addKeyword(Field.SCOPE_GROUP_ID, guestbook.getGroupId());

            return document;
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale,
                    String snippet, PortletURL portletURL) throws Exception {

            Summary summary = createSummary(document);

            summary.setMaxContentLength(200);

            return summary;
    }

    @Override
    protected void doReindex(Object obj) throws Exception {

            GuestBook guestbook = (GuestBook)obj;

            Document document = getDocument(guestbook);

            SearchEngineUtil.updateDocument(
                    getSearchEngineId(), guestbook.getCompanyId(), document);
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {

            GuestBook guestbook = GuestBookLocalServiceUtil.getGuestBook(classPK);

            doReindex(guestbook);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {

            long companyId = GetterUtil.getLong(ids[0]);

            reindexEntries(companyId);
    }

    @Override
    protected String getPortletId(SearchContext searchContext) {

            return PORTLET_ID;
    }

    protected void reindexEntries(long companyId) throws PortalException,
                    SystemException {

            final Collection<Document> documents = new ArrayList<Document>();

            ActionableDynamicQuery actionableDynamicQuery = new GuestBookActionableDynamicQuery() {

                    @Override
                    protected void addCriteria(DynamicQuery dynamicQuery) {
                    }

                    @Override
                    protected void performAction(Object object) throws PortalException {
                            GuestBook guestbook = (GuestBook) object;

                            Document document = getDocument(guestbook);

                            documents.add(document);
                    }

            };

            actionableDynamicQuery.setCompanyId(companyId);

            actionableDynamicQuery.performActions();

            SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
                            documents);
    }

}

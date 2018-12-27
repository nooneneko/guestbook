package com.liferay.docs.guestbook.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.EntryLocalServiceUtil;
import com.liferay.docs.guestbook.service.permission.EntryPermission;
import com.liferay.docs.guestbook.service.persistence.EntryActionableDynamicQuery;
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
import com.liferay.portal.security.permission.PermissionChecker;

public class EntryIndexer extends BaseIndexer {

	private final String[] CLASS_NAME = { EntryIndexer.class.getName() };

	private final String PORTLET_ID = "guestbook-portlet";

	@Override
	public String[] getClassNames() {
		return CLASS_NAME;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		Entry entry = (Entry) obj;
		deleteDocument(entry.getCompanyId(), entry.getEntryId());

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		Entry entry = (Entry) obj;
		Document document = getBaseModelDocument(PORTLET_ID, entry);

		document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());
		document.addText(Field.CONTENT, entry.getMessage());
		document.addText(Field.TITLE, entry.getName());
		document.addText("email", entry.getEmail());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(entry.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, entry.getGroupId());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletURL portletURL)
			throws Exception {
		Summary summary = doGetSummary(document, locale, snippet, portletURL);
		summary.setMaxContentLength(DEFAULT_INTERVAL);
		;
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Entry entry = (Entry) obj;
		Document document = getDocument(obj);
		SearchEngineUtil.updateDocument(getSearchEngineId(), entry.getCompanyId(), document);
		;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Entry entry = EntryLocalServiceUtil.getEntry(classPK);
		doReindex(entry);
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

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK,
			String actionId) throws Exception {
		return EntryPermission.contain(permissionChecker, entryClassPK, entryClassName);
	}

	protected void reindexEntries(long companyId) throws PortalException, SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new EntryActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				Entry entry = (Entry) object;

				Document document = getDocument(entry);

				documents.add(document);
			}

		};

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents);
	}

}

/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.carlosduran.liferay.impersonation.sb.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import net.carlosduran.liferay.impersonation.sb.model.ImpersonationRegistry;
import net.carlosduran.liferay.impersonation.sb.service.ImpersonationRegistryLocalService;
import net.carlosduran.liferay.impersonation.sb.service.persistence.ImpersonationRegistryPersistence;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the impersonation registry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.carlosduran.liferay.impersonation.sb.service.impl.ImpersonationRegistryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see net.carlosduran.liferay.impersonation.sb.service.impl.ImpersonationRegistryLocalServiceImpl
 * @generated
 */
public abstract class ImpersonationRegistryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ImpersonationRegistryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ImpersonationRegistryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>net.carlosduran.liferay.impersonation.sb.service.ImpersonationRegistryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the impersonation registry to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistry the impersonation registry
	 * @return the impersonation registry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ImpersonationRegistry addImpersonationRegistry(
		ImpersonationRegistry impersonationRegistry) {

		impersonationRegistry.setNew(true);

		return impersonationRegistryPersistence.update(impersonationRegistry);
	}

	/**
	 * Creates a new impersonation registry with the primary key. Does not add the impersonation registry to the database.
	 *
	 * @param impersonationRegistryId the primary key for the new impersonation registry
	 * @return the new impersonation registry
	 */
	@Override
	@Transactional(enabled = false)
	public ImpersonationRegistry createImpersonationRegistry(
		long impersonationRegistryId) {

		return impersonationRegistryPersistence.create(impersonationRegistryId);
	}

	/**
	 * Deletes the impersonation registry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry that was removed
	 * @throws PortalException if a impersonation registry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ImpersonationRegistry deleteImpersonationRegistry(
			long impersonationRegistryId)
		throws PortalException {

		return impersonationRegistryPersistence.remove(impersonationRegistryId);
	}

	/**
	 * Deletes the impersonation registry from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistry the impersonation registry
	 * @return the impersonation registry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ImpersonationRegistry deleteImpersonationRegistry(
		ImpersonationRegistry impersonationRegistry) {

		return impersonationRegistryPersistence.remove(impersonationRegistry);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ImpersonationRegistry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return impersonationRegistryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.carlosduran.liferay.impersonation.sb.model.impl.ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return impersonationRegistryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.carlosduran.liferay.impersonation.sb.model.impl.ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return impersonationRegistryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return impersonationRegistryPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return impersonationRegistryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ImpersonationRegistry fetchImpersonationRegistry(
		long impersonationRegistryId) {

		return impersonationRegistryPersistence.fetchByPrimaryKey(
			impersonationRegistryId);
	}

	/**
	 * Returns the impersonation registry with the matching UUID and company.
	 *
	 * @param uuid the impersonation registry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching impersonation registry, or <code>null</code> if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry fetchImpersonationRegistryByUuidAndCompanyId(
		String uuid, long companyId) {

		return impersonationRegistryPersistence.fetchByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns the impersonation registry with the primary key.
	 *
	 * @param impersonationRegistryId the primary key of the impersonation registry
	 * @return the impersonation registry
	 * @throws PortalException if a impersonation registry with the primary key could not be found
	 */
	@Override
	public ImpersonationRegistry getImpersonationRegistry(
			long impersonationRegistryId)
		throws PortalException {

		return impersonationRegistryPersistence.findByPrimaryKey(
			impersonationRegistryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			impersonationRegistryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ImpersonationRegistry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"impersonationRegistryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			impersonationRegistryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			ImpersonationRegistry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"impersonationRegistryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			impersonationRegistryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ImpersonationRegistry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"impersonationRegistryId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return impersonationRegistryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return impersonationRegistryLocalService.deleteImpersonationRegistry(
			(ImpersonationRegistry)persistedModel);
	}

	public BasePersistence<ImpersonationRegistry> getBasePersistence() {
		return impersonationRegistryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return impersonationRegistryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the impersonation registry with the matching UUID and company.
	 *
	 * @param uuid the impersonation registry's UUID
	 * @param companyId the primary key of the company
	 * @return the matching impersonation registry
	 * @throws PortalException if a matching impersonation registry could not be found
	 */
	@Override
	public ImpersonationRegistry getImpersonationRegistryByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return impersonationRegistryPersistence.findByUuid_C_First(
			uuid, companyId, null);
	}

	/**
	 * Returns a range of all the impersonation registries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>net.carlosduran.liferay.impersonation.sb.model.impl.ImpersonationRegistryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of impersonation registries
	 * @param end the upper bound of the range of impersonation registries (not inclusive)
	 * @return the range of impersonation registries
	 */
	@Override
	public List<ImpersonationRegistry> getImpersonationRegistries(
		int start, int end) {

		return impersonationRegistryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of impersonation registries.
	 *
	 * @return the number of impersonation registries
	 */
	@Override
	public int getImpersonationRegistriesCount() {
		return impersonationRegistryPersistence.countAll();
	}

	/**
	 * Updates the impersonation registry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ImpersonationRegistryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param impersonationRegistry the impersonation registry
	 * @return the impersonation registry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ImpersonationRegistry updateImpersonationRegistry(
		ImpersonationRegistry impersonationRegistry) {

		return impersonationRegistryPersistence.update(impersonationRegistry);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ImpersonationRegistryLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		impersonationRegistryLocalService =
			(ImpersonationRegistryLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ImpersonationRegistryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ImpersonationRegistry.class;
	}

	protected String getModelClassName() {
		return ImpersonationRegistry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				impersonationRegistryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	protected ImpersonationRegistryLocalService
		impersonationRegistryLocalService;

	@Reference
	protected ImpersonationRegistryPersistence impersonationRegistryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}
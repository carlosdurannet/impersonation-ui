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

package net.carlosduran.liferay.impersonation.sb.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ImpersonationRegistry service. Represents a row in the &quot;cdnet_ImpersonationRegistry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>net.carlosduran.liferay.impersonation.sb.model.impl.ImpersonationRegistryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>net.carlosduran.liferay.impersonation.sb.model.impl.ImpersonationRegistryImpl</code>.
 * </p>
 *
 * @author Carlos Durán
 * @see ImpersonationRegistry
 * @generated
 */
@ProviderType
public interface ImpersonationRegistryModel
	extends BaseModel<ImpersonationRegistry>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a impersonation registry model instance should use the {@link ImpersonationRegistry} interface instead.
	 */

	/**
	 * Returns the primary key of this impersonation registry.
	 *
	 * @return the primary key of this impersonation registry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this impersonation registry.
	 *
	 * @param primaryKey the primary key of this impersonation registry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the impersonation registry ID of this impersonation registry.
	 *
	 * @return the impersonation registry ID of this impersonation registry
	 */
	public long getImpersonationRegistryId();

	/**
	 * Sets the impersonation registry ID of this impersonation registry.
	 *
	 * @param impersonationRegistryId the impersonation registry ID of this impersonation registry
	 */
	public void setImpersonationRegistryId(long impersonationRegistryId);

	/**
	 * Returns the company ID of this impersonation registry.
	 *
	 * @return the company ID of this impersonation registry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this impersonation registry.
	 *
	 * @param companyId the company ID of this impersonation registry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this impersonation registry.
	 *
	 * @return the user ID of this impersonation registry
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this impersonation registry.
	 *
	 * @param userId the user ID of this impersonation registry
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this impersonation registry.
	 *
	 * @return the user uuid of this impersonation registry
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this impersonation registry.
	 *
	 * @param userUuid the user uuid of this impersonation registry
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the screen name of this impersonation registry.
	 *
	 * @return the screen name of this impersonation registry
	 */
	@AutoEscape
	public String getScreenName();

	/**
	 * Sets the screen name of this impersonation registry.
	 *
	 * @param screenName the screen name of this impersonation registry
	 */
	public void setScreenName(String screenName);

	/**
	 * Returns the impersonated user ID of this impersonation registry.
	 *
	 * @return the impersonated user ID of this impersonation registry
	 */
	public long getImpersonatedUserId();

	/**
	 * Sets the impersonated user ID of this impersonation registry.
	 *
	 * @param impersonatedUserId the impersonated user ID of this impersonation registry
	 */
	public void setImpersonatedUserId(long impersonatedUserId);

	/**
	 * Returns the impersonated user uuid of this impersonation registry.
	 *
	 * @return the impersonated user uuid of this impersonation registry
	 */
	public String getImpersonatedUserUuid();

	/**
	 * Sets the impersonated user uuid of this impersonation registry.
	 *
	 * @param impersonatedUserUuid the impersonated user uuid of this impersonation registry
	 */
	public void setImpersonatedUserUuid(String impersonatedUserUuid);

	/**
	 * Returns the impersonated screen name of this impersonation registry.
	 *
	 * @return the impersonated screen name of this impersonation registry
	 */
	@AutoEscape
	public String getImpersonatedScreenName();

	/**
	 * Sets the impersonated screen name of this impersonation registry.
	 *
	 * @param impersonatedScreenName the impersonated screen name of this impersonation registry
	 */
	public void setImpersonatedScreenName(String impersonatedScreenName);

	/**
	 * Returns the operation date of this impersonation registry.
	 *
	 * @return the operation date of this impersonation registry
	 */
	public Date getOperationDate();

	/**
	 * Sets the operation date of this impersonation registry.
	 *
	 * @param operationDate the operation date of this impersonation registry
	 */
	public void setOperationDate(Date operationDate);

	/**
	 * Returns the operation result of this impersonation registry.
	 *
	 * @return the operation result of this impersonation registry
	 */
	public int getOperationResult();

	/**
	 * Sets the operation result of this impersonation registry.
	 *
	 * @param operationResult the operation result of this impersonation registry
	 */
	public void setOperationResult(int operationResult);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		net.carlosduran.liferay.impersonation.sb.model.ImpersonationRegistry
			impersonationRegistry);

	@Override
	public int hashCode();

	@Override
	public CacheModel
		<net.carlosduran.liferay.impersonation.sb.model.ImpersonationRegistry>
			toCacheModel();

	@Override
	public net.carlosduran.liferay.impersonation.sb.model.ImpersonationRegistry
		toEscapedModel();

	@Override
	public net.carlosduran.liferay.impersonation.sb.model.ImpersonationRegistry
		toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}
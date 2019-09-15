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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the ImpersonationRegistry service. Represents a row in the &quot;cdnet_ImpersonationRegistry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Carlos Durán
 * @see ImpersonationRegistryModel
 * @generated
 */
@ImplementationClassName(
	"net.carlosduran.liferay.impersonation.sb.model.impl.ImpersonationRegistryImpl"
)
@ProviderType
public interface ImpersonationRegistry
	extends ImpersonationRegistryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>net.carlosduran.liferay.impersonation.sb.model.impl.ImpersonationRegistryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ImpersonationRegistry, Long>
		IMPERSONATION_REGISTRY_ID_ACCESSOR =
			new Accessor<ImpersonationRegistry, Long>() {

				@Override
				public Long get(ImpersonationRegistry impersonationRegistry) {
					return impersonationRegistry.getImpersonationRegistryId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ImpersonationRegistry> getTypeClass() {
					return ImpersonationRegistry.class;
				}

			};

}
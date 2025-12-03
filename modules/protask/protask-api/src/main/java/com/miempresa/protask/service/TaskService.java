/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.miempresa.protask.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.miempresa.protask.model.Task;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TaskService extends BaseService {

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(method = "GET", value = "get-all")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getAll();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(method = "GET", value = "get-all-tasks")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getAllTasks();

	public String getOSGiServiceIdentifier();

	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(method = "GET", value = "test")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String test();

}
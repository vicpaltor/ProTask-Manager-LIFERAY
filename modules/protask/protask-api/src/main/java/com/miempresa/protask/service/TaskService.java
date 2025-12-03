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

/**
 * Provides the remote service interface for Task. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TaskServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TaskService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.miempresa.protask.service.impl.TaskServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the task remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TaskServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Gets all tasks (alternative method name for testing).
	 *
	 * URL: /api/jsonws/protask.task/get-all
	 *
	 * @return List of all tasks
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(method = "GET", value = "get-all")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getAll();

	/**
	 * Gets all tasks.
	 *
	 * This method is exposed as a JSON Web Service and allows guest access.
	 * URL: /api/jsonws/protask.task/get-all-tasks
	 *
	 * @return List of all tasks
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(method = "GET", value = "get-all-tasks")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getAllTasks();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Health check method to verify service is accessible.
	 *
	 * URL: /api/jsonws/protask.task/test
	 *
	 * @return Simple response indicating service is working
	 */
	@AccessControlled(guestAccessEnabled = true)
	@JSONWebService(method = "GET", value = "test")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String test();

}
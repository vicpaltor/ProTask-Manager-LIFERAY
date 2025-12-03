/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.miempresa.protask.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import com.miempresa.protask.model.Task;

import java.util.List;

/**
 * Provides the remote service utility for Task. This utility wraps
 * <code>com.miempresa.protask.service.impl.TaskServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TaskService
 * @generated
 */
public class TaskServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.miempresa.protask.service.impl.TaskServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Gets all tasks (alternative method name for testing).
	 *
	 * URL: /api/jsonws/protask.task/get-all
	 *
	 * @return List of all tasks
	 */
	public static List<Task> getAll() {
		return getService().getAll();
	}

	/**
	 * Gets all tasks.
	 *
	 * This method is exposed as a JSON Web Service and allows guest access.
	 * URL: /api/jsonws/protask.task/get-all-tasks
	 *
	 * @return List of all tasks
	 */
	public static List<Task> getAllTasks() {
		return getService().getAllTasks();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Health check method to verify service is accessible.
	 *
	 * URL: /api/jsonws/protask.task/test
	 *
	 * @return Simple response indicating service is working
	 */
	public static String test() {
		return getService().test();
	}

	public static TaskService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<TaskService> _serviceSnapshot =
		new Snapshot<>(TaskServiceUtil.class, TaskService.class);

}
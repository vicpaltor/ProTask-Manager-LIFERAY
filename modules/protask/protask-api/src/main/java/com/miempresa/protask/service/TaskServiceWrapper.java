/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.miempresa.protask.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TaskService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskService
 * @generated
 */
public class TaskServiceWrapper
	implements ServiceWrapper<TaskService>, TaskService {

	public TaskServiceWrapper() {
		this(null);
	}

	public TaskServiceWrapper(TaskService taskService) {
		_taskService = taskService;
	}

	/**
	 * Gets all tasks (alternative method name for testing).
	 *
	 * URL: /api/jsonws/protask.task/get-all
	 *
	 * @return List of all tasks
	 */
	@Override
	public java.util.List<com.miempresa.protask.model.Task> getAll() {
		return _taskService.getAll();
	}

	/**
	 * Gets all tasks.
	 *
	 * This method is exposed as a JSON Web Service and allows guest access.
	 * URL: /api/jsonws/protask.task/get-all-tasks
	 *
	 * @return List of all tasks
	 */
	@Override
	public java.util.List<com.miempresa.protask.model.Task> getAllTasks() {
		return _taskService.getAllTasks();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskService.getOSGiServiceIdentifier();
	}

	/**
	 * Health check method to verify service is accessible.
	 *
	 * URL: /api/jsonws/protask.task/test
	 *
	 * @return Simple response indicating service is working
	 */
	@Override
	public String test() {
		return _taskService.test();
	}

	@Override
	public TaskService getWrappedService() {
		return _taskService;
	}

	@Override
	public void setWrappedService(TaskService taskService) {
		_taskService = taskService;
	}

	private TaskService _taskService;

}
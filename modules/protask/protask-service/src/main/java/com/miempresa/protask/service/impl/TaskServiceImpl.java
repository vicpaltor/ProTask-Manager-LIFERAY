package com.miempresa.protask.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.miempresa.protask.model.Task;
import com.miempresa.protask.service.base.TaskServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * Implementation of the remote service for Task.
 * 
 * @author Victor
 */
@Component(
	property = {
		"json.web.service.context.name=protask",
		"json.web.service.context.path=Task"
	},
	service = AopService.class
)
public class TaskServiceImpl extends TaskServiceBaseImpl {

	/**
	 * Gets all tasks.
	 * 
	 * This method is exposed as a JSON Web Service and allows guest access.
	 * URL: /api/jsonws/protask.task/get-all-tasks
	 * 
	 * @return List of all tasks
	 */
	@JSONWebService(method = "GET", value = "get-all-tasks")
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public List<Task> getAllTasks() {
		_log.info(">>> JSONWS: Getting all tasks - Request received");
		
		try {
			List<Task> tasks = taskLocalService.getTasks(-1, -1);
			_log.info(">>> JSONWS: Returning " + tasks.size() + " tasks");
			return tasks;
		} catch (Exception e) {
			_log.error("Error getting all tasks", e);
			throw e;
		}
	}

	/**
	 * Gets all tasks (alternative method name for testing).
	 * 
	 * URL: /api/jsonws/protask.task/get-all
	 * 
	 * @return List of all tasks
	 */
	@JSONWebService(method = "GET", value = "get-all")
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getAll() {
		return getAllTasks();
	}

	/**
	 * Health check method to verify service is accessible.
	 * 
	 * URL: /api/jsonws/protask.task/test
	 * 
	 * @return Simple response indicating service is working
	 */
	@JSONWebService(method = "GET", value = "test")
	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String test() {
		_log.info(">>> JSONWS: Test endpoint called - Service is accessible");
		return "ProTask Service is working! Use /api/jsonws/protask.task/get-all-tasks to get tasks.";
	}

	private static final Log _log = LogFactoryUtil.getLog(TaskServiceImpl.class);
}
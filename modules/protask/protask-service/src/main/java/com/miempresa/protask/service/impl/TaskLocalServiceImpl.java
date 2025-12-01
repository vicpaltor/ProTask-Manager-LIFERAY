package com.miempresa.protask.service.impl;

import com.liferay.portal.aop.AopService;

import com.miempresa.protask.model.Task;
import com.miempresa.protask.service.base.TaskLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.miempresa.protask.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	/**
	 * Método de negocio para crear una nueva tarea de forma segura.
	 */
	public Task addTask(String title, String description, Date dueDate){
		// 1. Generar ID autoincremental (Clave Primaria)
		long taskId = counterLocalService.increment(Task.class.getName());
		// 2. Crear la instancia vacía (en memoria)
		Task task = taskPersistence.create(taskId);
		// 3. Rellenar los datos
		task.setTitle(title);
		task.setDescription(description);
		task.setDueDate(dueDate);
		task.setStatus(0); // 0 = Pendiente
		// Campos de auditoría (normalmente vienen del ServiceContext, hoy los simulamos)
		task.setCreateDate(new Date());
		task.setModifiedDate(new Date());
		task.setUserName("Usuario Test");
		return taskPersistence.update(task);
	}


}
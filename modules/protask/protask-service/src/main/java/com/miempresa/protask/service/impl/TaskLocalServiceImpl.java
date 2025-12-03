package com.miempresa.protask.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.miempresa.protask.model.Task;
import com.miempresa.protask.service.base.TaskLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.miempresa.protask.exception.TaskValidationException;
import java.util.Date;

@Component(
	property = "model.class.name=com.miempresa.protask.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	public Task addTask(String title, String description, Date dueDate, ServiceContext serviceContext)
			throws PortalException {

		// --- 1. VALIDACIONES DE ENTRADA ---

		// Usamos Validator de Liferay (es null-safe)
		if (Validator.isNull(title)) {
			throw new TaskValidationException("El título de la tarea es obligatorio.");
		}

		if (Validator.isNotNull(dueDate) && dueDate.before(new Date())) {
			// Nota: En un entorno real seríamos más flexibles con las horas, pero para el ejemplo sirve.
			throw new TaskValidationException("La fecha de vencimiento no puede ser pasada.");
		}

		// --- 2. OBTENER DATOS DEL CONTEXTO (Auditoría Real) ---
		// ServiceContext nos da el usuario actual, el grupo (site) y la compañía.
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		long companyId = serviceContext.getCompanyId();
		String userName = "Sistema"; // Fallback por si no hay usuario logueado

		// Intentamos obtener el nombre real del usuario si existe
		if (userId > 0) {
			try {
				userName = userLocalService.getUser(userId).getFullName();
			} catch (Exception e) {
				// Ignoramos si no encontramos al usuario, seguimos con "Sistema"
			}
		}

		// --- 3. CREACIÓN ---
		long taskId = counterLocalService.increment(Task.class.getName());
		Task task = taskPersistence.create(taskId);

		task.setUuid(serviceContext.getUuid());
		task.setGroupId(groupId);
		task.setCompanyId(companyId);
		task.setUserId(userId);
		task.setUserName(userName);
		task.setCreateDate(serviceContext.getCreateDate(new Date()));
		task.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		task.setTitle(title);
		task.setDescription(description);
		task.setDueDate(dueDate);
		task.setStatus(0); // Pendiente

		// --- 4. PERSISTENCIA ---
		return taskPersistence.update(task);
	}
}

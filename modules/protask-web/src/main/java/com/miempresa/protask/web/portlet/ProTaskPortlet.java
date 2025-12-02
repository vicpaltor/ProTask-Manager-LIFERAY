package com.miempresa.protask.web.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.miempresa.protask.model.Task;
import com.miempresa.protask.service.TaskLocalService;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property = {
				"com.liferay.portlet.display-category=category.sample", // Categoría en el menú de widgets
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=ProTask Manager",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=com_miempresa_protask_web_ProTaskPortlet",
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class ProTaskPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// 1. Llamar al servicio para obtener todas las tareas
		// (start=-1, end=-1 significa "traeme todas sin paginar")
		List<Task> taskList = _taskLocalService.getTasks(-1, -1);

		// 2. Pasar la lista a la vista (JSP)
		renderRequest.setAttribute("listaDeTareas", taskList);

		// 3. Continuar con el renderizado normal (mostrar view.jsp)
		super.render(renderRequest, renderResponse);


	}

	// Inyección del Servicio (OSGi)
	@Reference
	private TaskLocalService _taskLocalService;
}
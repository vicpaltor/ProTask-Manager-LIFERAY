package com.miempresa.protask.web.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.miempresa.protask.service.TaskLocalService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                // 1. Vinculamos esta clase con tu Portlet principal
                "javax.portlet.name=com_miempresa_protask_web_ProTaskPortlet",
                // 2. Definimos el nombre de la acción (debe coincidir con el JSP: name="addTask")
                "mvc.command.name=addTask"
        },
        service = MVCActionCommand.class
)
public class AddTaskActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        // --- 1. Recoger datos del formulario ---
        // Usamos ParamUtil para evitar NullPointers y conversiones manuales

        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");

        // Las fechas son delicadas. El input type="date" envía "yyyy-MM-dd"
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate = ParamUtil.getDate(actionRequest, "dueDate", dateFormat);

        // --- 2. Validar (Básico) ---
        if (title == null || title.isEmpty()) {
            // En un caso real, aquí enviaríamos un error al usuario
            System.out.println("ERROR: El título es obligatorio");
            return;
        }

        // --- 3. Llamar al Servicio (Backend) ---
        try {
            _taskLocalService.addTask(title, description, dueDate);
            System.out.println("✅ Tarea guardada con éxito: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Al terminar, Liferay redirigirá automáticamente a la vista por defecto (view.jsp)
    }

    // Inyección del servicio
    @Reference
    private TaskLocalService _taskLocalService;
}
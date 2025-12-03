package com.miempresa.protask.web.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.miempresa.protask.model.Task;
import com.miempresa.protask.service.TaskLocalService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=com_miempresa_protask_web_ProTaskPortlet",
                "mvc.command.name=addTask"
        },
        service = MVCActionCommand.class
)
public class AddTaskActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dueDate = ParamUtil.getDate(actionRequest, "dueDate", dateFormat);

        if (title == null || title.isEmpty()) {
            System.out.println("ERROR: El título es obligatorio");
            return;
        }

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Task.class.getName(), actionRequest);
            _taskLocalService.addTask(title, description, dueDate, serviceContext);
            System.out.println("✅ Tarea guardada con éxito: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Reference
    private TaskLocalService _taskLocalService;
}
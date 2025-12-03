package com.miempresa.protask.service.impl;

import com.miempresa.protask.service.TaskLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

@Component(
        property = {
                "osgi.command.function=add",  // Command name
                "osgi.command.scope=protask"  // Command scope
        },
        service = Object.class
)
public class TaskCommand {

    @Reference
    private TaskLocalService _taskLocalService;

    // Este método se ejecutará cuando escribas "protask:add" en la consola
    public void add(String title, String description) {
        System.out.println("--- Ejecutando comando protask:add ---");

        try {
            _taskLocalService.addTask(title, description, new Date());
            System.out.println("✅ Tarea creada correctamente: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
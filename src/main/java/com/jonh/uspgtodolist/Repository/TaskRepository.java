package com.jonh.uspgtodolist.Repository;

import com.jonh.uspgtodolist.Model.TaskModel;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TaskRepository {

    private final List<TaskModel> tasks = new ArrayList<>();

    // Obtener todas las tareas
    public List<TaskModel> getTasks() {
        return tasks;
    }

    // Agregar nueva tarea
    public void add(TaskModel task) {
        tasks.add(task);
    }

    // Eliminar tarea
    public void remove(TaskModel task) {
        tasks.remove(task);
    }
}

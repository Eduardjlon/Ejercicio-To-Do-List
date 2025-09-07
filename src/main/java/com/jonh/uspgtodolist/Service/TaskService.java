package com.jonh.uspgtodolist.Service;

import com.jonh.uspgtodolist.Model.TaskModel;
import com.jonh.uspgtodolist.Repository.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TaskService {

    @Inject
    private TaskRepository repository;

    // Obtener todas las tareas
    public List<TaskModel> getAllTasks() {
        return repository.getTasks();
    }

    // Agregar nueva tarea
    public void addTask(String description) {
        repository.add(new TaskModel(description));
    }

    // Eliminar tarea
    public void removeTask(TaskModel task) {
        repository.remove(task);
    }

    // Marcar o desmarcar tarea como completada
    public void toggleCompleted(TaskModel task) {
        task.setCompleted(!task.isCompleted());
    }
}

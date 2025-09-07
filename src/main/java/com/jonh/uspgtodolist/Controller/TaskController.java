package com.jonh.uspgtodolist.Controller;

import com.jonh.uspgtodolist.Model.TaskModel;
import com.jonh.uspgtodolist.Service.TaskService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("taskController")
@SessionScoped
public class TaskController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TaskService taskService;

    private String newTaskDescription;

    public String getNewTaskDescription() {
        return newTaskDescription;
    }

    public void setNewTaskDescription(String newTaskDescription) {
        this.newTaskDescription = newTaskDescription;
    }

    /** Agregar nueva tarea */
    public void addTask() {
        if (newTaskDescription == null || newTaskDescription.trim().isEmpty()) {
            addMessage(FacesMessage.SEVERITY_WARN, "Error", "No puedes agregar una tarea vacía");
            return;
        }

        taskService.addTask(newTaskDescription);
        addMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Tarea agregada con éxito");
        newTaskDescription = "";
    }

    /** Eliminar tarea */
    public void removeTask(TaskModel task) {
        taskService.removeTask(task);
        addMessage(FacesMessage.SEVERITY_WARN, "Eliminada", "La tarea fue eliminada correctamente");
    }

    /** Marcar o desmarcar tarea como completada */
    public void toggleCompleted(TaskModel task) {
        taskService.toggleCompleted(task);
        if (task.isCompleted()) {
            addMessage(FacesMessage.SEVERITY_INFO, "Completada", "La tarea fue realizada con éxito");
        } else {
            addMessage(FacesMessage.SEVERITY_INFO, "Pendiente", "La tarea ha sido marcada como pendiente");
        }
    }

    /** Obtener lista de tareas */
    public List<TaskModel> getTasks() {
        return taskService.getAllTasks();
    }

    /** Helper para lanzar mensajes al Growl */
    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
}

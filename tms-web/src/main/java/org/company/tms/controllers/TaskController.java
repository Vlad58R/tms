package org.company.tms.controllers;

import org.company.tms.models.Task;
import org.company.tms.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("tasks", taskService.findTasks());
        return "index";
    }

    @GetMapping("/task")
    public String viewTaskPage(@RequestParam(name = "id", required = true) Integer id, Model model) {
        model.addAttribute("task", taskService.findTaskById(id));
        return "taskView";
    }

    @GetMapping("/task/create")
    public String createTaskPage(Model model) {
        model.addAttribute("task", new Task());
        return "taskCreate";
    }

    @GetMapping("/task/update")
    public String updateTaskPage(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", taskService.findTaskById(id));
        return "taskUpdate";
    }

    @RequestMapping(value = "/create-task", method = RequestMethod.POST)
    public RedirectView createTask(@ModelAttribute("task") Task task) {
        taskService.createTask(task);
        return new RedirectView ("/");
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.POST)
    public RedirectView updateTask(@ModelAttribute("task") Task task) {
        taskService.updateTask(task);
        return new RedirectView ("/");
    }

    @RequestMapping(value = "/delete-task", method = RequestMethod.POST)
    public RedirectView deleteTask(@RequestParam Integer id) {
        taskService.deleteTask(id);
        return new RedirectView ("/");
    }
}

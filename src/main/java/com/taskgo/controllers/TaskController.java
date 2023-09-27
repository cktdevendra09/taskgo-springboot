package com.taskgo.controllers;

import com.taskgo.entities.TaskEntity;
import com.taskgo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taskgo")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @CrossOrigin(origins = "*")
    @GetMapping("/{getStatus}")
    public List<TaskEntity> getAllByStatus(@PathVariable boolean getStatus){
        return this.taskService.getAllByStatus(getStatus);
    }    

    @PostMapping
    public String postTask(@RequestBody TaskEntity taskEntity){
        return this.taskService.postTask(taskEntity);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public String taskStatus(@PathVariable int id){
        return this.taskService.taskStatus(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return this.taskService.deleteById(id);
    }
}

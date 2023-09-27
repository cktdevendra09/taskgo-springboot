package com.taskgo.services;

import com.taskgo.entities.TaskEntity;

import java.util.List;

public interface TaskService {

    List<TaskEntity> getAllByStatus(boolean getStatus);
        
    String postTask(TaskEntity taskEntity);

    String taskStatus(int id);
    String deleteById(int id);
}

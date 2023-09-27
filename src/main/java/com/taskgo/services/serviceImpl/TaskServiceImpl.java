package com.taskgo.services.serviceImpl;

import com.taskgo.entities.TaskEntity;
import com.taskgo.repository.TaskRepo;
import com.taskgo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public List<TaskEntity> getAllByStatus(boolean getStatus) {
        return taskRepo.findAllByStatus(getStatus);
    }

    @Override
    public String postTask(TaskEntity taskEntity) {
        TaskEntity data = taskEntity;
        data.setCreated_at(new Date());
        this.taskRepo.save(data);
        return "DataSaved";
    }

    @Override
    public String taskStatus(TaskEntity taskEntity, int id) {
        Optional<TaskEntity> task = this.taskRepo.findById(id);
        if (task.isPresent()){
            TaskEntity existTask = task.get();
            existTask.setStatus(taskEntity.isStatus());
            this.taskRepo.save(existTask);
            return "Updated";
        }
        return "Invalid userId ";
    }

    @Override
    public String deleteById(int id) {
        Optional<TaskEntity> task = this.taskRepo.findById(id);
        if (task.isPresent()){
            this.taskRepo.deleteById(id);
            return "Deleted";
        }
        return "Invalid userId";
    }
}

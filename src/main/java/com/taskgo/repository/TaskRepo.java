package com.taskgo.repository;

import com.taskgo.entities.TaskEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity,Integer> {

    
    List<TaskEntity> findAllByStatus(boolean getStatus);
    
}

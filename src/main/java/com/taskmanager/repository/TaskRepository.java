package com.taskmanager.repository;

import java.util.List;

import com.taskmanager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  @Query("SELECT a.tasks FROM Account a where a.id = :id")
  List<Task> findAllTasksByAccountId(@Param("id")long accountId);

}
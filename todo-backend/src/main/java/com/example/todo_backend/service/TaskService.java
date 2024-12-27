package com.example.todo_backend.service;

import com.example.todo_backend.model.Task;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService extends AbstractInMemoryService<Task, Long> {
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(idGenerator.incrementAndGet());
        }
        return super.save(task);
    }

    @Override
    public Task update(Long id, Task updatedTask) {
        Task existingTask = findById(id);
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        return existingTask;
    }

    @Override
    protected boolean matchesId(Task task, Long id) {
        return task.getId().equals(id);
    }
}
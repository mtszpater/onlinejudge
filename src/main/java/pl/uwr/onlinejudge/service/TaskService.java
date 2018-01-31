package pl.uwr.onlinejudge.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.uwr.onlinejudge.model.entity.Task;
import pl.uwr.onlinejudge.repository.AccountRepository;
import pl.uwr.onlinejudge.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private ObjectMapper objectMapper;
    private AccountRepository accountRepository;
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, ObjectMapper objectMapper, AccountRepository accountRepository) {
        this.objectMapper = objectMapper;
        this.accountRepository = accountRepository;
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

}

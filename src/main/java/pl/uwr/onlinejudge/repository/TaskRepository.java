package pl.uwr.onlinejudge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uwr.onlinejudge.model.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

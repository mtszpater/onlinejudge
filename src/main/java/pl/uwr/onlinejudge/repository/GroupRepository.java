package pl.uwr.onlinejudge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.uwr.onlinejudge.model.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}

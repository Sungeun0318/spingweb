package practice1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice1.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}

package cl.coopeuch.back.repository;

import cl.coopeuch.back.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Integer> {

}

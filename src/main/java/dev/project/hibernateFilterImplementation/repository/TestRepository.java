package dev.project.hibernateFilterImplementation.repository;

import dev.project.hibernateFilterImplementation.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}

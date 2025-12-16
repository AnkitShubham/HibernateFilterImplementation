package dev.project.hibernateFilterImplementation.service;

import dev.project.hibernateFilterImplementation.annotation.EnableCountryFilter;
import dev.project.hibernateFilterImplementation.entity.TestEntity;
import dev.project.hibernateFilterImplementation.repository.TestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableCountryFilter
public class TestService {
    @Autowired
    private TestRepository testRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<TestEntity> findAll() {
        return testRepo.findAll();
    }
}

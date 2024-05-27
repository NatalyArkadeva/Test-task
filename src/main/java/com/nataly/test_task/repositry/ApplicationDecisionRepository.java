package com.nataly.test_task.repositry;

import com.nataly.test_task.model.ApplicationDecisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationDecisionRepository extends JpaRepository<ApplicationDecisionEntity, Long> {

    @Query("select d from ApplicationDecisionEntity d where d.application.inn =:inn")
    Optional<ApplicationDecisionEntity> findByApplicationInn(String inn);
}

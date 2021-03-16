package com.task.dekadabackend.repo;

import com.task.dekadabackend.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    Email getEmailById(Long id);
    Email getEmailByTitle(String title);
    Email saveEmail(Email email);
    void deleteEmail(Email email);
}

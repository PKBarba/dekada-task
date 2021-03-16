package com.task.dekadabackend.controller;

import com.task.dekadabackend.model.Email;
import com.task.dekadabackend.repo.EmailRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CrudEmailController {

    private final EmailRepositoryImpl emailRepo;

    public CrudEmailController(EmailRepositoryImpl emailRepo) {
        this.emailRepo = emailRepo;
    }

    @PostMapping("/email")
    public ResponseEntity<Email> saveEmail(@RequestBody Email email){
        try {
            return new ResponseEntity<>(emailRepo.saveEmail(email), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/email/{id}")
    public ResponseEntity<Email> getEmail(@PathVariable Long id){
        Optional<Email> email = Optional.ofNullable(emailRepo.getEmailById(id));
        return email.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/emails")
    public List<Email> getAllEmails(){
        return emailRepo.findAll();
    }

    @PutMapping("/email")
    public void updateEmail(){

    }

    @DeleteMapping("/email")
    public void deleteEmail(){

    }
}

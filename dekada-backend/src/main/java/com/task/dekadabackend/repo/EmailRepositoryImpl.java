package com.task.dekadabackend.repo;

import com.task.dekadabackend.model.Email;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class EmailRepositoryImpl implements EmailRepository {

    private final EntityManager em;

    public EmailRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Email saveEmail(Email email) {
        if (email.getId() == null) {
            em.persist(email);
        } else {
            em.merge(email);
        }
        return email;
    }

    @Override
    public Email getEmailById(Long id) {
        return em.find(Email.class, id);
    }

    @Override
    public List<Email> findAll() {
        TypedQuery<Email> query = em.createQuery("SELECT e FROM Email e", Email.class);
        return query.getResultList();
    }

    @Override
    public void deleteEmail(Email email) {
        if (em.contains(email)) {
            em.remove(email);
        } else {
            em.merge(email);
        }
    }

    @Override
    public void deleteById(Long id) {
        Email email = getEmailById(id);
        if (em.contains(email)) {
            em.remove(email);
        } else {
            em.merge(email);
        }
    }

    @Override
    public Email getEmailByTitle(String title) {
        return null;
    }

    @Override
    public List<Email> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Email> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Email entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Email> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Email> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Email> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Email> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Email> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Email> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Email getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Email> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Email> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Email> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Email> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Email> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Email> boolean exists(Example<S> example) {
        return false;
    }
}

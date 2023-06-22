package ru.izimin.jpaspecificationsdemo.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.izimin.jpaspecificationsdemo.dao.UserRepository;
import ru.izimin.jpaspecificationsdemo.dao.entity.User;
import ru.izimin.jpaspecificationsdemo.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    private User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id=" + id + " не найден"));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<User> findAll(Specification<User> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }
}

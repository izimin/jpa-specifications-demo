package ru.izimin.jpaspecificationsdemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ru.izimin.jpaspecificationsdemo.dao.entity.User;

public interface UserService {

    Page<User> findAll(Specification<User> specification, Pageable pageable);
}

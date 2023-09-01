package com.example.vaadin.demo.repository;

import com.example.vaadin.demo.domain.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAccount, Integer> {
}

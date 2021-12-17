package com.example.mylibraryproject.repository;

import com.example.mylibraryproject.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, String> {
}

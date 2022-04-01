package com.pichincha.msastore.repository;

import com.pichincha.msastore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

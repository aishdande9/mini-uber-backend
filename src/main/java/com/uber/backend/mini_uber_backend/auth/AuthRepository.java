package com.uber.backend.mini_uber_backend.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends CrudRepository<AuthUserDetails,Long> {
}

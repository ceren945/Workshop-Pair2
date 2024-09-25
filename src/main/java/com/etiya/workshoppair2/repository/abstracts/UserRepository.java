package com.etiya.workshoppair2.repository.abstracts;

import com.etiya.workshoppair2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer > {
}

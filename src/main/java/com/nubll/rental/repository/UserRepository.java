package com.nubll.rental.repository;

import com.nubll.rental.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}

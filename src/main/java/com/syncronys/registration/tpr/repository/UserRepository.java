package com.syncronys.registration.tpr.repository;

import com.syncronys.registration.tpr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findByUserNameAndSsn(String userName, String ssn);
}

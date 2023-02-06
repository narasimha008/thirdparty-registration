package com.syncronys.registration.tpr.repository;

import com.syncronys.registration.tpr.entity.Client;
import com.syncronys.registration.tpr.entity.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

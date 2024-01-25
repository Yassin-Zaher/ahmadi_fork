package com.codewitharjun.fullstackbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.codewitharjun.fullstackbackend.model.Daret;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface DaretRepository extends JpaRepository<Daret, Long> {

}
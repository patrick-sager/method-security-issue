package com.example.methodsecurity.repository;

import com.example.methodsecurity.entity.Thing;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@PreAuthorize("hasRole('admin')")
public interface ThingRepository
    extends JpaRepository<Thing, Long>, CustomThingRepository {

  @Override
  @PreAuthorize("hasRole('user')")
  List<Thing> findAll();

}

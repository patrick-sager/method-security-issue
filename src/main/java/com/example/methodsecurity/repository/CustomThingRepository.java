package com.example.methodsecurity.repository;

import com.example.methodsecurity.entity.Thing;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CustomThingRepository {

  @PreAuthorize("hasRole('user')")
  List<Thing> findWithOddIds();

}

package com.example.methodsecurity.repository.impl;

import com.example.methodsecurity.entity.Thing;
import com.example.methodsecurity.repository.CustomThingRepository;
import com.example.methodsecurity.repository.ThingRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class CustomThingRepositoryImpl implements CustomThingRepository {

  @Autowired
  @Lazy
  private ThingRepository thingRepository;

  /**
   * A contrived example of a custom programmatic repository method.
   *
   * @return List of Things with odd IDs
   */
  @Override
  public List<Thing> findWithOddIds() {
    return thingRepository.findAll()
        .stream()
        .filter(thing -> thing.getId() % 2 == 1)
        .collect(Collectors.toList());
  }

}

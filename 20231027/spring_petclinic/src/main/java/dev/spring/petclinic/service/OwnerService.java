package dev.spring.petclinic.service;

import java.util.List;

import dev.spring.petclinic.model.Owner;

public interface OwnerService {
    List<Owner> findAll();

    Owner save(Owner owner);

    Owner findById(Long id);

    List<Owner> findAllByLastNameLike(String lastName);
}

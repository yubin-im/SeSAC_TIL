package dev.spring.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.spring.petclinic.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

    /*
     * JpaRepository - CRUD + 페이징 처리 기능을 제공하는 인터페이스
     *
     * CrudRepository - 기본적인 Crud 기능을 제공하는 인터페이스
     */

    List<Owner> findAllByLastNameLike(String lastName);

}

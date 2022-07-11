package com.vetalalien.miniservice.repository;

import java.util.Collection;
import java.util.Optional;

import com.vetalalien.miniservice.entity.PersonEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<PersonEntity> {

    Optional<PersonEntity> findById(Long id);

    Collection<PersonEntity> findAllByName(String name);

    @Query(value = "SELECT p.* FROM public.person p LIMIT 1", nativeQuery = true)
    PersonEntity findMyFirst();

}

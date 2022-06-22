package com.vetalalien.miniservice.repository;

import com.vetalalien.miniservice.entity.LongIdEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface BaseRepository<T extends LongIdEntity> extends CrudRepository<T, Long>, JpaSpecificationExecutor<T> {
}
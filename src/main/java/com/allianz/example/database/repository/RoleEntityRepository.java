package com.allianz.example.database.repository;

import com.allianz.example.database.entity.RoleEntity;
import com.allianz.example.database.entity.UserEntity;
import com.allianz.example.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends BaseRepository<RoleEntity> {
    Optional<RoleEntity> findByName(String name);

}

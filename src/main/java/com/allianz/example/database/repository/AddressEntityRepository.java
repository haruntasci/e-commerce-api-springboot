package com.allianz.example.database.repository;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressEntityRepository extends BaseRepository<AddressEntity> {
}

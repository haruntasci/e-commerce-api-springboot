package com.allianz.example.database.repository;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.util.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaxEntityRepository extends BaseRepository<TaxEntity> {
}

package com.allianz.example.database.repository;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.util.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryEntityRepository extends BaseRepository<CategoryEntity> {
}

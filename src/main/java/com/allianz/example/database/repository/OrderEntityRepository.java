package com.allianz.example.database.repository;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.util.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends BaseRepository<OrderEntity> {
}

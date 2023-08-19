package com.allianz.example.database.entity;

import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table
public class RoleEntity extends BaseEntity {
    @Column(unique = true)
    private String name;
    @Column
    private String description;
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;
}
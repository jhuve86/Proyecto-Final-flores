package com.flowers.ordering.system.repository;

import com.flowers.ordering.system.entity.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerJpaRepository extends JpaRepository<FlowerEntity, Integer> {
}
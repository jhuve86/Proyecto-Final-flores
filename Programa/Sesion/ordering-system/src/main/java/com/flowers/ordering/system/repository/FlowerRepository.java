package com.flowers.ordering.system.repository;

import com.flowers.ordering.system.entity.FlowerEntity;
import com.flowers.ordering.system.mapper.FlowerMapper;
import com.flowers.ordering.system.model.Flower;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FlowerRepository {
    private final FlowerJpaRepository flowerJpaRepository;
    private final FlowerMapper flowerMapper;

    public FlowerRepository(FlowerJpaRepository flowerJpaRepository, FlowerMapper flowerMapper) {
        this.flowerJpaRepository = flowerJpaRepository;
        this.flowerMapper = flowerMapper;
    }

public List<Flower> findAll() {
    return flowerJpaRepository.findAll().stream()
            .map(this.flowerMapper::flowerEntityToFlower)
            .toList();
}

public Flower save(Flower flower) {
    final FlowerEntity createdFlower = flowerJpaRepository.save(this.flowerMapper.flowerToFlowerEntity(flower));
    return this.flowerMapper.flowerEntityToFlower(createdFlower);
}

public Optional<Flower> findById(Integer id) {
    return this.flowerJpaRepository.findById(id)
            .map(this.flowerMapper::flowerEntityToFlower);
}

public void deleteById(Integer id) {
    this.flowerJpaRepository.deleteById(id);
}

}

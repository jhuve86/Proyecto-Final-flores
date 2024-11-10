package com.flowers.ordering.system.services;

import com.flowers.ordering.system.model.Flower;
import com.flowers.ordering.system.repository.FlowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }

    public Optional<Flower> findById(Integer id) {
        return this.flowerRepository.findById(id);
    }

    public Flower save(Flower flower) {
        return flowerRepository.save(flower);
    }

    public Flower deleteById(Integer id) {
        final var flower = this.flowerRepository.findById(id);
        if (flower.isPresent()) {
            this.flowerRepository.deleteById(id);
        }
        return flower.orElse(null);
    }
}


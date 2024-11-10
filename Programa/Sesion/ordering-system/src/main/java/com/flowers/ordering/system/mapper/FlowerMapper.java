package com.flowers.ordering.system.mapper;

import com.flowers.ordering.system.entity.FlowerEntity;
import com.flowers.ordering.system.model.Flower;
import org.springframework.stereotype.Component;

@Component
public class FlowerMapper {
    public FlowerEntity flowerToFlowerEntity(Flower flower) {
        return new FlowerEntity(
                flower.getId(),
                flower.getName(),
                flower.getColor(),
                flower.getImageUrl(),
                flower.getPrice()
        );
    }

    public Flower flowerEntityToFlower(FlowerEntity flowerEntity) {
        return new Flower(
                flowerEntity.getId(),
                flowerEntity.getName(),
                flowerEntity.getColor(),
                flowerEntity.getImageUrl(),
                flowerEntity.getPrice()
        );
    }
}

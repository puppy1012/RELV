package com.example.demo.controller.request;

import com.example.demo.entity.Fruit;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FruitRequest {
    String name;
    Long price;
    public Fruit toFruit(){
        return new Fruit(name,price);
    }
}

package com.example.demo.controller.request;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFruitRequest {
    Long postId;
    String name;
    Long price;
}

package com.isanuric.websample.flower;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Flower {

    private String name;
    private String color;
    private String order;

}


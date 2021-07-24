package com.isanuric.websample.flower;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Flower implements Serializable {

    private String name;
    private String color;
    private String order;

}


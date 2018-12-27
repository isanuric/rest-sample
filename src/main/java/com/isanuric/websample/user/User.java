package com.isanuric.websample.user;

/*
 * Project: web-sample
 * @author Ehsan Salmani
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class User {

    private @Id @GeneratedValue Long id;
    private @NonNull String name;
    private String description;

}

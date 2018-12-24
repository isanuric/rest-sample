package com.isanuric.websample.user;

/*
 * ----------------------------------------------
 * (c) 2018 Copyright iC Consult GmbH
 * <p/>
 * Project: web-sample
 * @author ehsan.salmani@ic-consult.de on 23/12/2018.
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
